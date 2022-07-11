package club.smileboy.app.mlnlco.config;

import club.smileboy.app.commons.mlnlco.utils.RequestUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 21:00
 * @description mlnlco 自动配置
 **/
@Configuration
public class MlnlcoAutoConfiguration {

    @Bean
    public RequestUtil.LocaleInterceptor localeInterceptor() {
        return new RequestUtil.LocaleInterceptor();
    }
}
