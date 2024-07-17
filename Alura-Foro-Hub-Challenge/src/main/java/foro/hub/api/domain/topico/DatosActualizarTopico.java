package foro.hub.api.domain.topico;

import foro.hub.api.domain.curso.DatosCurso;
import jakarta.validation.constraints.NotNull;


public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje, DatosCurso curso) {
}
