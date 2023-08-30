package ra.md5th1.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import ra.md5th1.service.CustomerServiceIMPL;
import ra.md5th1.service.ICustomerService;

@Configuration
    @EnableWebMvc
    @ComponentScan("ra.md5th1")
    public class AppInit implements WebMvcConfigurer, ApplicationContextAware {
        private ApplicationContext appContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appContext = applicationContext;
        }

        @Bean
        public ThymeleafViewResolver viewResolver() {
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setTemplateEngine(templateEngine());
            return viewResolver;
        }

        @Bean
        public ISpringTemplateEngine templateEngine() {
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(templateResolver());
            return templateEngine;
        }

        @Bean
        public SpringResourceTemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setApplicationContext(appContext);
            templateResolver.setPrefix("/WEB-INF/views/");
            templateResolver.setSuffix(".html");
            templateResolver.setTemplateMode(TemplateMode.HTML);
            return templateResolver;
        }
        @Bean
        public ICustomerService customerService(){
            return new CustomerServiceIMPL();
        }

    }
