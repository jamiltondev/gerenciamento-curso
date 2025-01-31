package com.projeto.gerenciamento_curso.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class InscricaoDTO {

    private Long id;
    private CursoDTO curso;
    private EstudanteDTO estudante;
    private LocalDateTime dataInscricao = LocalDateTime.now();

}
