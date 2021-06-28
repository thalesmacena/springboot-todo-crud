package br.com.example.todocrud.domain.service;

import br.com.example.todocrud.domain.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllToDo();

    ToDo getToDoById(Long id);

    ToDo createToDo(ToDo toDo);

    ToDo updateToDo(Long id, ToDo todo);

    ToDo completeToDo(Long id, Boolean done);

    void deleteToDo(Long id);
}
