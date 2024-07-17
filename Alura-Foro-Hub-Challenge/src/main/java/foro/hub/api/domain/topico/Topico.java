package foro.hub.api.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import foro.hub.api.domain.autor.Autor;
import foro.hub.api.domain.curso.Curso;



@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String fechacreacion;
    private Boolean status;
    @Embedded
    private Autor autor;
    @Embedded
    private Curso curso;
    private String respuesta;


    public Topico(DatosRegistroTopico datosRegistroTopico) {

        this.status = true;

        this.titulo = datosRegistroTopico.titulo();

        this.mensaje = datosRegistroTopico.mensaje();

        this.fechacreacion = datosRegistroTopico.fechacreacion();

        this.autor = new Autor(datosRegistroTopico.autor());

        this.curso = new Curso(datosRegistroTopico.curso());

        this.respuesta = datosRegistroTopico.respuesta();


    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.curso() != null) {
            this.curso = curso.ActualizarDatos(datosActualizarTopico.curso());
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }



}
