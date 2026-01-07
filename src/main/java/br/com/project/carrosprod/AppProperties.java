package br.com.project.carrosprod;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.config")
public class AppProperties {
    private String variavel;
    private Integer valor1;

    public Integer getValor() {
        return valor1;
    }

    public void setValor(Integer valor1) {
        this.valor1 = (Integer) valor1;
    }

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }
}
