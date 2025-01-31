package com.projeto.gerenciamento_curso.controller;

import com.projeto.gerenciamento_curso.dto.EstudanteDTO;
import com.projeto.gerenciamento_curso.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteService estudanteService;

    @GetMapping
    public List<EstudanteDTO> listar() {
        return estudanteService.listar();
    }

    @GetMapping(value = "/{id}")
    public EstudanteDTO buscarPorId(@PathVariable Long id) {
        return estudanteService.buscarPorId(id);
    }

    @PostMapping
    public EstudanteDTO inserir(@RequestBody EstudanteDTO estudanteDTO) {
        return estudanteService.inserir(estudanteDTO);
    }

    @PutMapping(value = "/{id}")
    public EstudanteDTO alterar(@RequestBody EstudanteDTO estudanteDTO, @PathVariable Long id) {
        estudanteDTO.setId(id);
        return estudanteService.alterar(estudanteDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {
        estudanteService.excluir(id);
    }

}
