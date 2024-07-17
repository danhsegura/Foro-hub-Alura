package foro.hub.api.domain.curso;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class Curso {

    private String nombrecurso;

    private String categoria;

    public Curso(DatosCurso curso) {
        this.nombrecurso = curso.nombrecurso();
        this.categoria = curso.categoria();
    }

    public Curso ActualizarDatos(DatosCurso nuevoCurso) {
        this.nombrecurso = nuevoCurso.nombrecurso();
        this.categoria = nuevoCurso.categoria();
        return this;
    }
}
