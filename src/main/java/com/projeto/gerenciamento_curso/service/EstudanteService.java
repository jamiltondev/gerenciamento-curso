package com.projeto.gerenciamento_curso.service;

import com.projeto.gerenciamento_curso.dto.EstudanteDTO;
import com.projeto.gerenciamento_curso.exceptions.ResourceNotFoundException;
import com.projeto.gerenciamento_curso.model.Estudante;
import com.projeto.gerenciamento_curso.repository.EstudanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<EstudanteDTO> listar() {
        return estudanteRepository.findAll().stream()
                .map(estudante -> modelMapper.map(estudante, EstudanteDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EstudanteDTO buscarPorId(Long id) {
        var estudante = estudanteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudante não encontrado para o id: " + id));;
        return modelMapper.map(estudante, EstudanteDTO.class);
    }

    @Transactional
    public EstudanteDTO inserir(EstudanteDTO estudanteDTO) {
        var estudante = modelMapper.map(estudanteDTO, Estudante.class);
        var estudanteSalvo = estudanteRepository.save(estudante);
        return modelMapper.map(estudanteSalvo, EstudanteDTO.class);
    }

    @Transactional
    public EstudanteDTO alterar(EstudanteDTO estudanteDTO) {
        return estudanteRepository.findById(estudanteDTO.getId()).map(estudanteRetornado -> {
            estudanteRetornado.setNome(estudanteDTO.getNome());
            estudanteRetornado.setEmail(estudanteDTO.getEmail());
            estudanteRetornado.setDataNascimento(estudanteDTO.getDataNascimento());

            var estudanteSalvo = estudanteRepository.save(estudanteRetornado);

            return modelMapper.map(estudanteSalvo, EstudanteDTO.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Estudante não encontrado para o id: " + estudanteDTO.getId()));
    }

    @Transactional
    public void excluir(Long id) {
        var estudante = estudanteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Estudante não encontrado para o id: " + id));
        estudanteRepository.delete(estudante);
    }

}
