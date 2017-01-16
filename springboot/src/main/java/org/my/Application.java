package org.my;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.my.boot.handler.HelloHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by trash on 29-Oct-16.
 */
@RestController
@SpringBootApplication()
@ImportResource(value = "classpath:spring/root-context.xml")
public class Application {

    @Autowired
    HelloHandler helloProducer;
//http://localhost:8080/users/5/customers
    @RequestMapping("/rest/")
    String home() {
        return helloProducer.returnHello();
    }

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
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean dispatcherCXFServletRegistration() {
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(
                cxfServlet, "/service/*");

//        registration
//                .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        registration.setLoadOnStartup(1);
        return registration;
    }

//    @Bean
//    public ServletRegistrationBean dispatcherServletRegistration() {
//        CXFServlet cxfServlet = new CXFServlet();
//        ServletRegistrationBean registration = new ServletRegistrationBean(
//                cxfServlet, "/rest/*");

//        registration
//                .setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
//        registration.setLoadOnStartup(2);
//        registration.setName("restCXFServlet");
//        return registration;
//    }
}
