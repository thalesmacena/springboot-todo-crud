package br.com.example.todocrud.domain.service.impl;

import br.com.example.todocrud.domain.model.ToDo;
import br.com.example.todocrud.domain.service.ToDoService;
import br.com.example.todocrud.infra.exception.ToDoNotFoundException;
import br.com.example.todocrud.infra.repository.ToDoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new ToDoNotFoundException(id.toString()));
    }

    @Override
    public ToDo createToDo(ToDo toDo) {
        ToDo newToDo = ToDo.builder()
                .title(toDo.getTitle())
                .description(toDo.getDescription())
                .done(false)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        return toDoRepository.save(newToDo);
    }

    @Override
    public ToDo updateToDo(Long id, ToDo todo) {
        Optional<ToDo> toDoOptional = toDoRepository.findById(id);

        if (toDoOptional.isEmpty()) {
            throw new ToDoNotFoundException(id.toString());
        }

        ToDo toDoExistent = toDoOptional.get();

        ToDo updatedToDo = ToDo.builder()
                .id(toDoExistent.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .done(todo.getDone())
                .updatedDate(LocalDateTime.now())
                .createdDate(toDoExistent.getCreatedDate())
                .build();

        return toDoRepository.save(updatedToDo);
    }

    @Override
    public ToDo completeToDo(Long id, Boolean done) {
        Optional<ToDo> toDoOptional = toDoRepository.findById(id);

        if (toDoOptional.isEmpty()) {
            throw new ToDoNotFoundException(id.toString());
        }

        ToDo toDoExistent = toDoOptional.get();

        ToDo updatedToDo = ToDo.builder()
                .id(toDoExistent.getId())
                .title(toDoExistent.getTitle())
                .description(toDoExistent.getDescription())
                .done(done)
                .updatedDate(LocalDateTime.now())
                .createdDate(toDoExistent.getCreatedDate())
                .build();

        return toDoRepository.save(updatedToDo);
    }

    @Override
    @Transactional
    public void deleteToDo(Long id) {
        if (toDoRepository.findById(id).isEmpty()) {
            throw new ToDoNotFoundException(id.toString());
        }

        toDoRepository.deleteById(id);
    }
}
