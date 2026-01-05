package br.com.project.carrosprod.todos;

import org.springframework.data.jpa.repository.JpaRepository;

//Repository é a inteface que faz as operações de salvar, consultar, deletar e alterar no Banco de dados

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);


}
