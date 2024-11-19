@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

    @ManyToMany(mappedBy = "alunos")
    private Set<Curso> cursos = new HashSet<>();

}
