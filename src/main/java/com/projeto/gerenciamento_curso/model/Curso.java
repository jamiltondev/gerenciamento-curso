package com.projeto.gerenciamento_curso.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "curso", schema = "curso_db")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer cargaHoraria;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Inscricao> inscricoes = new ArrayList<>();

}
