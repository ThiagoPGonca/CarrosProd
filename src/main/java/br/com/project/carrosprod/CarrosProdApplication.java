package br.com.project.carrosprod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrosProdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrosProdApplication.class, args);

        //Como pegar variáveis das propriedades (nada usual)
        String applicationName = enviroment.getProperty("spring.application.name");

        ExemploValue value = applicationContext.getBean(ExemploValue.class);
        value.imprimirVariavel();
        value.imprimirApplicationName();
    }

}
