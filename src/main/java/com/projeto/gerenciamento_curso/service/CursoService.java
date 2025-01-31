package com.projeto.gerenciamento_curso.service;

import com.projeto.gerenciamento_curso.dto.CursoDTO;
import com.projeto.gerenciamento_curso.exceptions.ResourceNotFoundException;
import com.projeto.gerenciamento_curso.model.Curso;
import com.projeto.gerenciamento_curso.repository.CursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<CursoDTO> listar() {
        return cursoRepository.findAll().stream()
                .map(curso -> modelMapper.map(curso, CursoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CursoDTO buscarPorId(Long id) {
        var curso = cursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado para o id: " + id));
        return modelMapper.map(curso, CursoDTO.class);
    }

    @Transactional
    public CursoDTO inserir(CursoDTO cursoDTO) {
        var curso = modelMapper.map(cursoDTO, Curso.class);
        var cursoSalvo = cursoRepository.save(curso);
        return modelMapper.map(cursoSalvo, CursoDTO.class);
    }

    @Transactional
    public CursoDTO alterar(CursoDTO cursoDTO) {
        return cursoRepository.findById(cursoDTO.getId()).map(cursoRetornado -> {
            cursoRetornado.setNome(cursoDTO.getNome());
            cursoRetornado.setDescricao(cursoDTO.getDescricao());
            cursoRetornado.setCargaHoraria(cursoDTO.getCargaHoraria());

            var resultado = cursoRepository.save(cursoRetornado);

            return modelMapper.map(resultado, CursoDTO.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado para o id: " + cursoDTO.getId()));
    }

    @Transactional
    public void excluir(Long id) {
        var curso = cursoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado para o id: " + id));
        cursoRepository.delete(curso);
    }

}
