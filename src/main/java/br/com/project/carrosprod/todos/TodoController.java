package br.com.project.carrosprod.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//Controller são as requisições http que conhecemos, cada metodo vai realizar uma operação de GET, POST, DELET, PUT e assim vai.


@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
            return this.service.salvar(todo);

        }catch (IllegalArgumentException e){
            var mensagem = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagem);
        }
    }
    @PutMapping("/{id}")
    public void atualizarStatus(
            @PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);

        service.atualizarStatus(todo);

    }

    @GetMapping("/{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id){
        return service.buscar(id);
    }

}
