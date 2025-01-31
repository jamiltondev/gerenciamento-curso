package com.projeto.gerenciamento_curso.repository;

import com.projeto.gerenciamento_curso.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
