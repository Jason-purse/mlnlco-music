package club.smileboy.app.mlnlco.conventions;

import org.gradle.api.Project;

/**
 * @author FLJ
 * @date 2022/7/8
 * @time 17:48
 * @Description 项目约定 使用Spring boot的依赖管理
 */
public class ProjectConventions implements org.gradle.api.Plugin<org.gradle.api.Project> {

    private final static String  SPRING_BOOT_PLUGIN = "org.springframework.boot";
    private final static String  SPRING_DEPENDENCY_MANAGEMENT_PLUGIN = "io.spring.dependency-management";
    private final static String JETBRAINS_SPRING_PLUGIN = "org.jetbrains.kotlin.plugin.spring";
    private final static String JETBRAINS_ALL_OPEN_PLUGIN = "org.jetbrains.kotlin.plugin.allopen";
    private final static String JETBRAINS_LOMBOK_PLUGIN = "org.jetbrains.kotlin.plugin.lombok";

    private final static String SWAGGER_VERSION = "2.9.2";
    @Override
    public void apply(Project project) {

        project.getPlugins().apply(SPRING_BOOT_PLUGIN);
        project.getPlugins().apply(SPRING_DEPENDENCY_MANAGEMENT_PLUGIN);
        // spring-session 依赖管理
//        final DependencyManagementExtension extension = project.getExtensions().getByType(DependencyManagementExtension.class);
//        extension.imports(handler -> handler.mavenBom("org.springframework.session:spring-session-bom:2021.1.1"));

//        project.getConfigurations().getByName("implementation",configuration -> {
//            // 这里的版本解析交给了 settings中的依赖解析策略 ...
//           configuration.getDependencies().add(new DefaultExternalModuleDependency("org.jetbrains.kotlin","kotlin-gradle-plugin",project.getProperties().get("kotlinVersion").toString()));
//        });

        project.getPlugins().apply(JETBRAINS_SPRING_PLUGIN);
        project.getPlugins().apply(JETBRAINS_ALL_OPEN_PLUGIN);
        project.getPlugins().apply(JETBRAINS_LOMBOK_PLUGIN);


        //引入Swagger 2
        project.getConfigurations().all(configuration -> configuration.getResolutionStrategy().eachDependency(dependencyResolveDetails -> {
            if (dependencyResolveDetails.getRequested().getGroup().equals("io.springfox")) {
                dependencyResolveDetails.useVersion(SWAGGER_VERSION);
            }
        }));
    }




}
