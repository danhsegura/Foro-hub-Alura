package foro.hub.api.domain.topico;

import foro.hub.api.domain.autor.DatosAutor;
import foro.hub.api.domain.curso.DatosCurso;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, String fechacreacion,
                                   Boolean status, DatosAutor autor, DatosCurso curso, String respuesta) {
}
