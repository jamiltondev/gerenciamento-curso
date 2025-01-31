package com.projeto.gerenciamento_curso.repository;

import com.projeto.gerenciamento_curso.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
