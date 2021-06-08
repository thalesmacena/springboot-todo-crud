package br.com.example.todocrud.application.controller;

import br.com.example.todocrud.domain.model.ToDo;
import br.com.example.todocrud.domain.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ToDoController {
  private final ToDoService toDoService;

  // index
    @GetMapping("/todo")
    public ResponseEntity<List<ToDo>> getAllToDo(){
        return ResponseEntity.ok(toDoService.getAllToDo());
    }

  // show
  @GetMapping("/todo/{id}")
  public ResponseEntity<ToDo> getToDoById(@PathVariable Long id){
      return ResponseEntity.ok(toDoService.getToDoById(id));
  }

  // post
  @PostMapping("/todo")
  public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo){
      return ResponseEntity.ok(toDoService.createToDo(toDo));
  }

  // put
    @PutMapping("/todo/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
        return ResponseEntity.ok(toDoService.updateToDo(id, toDo));
    }

  // patch
    @PatchMapping("/todo/{id}")
    public ResponseEntity<ToDo> completeToDo(@PathVariable Long id, @RequestBody Boolean done) {
        return ResponseEntity.ok(toDoService.completeToDo(id,done));
    }

  // delete
    @DeleteMapping("/todo/{id}")
    public ResponseEntity deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return ResponseEntity.ok().build();
    }

}
