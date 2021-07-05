package br.com.example.todocrud.application.controller;
import br.com.example.todocrud.domain.model.ToDo;
import br.com.example.todocrud.domain.service.ToDoService;
import br.com.example.todocrud.infra.exception.ToDoNotFoundException;
import br.com.example.todocrud.infra.util.ToDoMock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.class)
public class ToDoCotrollerTest {

    @InjectMocks
    private ToDoController controller;

    @Mock
    private ToDoService toDoService;

    private final long TODO_ID = 1;

    // Index tests
    @Test
    public void givenOkAndToDoListForGetAllToDo() {
        List<ToDo> values = Arrays.asList(ToDoMock.mockToDo());
        doReturn(values).when(toDoService).getAllToDo();

        ResponseEntity<?> response = controller.getAllToDo();

        Assert.assertEquals(values, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // Show tests
    @Test
    public void givenToDoIdThatExistReturnToDo() {
        ToDo toDo = ToDoMock.mockToDo();
        doReturn(toDo).when(toDoService).getToDoById(any());

        ResponseEntity<ToDo> response = controller.getToDoById(TODO_ID);

        Assert.assertEquals(toDo, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test(expected = ToDoNotFoundException.class)
    public void givenToDoIdThatNotExistThenThrowsToDoNotFoundException() {
        doThrow(ToDoNotFoundException.class).when(toDoService).getToDoById(TODO_ID);

        ResponseEntity<ToDo> response = controller.getToDoById(TODO_ID);

        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Create tests
    @Test
    public void givenToDoCreateReturnToDo() {
        ToDo toDo = ToDoMock.mockToDo();

        doReturn(toDo).when(toDoService).createToDo(toDo);

        ResponseEntity<ToDo> response = controller.createToDo(toDo);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(toDo, response.getBody());
    }

    // Update Tests
    @Test
    public void givenToDoUpdateReturnUpdatedToDo() {
        ToDo toDo = ToDoMock.mockToDo();

        doReturn(toDo).when(toDoService).updateToDo(TODO_ID, toDo);

        ResponseEntity<ToDo> response = controller.updateToDo(TODO_ID, toDo);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(toDo, response.getBody());
    }

    @Test(expected = ToDoNotFoundException.class)
    public void givenToDoIdThatNotExistOnUpdateAssertException() {
        ToDo toDo = ToDoMock.mockToDo();
        doThrow(ToDoNotFoundException.class).when(toDoService).updateToDo(TODO_ID, toDo);

        ResponseEntity<ToDo> response = controller.updateToDo(TODO_ID, toDo);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Delete Tests
    @Test
    public void givenOkOnToDoDelete() {
        ResponseEntity response = controller.deleteToDo(TODO_ID);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test(expected = ToDoNotFoundException.class)
    public void givenToDoIdThatNotExistOnDeleteAssertException() {
        doThrow(ToDoNotFoundException.class).when(toDoService).deleteToDo(TODO_ID);

        ResponseEntity<ToDo> response = controller.deleteToDo(TODO_ID);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
