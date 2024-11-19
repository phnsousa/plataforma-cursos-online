package com.exemplo.cursoplatform.controller;

import com.exemplo.cursoplatform.dto.AlunoDTO;
import com.exemplo.cursoplatform.entity.Curso;
import com.exemplo.cursoplatform.populator.InscricaoPopulator;
import com.exemplo.cursoplatform.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoPopulator populator;

    @PostMapping
    public Curso criarCurso(@RequestBody Curso curso) {
        curso.setDataCriacao(LocalDate.now());
        return cursoRepository.save(curso);
    }

    @GetMapping("/{cursoId}/alunos")
    public List<AlunoDTO> listarAlunos(@PathVariable Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        return curso.getAlunos().stream()
                .map(populator::toAlunoDTO)
                .collect(Collectors.toList());
    }
}
