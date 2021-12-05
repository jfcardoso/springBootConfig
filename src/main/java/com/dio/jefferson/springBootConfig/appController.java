package com.dio.jefferson.springBootConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController{

    //essa anotação injeta na variável appMessage o conteúdo passado no parâmetro
    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnvironmentVariable;

    @GetMapping("/")
    public String getAppMessage(){
        return appMessage;
    }

    @GetMapping("/environment")
    public String getEnvironmentVariable(){
        String resposta = "A seguinte variável de ambiente foi passada: ";
        return resposta + dbEnvironmentVariable;
    }

}
