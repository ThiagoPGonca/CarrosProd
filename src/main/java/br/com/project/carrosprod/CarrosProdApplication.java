package br.com.project.carrosprod;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class CarrosProdApplication {

    public static void main(String[] args) throws Exception{
        //SpringApplication.run(CarrosProdApplication.class, args);

       /*
        SpringApplicationBuilder builder =
                new SpringApplicationBuilder(CarrosProdApplication.class);.


        builder.bannerMode(Banner.Mode.OFF);
        builder.profiles("producao", "homologacao");
        //builder.lazyInitialization(true);

        builder.run(args);
*/
        //contexto de aplicação ja iniciada:
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CarrosProdApplication.class, args);
        //var produtoRepository = applicationContext.getBean("produtoRepository");


        //BeanGerenciado beanGerenciado = new BeanGerenciado(null);;

        //Como pegar variáveis das propriedades (nada usual)
        //String applicationName = enviroment.getProperty("spring.application.name");

        ConfigurableEnvironment enviroment = applicationContext.getEnvironment();
        String applicationName = enviroment.getProperty("spring.application.name");
        System.out.println("Nome da aplicação: " + applicationName);

        ExemploValue value = applicationContext.getBean(ExemploValue.class);
        value.imprimirVariavel();
        value.imprimirApplicationName();


        AppProperties properties = applicationContext.getBean(AppProperties.class);
        System.out.println(properties.getValor());
        System.out.println(properties.getVariavel());
    }

}
