import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import br.com.project.carrosprod.todos.TodoValidator;

//Utilizando a Annotation "@Lazy" podemos instanciar os Bean somente na hora em que formos utilizar, evitando instanciar ao subir a aplicação. 

//O escopo(Scope) padrão para os Beans é singleton
@Component
//se quisermos modificar o escopo (Scope) escrevemos o Bean e inserimos o novo escopo em formato de String
@Scope("singleton")
/* @Scope("singleton") => é um padrão do scope, é uma instancia unica de um objeto que vai atender a toda uma aplicação por (BeanDefinition.SCOPE_SINGLETON)
   @Scope("request") => aplicação web, esse objeto só vai existir durante a requisição de depois vai deixar de existir, sem guardar nenhum estado (WebApplicationContext.SCOPE_REQUEST)
   @Scope("session") => aplicação web, esse objeto vai durar até o fim da sessão do usuário. Ele está atrelado ao usuário.
   @Scope("application") => aplicação web, é um escopo parecido com o session mas para todos os usuários
*/
public class BeanGerenciado{

    //Aqui estamos injetando a dependencia via propriedade
    @Autowired
    private TodoValidator validator;

    //Aqui estamos injetando a dependencia via Construtor. Este é o mais recomendado!
    @Autowired
    public BeanGerenciado(TodoValidator validator){
        this.validator = validator;
    }

    //Aqui estamos injetando a dependencia via Setter. Esta é a menos comum. Aqui podemos criar situações de opcionalidade
    //onde podemos mudar o tipo de validador por meio deste setter
    public void setValidador(TodoValidator validator){
        this.validator = validator;
    }
}