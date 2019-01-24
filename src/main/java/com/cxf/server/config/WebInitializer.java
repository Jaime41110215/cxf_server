package com.cxf.server.config;

import com.cxf.server.servlet.HelloServlet;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author wanghongchao
 * @mail wanghongchao@sinosoft.com.cn
 * @time 2019/1/23
 */
public class WebInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {

    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //super.onStartup(servletContext);
        registerCXFServlet(servletContext);
        registerHelloServlet(servletContext);
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/web"};
    }
    protected void registerCXFServlet(ServletContext servletContext) {
        String servletName = "cxf";
        Servlet cxf = new CXFServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet(servletName, cxf);
        registration.setLoadOnStartup(1);
        registration.addMapping(new String[]{"/services"});
        //registration.setAsyncSupported(isAsyncSupported());
    }

    protected void registerHelloServlet(ServletContext servletContext) {
        String servletName = "hello";
        Servlet hello = new HelloServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet(servletName, hello);
        registration.setLoadOnStartup(1);
        registration.addMapping(new String[]{"/hello"});
        //registration.setAsyncSupported(isAsyncSupported());
    }
}
