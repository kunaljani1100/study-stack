package org.studystack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.studystack.interceptor.StudyStackInterceptor;

@Configuration
@ComponentScan("org.studystack.interceptor")
public class StudyStackConfig implements WebMvcConfigurer {

    @Autowired
    private StudyStackInterceptor studyStackInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(studyStackInterceptor)
                .addPathPatterns("/groups/users/create")
                .addPathPatterns("/answer")
                .addPathPatterns("/question")
                .addPathPatterns("/question/answers")
                .addPathPatterns("/groups/create")
                .addPathPatterns("/users/create")
                .addPathPatterns("/groups/questions/view")
                .addPathPatterns("/groups/users/view")
                .addPathPatterns("/users/get");
    }
}
