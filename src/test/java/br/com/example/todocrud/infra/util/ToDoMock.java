package br.com.example.todocrud.infra.util;

import br.com.example.todocrud.domain.model.ToDo;

import java.time.LocalDateTime;

public class ToDoMock {

    public static ToDo mockToDo(){
        return  ToDo.builder()
                .title("Example")
                .description("ToDo Example")
                .done(false)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
