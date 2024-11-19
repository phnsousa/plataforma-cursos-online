package com.exemplo.cursoplatform.populator;

import com.exemplo.cursoplatform.dto.AlunoDTO;
import com.exemplo.cursoplatform.dto.CursoDTO;
import com.exemplo.cursoplatform.entity.Aluno;
import com.exemplo.cursoplatform.entity.Curso;
import org.springframework.stereotype.Component;

@Component
public class InscricaoPopulator {
    public AlunoDTO toAlunoDTO(Aluno aluno) {
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail());
    }

    public CursoDTO toCursoDTO(Curso curso) {
        return new CursoDTO(curso.getId(), curso.getNome(), curso.getDescricao());
    }
}
