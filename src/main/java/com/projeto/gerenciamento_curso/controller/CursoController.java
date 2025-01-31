package com.projeto.gerenciamento_curso.controller;

import com.projeto.gerenciamento_curso.dto.CursoDTO;
import com.projeto.gerenciamento_curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public List<CursoDTO> listar() {
        return cursoService.listar();
    }

    @GetMapping(value = "/{id}")
    public CursoDTO buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @PostMapping
    public CursoDTO inserir(@RequestBody CursoDTO cursoDTO) {
        return cursoService.inserir(cursoDTO);
    }

    @PutMapping(value = "/{id}")
    public CursoDTO alterar(@RequestBody CursoDTO cursoDTO, @PathVariable Long id) {
        cursoDTO.setId(id);
        return cursoService.alterar(cursoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {
        cursoService.excluir(id);
    }

}
