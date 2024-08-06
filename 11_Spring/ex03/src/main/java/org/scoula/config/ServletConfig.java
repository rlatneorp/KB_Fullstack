package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@EnableWebMvc : MVC 패턴 사용하겠다
@EnableWebMvc
//해당 패키지 내부에서 컴포터넌트를 찾아라
@ComponentScan(basePackages = {"org.scoula.controller",
                               "org.scoula.exception",
                               "org.scoula.ex03.controller"}) // 경로에 따라 다름
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
             .addResourceHandler("/resources/**")
             .addResourceLocations("/resources");
    }

    // jsp view resolver 설정

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/"); // 경로에 따라 다름
        bean.setSuffix(".jsp");

        registry.viewResolver(bean);
    }

    // Multipart 해석을 위한 메소드
    @Bean
    public MultipartResolver multipartResolver(){
        StandardServletMultipartResolver resolver
                = new StandardServletMultipartResolver();
        return resolver;
    }
}
