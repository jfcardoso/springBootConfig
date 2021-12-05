package com.dio.jefferson.springBootConfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//Digo para o SpringBoot que esse é um arquivo de configuração
@Configuration
//SpringBoot irá mapear todas as propriedades iniciadas com o parâmetro passado na anotação
@ConfigurationProperties("spring.datasource")
@Getter //anotacão lombok - já faz os getter e os setters em tempo de compilação.
@Setter
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    @Profile("dev")
    @Bean
    public String testDBConnection(){
        System.out.println("DB Connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "BD Connection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDBConnection(){
        System.out.println("DB Connection for Production - MYSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "BD Connection to MYSQL_PROD - Production instance";
    }
}
