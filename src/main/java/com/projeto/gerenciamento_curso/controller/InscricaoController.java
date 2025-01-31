package com.projeto.gerenciamento_curso.controller;

import com.projeto.gerenciamento_curso.dto.InscricaoDTO;
import com.projeto.gerenciamento_curso.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inscricoes")
public class InscricaoController {

    @Autowired
    InscricaoService inscricaoService;

    @GetMapping
    public List<InscricaoDTO> listar() {
        return inscricaoService.listar();
    }

    @GetMapping(value = "/{id}")
    public InscricaoDTO buscarPorId(@PathVariable Long id) {
        return inscricaoService.buscarPorId(id);
    }

    @PostMapping
    public InscricaoDTO inserir(@RequestBody InscricaoDTO inscricaoDTO) {
        return inscricaoService.inserir(inscricaoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Long id) {
        inscricaoService.excluir(id);
    }

}
