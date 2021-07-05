package br.com.example.todocrud.infra.repository;

import br.com.example.todocrud.domain.model.ToDo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    @Cacheable(value = "findById")
    List<ToDo> findAll();

    @Cacheable(value = "findById")
    Optional<ToDo> findById(Long id);
}
