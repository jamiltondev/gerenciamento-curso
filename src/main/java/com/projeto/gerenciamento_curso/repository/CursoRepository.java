package com.projeto.gerenciamento_curso.repository;

import com.projeto.gerenciamento_curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
