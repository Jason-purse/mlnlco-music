package club.smileboy.app.mlnlco.conventions;

import org.gradle.api.Project;

/**
 * @author FLJ
 * @date 2022/7/8
 * @time 15:02
 * @Description 测试套件 约定
 */
public class TestConventions implements org.gradle.api.Plugin<org.gradle.api.Project> {
    public final static String JUPITER_VERSION = "5.7.0";
    public final static String JUPITER_NAMESPACE = "org.junit.jupiter";
    @Override
    public void apply(Project target) {
        // 直接判断 jupiter 然后设定版本
        target.getConfigurations().all(configuration -> configuration.resolutionStrategy(resolutionStrategy -> resolutionStrategy.eachDependency(dependencyResolveDetails -> {
            if (dependencyResolveDetails.getRequested().getGroup().equals(JUPITER_NAMESPACE)) {
                dependencyResolveDetails.useVersion(JUPITER_VERSION);
            }
        })));
    }
}
