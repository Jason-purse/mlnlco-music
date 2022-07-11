package club.smileboy.app.commons.mlnlco.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 20:40
 * @description 请求工具类 ...
 *
 * 需要将LocaleInterceptor 注入到Spring ioc 容器中
 **/
public class RequestUtil {

    /**
     * 获取 Request Locale
     */
    public static class LocaleInterceptor implements HandlerInterceptor {
        private final  static  ThreadLocal<Locale> localeThreadLocal = new ThreadLocal<>();
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            localeThreadLocal.set(RequestContextUtils.getLocale(request));
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            localeThreadLocal.set(null);
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            localeThreadLocal.set(null);
        }
    }

    /**
     * 获取当前请求的Locale ...
     * @return null / Locale ,如果null,则表示不在请求 HandleMethod中 ...
     */
    public static Locale getRequestLocale() {
        return LocaleInterceptor.localeThreadLocal.get();
    }
}
