package com.cxf.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
/**
 * 对SpringMVC的配置类 JavaConfig.
 *
 * @author maeagle
 * @date 2016-2-2 12 :14:01
 */
@Configuration
@ComponentScan(basePackages = {"com.*"})
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 配置内容协商工具.
     *
     * @author maeagle
     * @date 2016-2-2 12 :14:01
     * @see DefaultServletHandlerConfigurer
     */
    @Override
    protected void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // 开启对 users/123.json 的支持
        configurer.favorPathExtension(true);
        // 关闭对 users/123?format=json 的支持
        configurer.favorParameter(false);
        // 关闭对http的header中 content-type 的支持
        configurer.ignoreAcceptHeader(false);
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
        configurer.mediaType("atom", MediaType.APPLICATION_ATOM_XML)
                .mediaType("html", MediaType.TEXT_HTML)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("*", MediaType.ALL);
    }

    /**
     * 添加SpringMVC的视图处理器
     * <p>
     * Override this method to configure view resolution.
     *
     * @author maeagle
     * @date 2016-2-2 12 :14:01
     * @see ViewResolverRegistry
     */
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        /**
         * JSP的视图处理器
         */
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
        urlBasedViewResolver.setViewClass(JstlView.class);
        urlBasedViewResolver.setPrefix("/WEB-INF/jsp/");
        urlBasedViewResolver.setSuffix(".jsp");
        registry.viewResolver(urlBasedViewResolver);
    }

}
