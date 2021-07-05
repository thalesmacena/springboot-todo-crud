package br.com.example.todocrud.domain.service.impl;

import br.com.example.todocrud.domain.model.ToDo;
import br.com.example.todocrud.infra.exception.ToDoNotFoundException;
import br.com.example.todocrud.infra.repository.ToDoRepository;
import br.com.example.todocrud.infra.util.ToDoMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ToDoServiceImplTest {

    @InjectMocks
    private ToDoServiceImpl toDoService;

    @Mock
    private ToDoRepository toDoRepository;

    private final long TODO_ID = 1;

    // Show Test
    @Test(expected = ToDoNotFoundException.class)
    public void givenToDoIdThatNotExistsAssertException() {
        when(toDoRepository.findById(TODO_ID)).thenReturn(Optional.empty());

        toDoService.getToDoById(TODO_ID);
    }

    // Update Test
    @Test(expected = ToDoNotFoundException.class)
    public void givenToDoIdThatNotExistsOnUpdateAssertException() {
        ToDo toDo = ToDoMock.mockToDo();
        when(toDoRepository.findById(TODO_ID)).thenReturn(Optional.empty());

        toDoService.updateToDo(TODO_ID, toDo);
    }

    // Delete Test
    @Test(expected = ToDoNotFoundException.class)
    public void givenToDoIdThatNotExistsOnDeleteAssertException() {
        when(toDoRepository.findById(TODO_ID)).thenReturn(Optional.empty());

        toDoService.deleteToDo(TODO_ID);
    }
}
