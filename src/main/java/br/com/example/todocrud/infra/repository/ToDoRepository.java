package br.com.example.todocrud.infra.repository;

import br.com.example.todocrud.domain.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAll();
    Optional<ToDo> findById(Long id);
}
