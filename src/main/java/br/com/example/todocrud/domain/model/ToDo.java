package br.com.example.todocrud.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "todo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Boolean done;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
