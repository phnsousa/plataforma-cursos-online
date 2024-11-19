package com.exemplo.cursoplatform.controller;

import com.exemplo.cursoplatform.dto.CursoDTO;
import com.exemplo.cursoplatform.entity.Aluno;
import com.exemplo.cursoplatform.populator.InscricaoPopulator;
import com.exemplo.cursoplatform.repository.AlunoRepository;
import com.exemplo.cursoplatform.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoPopulator populator;

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        aluno.setDataCadastro(LocalDate.now());
        return alunoRepository.save(aluno);
    }

    @PostMapping("/{alunoId}/inscrever/{cursoId}")
    public String inscreverAluno(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        aluno.getCursos().add(curso);
        curso.getAlunos().add(aluno);
        alunoRepository.save(aluno);
        return "Aluno inscrito com sucesso!";
    }

    @GetMapping("/{alunoId}/cursos")
    public List<CursoDTO> listarCursos(@PathVariable Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        return aluno.getCursos().stream()
                .map(populator::toCursoDTO)
                .collect(Collectors.toList());
    }
}
