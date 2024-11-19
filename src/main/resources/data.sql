-- Inserindo dados iniciais na tabela Aluno
INSERT INTO aluno (nome, email, data_cadastro) VALUES ('Paulo Sousa', 'paulo.sousa@email.com', '2024-01-01');
INSERT INTO aluno (nome, email, data_cadastro) VALUES ('Leticia Nunes', 'leticia.nunes@email.com', '2024-01-05');

-- Inserindo dados iniciais na tabela Curso
INSERT INTO curso (nome, descricao, data_criacao) VALUES ('Java Básico', 'Curso introdutório de Java', '2024-02-01');
INSERT INTO curso (nome, descricao, data_criacao) VALUES ('Spring Boot', 'Curso avançado de Spring Boot', '2024-02-10');

-- Inscrições de alunos nos cursos (relacionamento muitos-para-muitos)
-- Paulo Sousa inscrito em Java Básico
INSERT INTO inscricao (aluno_id, curso_id, data_inscricao) VALUES (1, 1, '2024-03-01');

-- Leticia Nunes inscrita em Spring Boot
INSERT INTO inscricao (aluno_id, curso_id, data_inscricao) VALUES (2, 2, '2024-03-02');
