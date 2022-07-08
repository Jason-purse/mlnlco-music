package club.smileboy.app.mlnlco.conventions;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.plugins.JavaPlugin;

import java.util.Collections;

/**
 * @author FLJ
 * @date 2022/7/8
 * @time 17:48
 * @Description 项目约定
 */
public class ProjectConventions implements org.gradle.api.Plugin<org.gradle.api.Project> {
    @Override
    public void apply(Project project) {
        configureDependencyManagement(project);
    }

    private void configureDependencyManagement(Project project) {
        ConfigurationContainer configurations = project.getConfigurations();
        // 创建一个配置,名为依赖管理 ... 不可见,且不能够被消费,无法被解析 ...
        Configuration dependencyManagement = configurations.create("dependencyManagement", (configuration) -> {
            configuration.setVisible(false);
            configuration.setCanBeConsumed(false);
            configuration.setCanBeResolved(false);
        });

        // 匹配 ***Classpath的配置 或者 注解处理器 ...
        configurations
                .matching((configuration) -> configuration.getName().endsWith("Classpath")
                        || JavaPlugin.ANNOTATION_PROCESSOR_CONFIGURATION_NAME.equals(configuration.getName()))
                .all((configuration) -> configuration.extendsFrom(dependencyManagement));


        //从项目的依赖中,处理 ...
        // 将它指定为一个平台依赖 ...
        // Java Platform 插件 可以发布平台工件(平台工件 一般有两种 一种是不直接产生二进制包的,另一种是) ...
        // 它的意思是增加一个项目依赖(但是类型是bom) ...
        Dependency springBootParent = project.getDependencies().enforcedPlatform(project.getDependencies()
                .project(Collections.singletonMap("path", ":spring-boot-project:spring-boot-parent")));
        dependencyManagement.getDependencies().add(springBootParent);

        // 可选依赖插件 ..
        // 例如 项目使用了可选依赖插件 ... 配置插件 ...
        // 这里返回的集合是活的 ... 任何动作都会被 重复 ...(例如新增一个元素到集合中 / 或者原始集合中新增了一个匹配此过滤器的元素) ..
        project.getPlugins().withType(OptionalDependenciesPlugin.class, (optionalDependencies) ->  {
            // 从配置中 获取 optional 让它也继承于依赖管理
            configurations
                    .getByName(OptionalDependenciesPlugin.OPTIONAL_CONFIGURATION_NAME).extendsFrom(dependencyManagement);
        });
    }
}
