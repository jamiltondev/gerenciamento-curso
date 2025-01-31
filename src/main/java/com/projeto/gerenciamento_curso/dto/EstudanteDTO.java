package com.projeto.gerenciamento_curso.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EstudanteDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private LocalDate dataCadastro = LocalDate.now();

}
