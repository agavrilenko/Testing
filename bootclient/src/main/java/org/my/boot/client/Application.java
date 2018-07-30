package org.my.boot.client;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by trash on 25-Dec-16.
 */
@SpringBootApplication()
@ImportResource({ "classpath:spring/client-context.xml"})
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    /**
     * Register dispatcherServlet programmatically
     * http://localhost:8080/service/SoapContext?wsdl
     *
     * @return ServletRegistrationBean
     */
//    @Bean
//    public ServletRegistrationBean dispatcherCXFServletRegistration() {
//        CXFServlet cxfServlet = new CXFServlet();
//        ServletRegistrationBean registration = new ServletRegistrationBean(
//                cxfServlet, "/service/*");

//        registration
//                .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
//        registration.setLoadOnStartup(1);
//        return registration;
//    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(
                cxfServlet, "/rest/*");

//        registration
//                .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        registration.setLoadOnStartup(1);
        registration.setName("restCXFServlet");
        return registration;
    }

}
