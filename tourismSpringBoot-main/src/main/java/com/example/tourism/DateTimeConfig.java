package com.example.tourism;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig {

    @Bean
    public FormattingConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ofPattern("dd-MM-yyyy")); // Customize the pattern here
        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")); // DateTime format
        registrar.registerFormatters(conversionService);

        return conversionService;
    }
}
