package br.com.project.carrosprod;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

//Como pegar variável ou dados das propriedades

@Component
public class ExemploValue{

    @Value("${app.config.variavel}")
    private String variavel;
    @Value("${spring.application.name}")
    private String nomeApplication;


    public void imprimirVariavel(){
        System.out.println(variavel);
    }



    public void imprimirApplicationName(){
        System.out.println(nomeApplication);
    }

}