package com.treegrowth.service.iml.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static freemarker.cache.NullCacheStorage.INSTANCE;

@Service
public class MarkerTemplateInit {

    private Configuration configuration;

    {
        configuration = new Configuration(Configuration.VERSION_2_3_25);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setCacheStorage(INSTANCE);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setClassForTemplateLoading(this.getClass(), "/templates/");
        configuration.setLogTemplateExceptions(false);
    }

    @Bean
    public Template templateInit() throws IOException {
        return configuration.getTemplate("registerNotice.ftl");
    }

}
