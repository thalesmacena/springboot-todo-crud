package br.com.example.todocrud.infra.exception;

public class ToDoNotFoundException extends RuntimeException {
    private String id;

    public ToDoNotFoundException(String id) {
        super(String.format("ToDo com o id %s não encontrado", id));
        this.id = id;
    }
}
