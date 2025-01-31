package com.projeto.gerenciamento_curso.service;

import com.projeto.gerenciamento_curso.dto.InscricaoDTO;
import com.projeto.gerenciamento_curso.exceptions.ResourceNotFoundException;
import com.projeto.gerenciamento_curso.model.Inscricao;
import com.projeto.gerenciamento_curso.repository.CursoRepository;
import com.projeto.gerenciamento_curso.repository.EstudanteRepository;
import com.projeto.gerenciamento_curso.repository.InscricaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<InscricaoDTO> listar() {
        return inscricaoRepository.findAll().stream()
                .map(inscricao -> modelMapper.map(inscricao, InscricaoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public InscricaoDTO buscarPorId(Long id) {
        var incricao = inscricaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrada para o id: " + id));
        return modelMapper.map(incricao, InscricaoDTO.class);
    }

    @Transactional
    public InscricaoDTO inserir(InscricaoDTO inscricaoDTO) {
        var curso = cursoRepository.findById(inscricaoDTO.getCurso().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado para o id: " + inscricaoDTO.getCurso().getId()));

        var estudante = estudanteRepository.findById(inscricaoDTO.getEstudante().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Estudante não encontrado para o id: " + inscricaoDTO.getEstudante().getId()));

        var inscricao = modelMapper.map(inscricaoDTO, Inscricao.class);
        inscricao.setCurso(curso);
        inscricao.setEstudante(estudante);

        var inscricaoSalva = inscricaoRepository.save(inscricao);
        return modelMapper.map(inscricaoSalva, InscricaoDTO.class);
    }

    @Transactional
    public void excluir(Long id) {
        var inscricao = inscricaoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inscricao não encontrada para o id: " + id));
        inscricaoRepository.delete(inscricao);
    }

}
