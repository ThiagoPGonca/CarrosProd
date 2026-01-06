package br.com.project.carrosprod.todos;

import org.springframework.stereotype.Service;

//Camada Service vai acionar o repository e será a nossa maneira de falar o que queremos fazer no banco de dados, além de ser onde salvamos as regas de negócio

@Service
public class TodoService {

    
    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    //Aqui estamos injetando a dependencia via Construtor.
    @Autowired
    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }


    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não Concluido";
        mailSender.enviar("Todo: " + todo.getDescricao() + "foi atualizado para " + status);
    }

    public TodoEntity buscar(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }



}
