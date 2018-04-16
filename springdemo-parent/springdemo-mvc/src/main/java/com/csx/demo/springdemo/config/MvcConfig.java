package com.csx.demo.springdemo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;


//@Configuration
//<mvc:annotation-driven/>的作用相同
//@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    org.slf4j.Logger logger = LoggerFactory.getLogger(MvcConfig.class);

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/demoA")
                .allowedOrigins("http://domain2.com");
    }


    //扩展默认创建的的convert
    //configMessageConverters这个方法不会默认创建convert，你在这个方法中创建几个，就创建几个convert
    //默认的HttpMessageConvert在WebMvcConfigurationSupport这个类中进行配置，可以参考这个类。
    //RequestResponseBodyMethodProcessor这个类中使用了这些转换器进行转换
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        logger.info("into config...");
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);

        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);

        converter.setFastJsonConfig(config);
        converter.setSupportedMediaTypes(fastMediaTypes);
        converters.add(converter);

    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        logger.info("into config...");
        return;
    }
}
