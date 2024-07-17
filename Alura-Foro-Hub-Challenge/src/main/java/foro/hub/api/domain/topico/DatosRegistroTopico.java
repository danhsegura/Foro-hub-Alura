package foro.hub.api.domain.topico;

import foro.hub.api.domain.autor.DatosAutor;
import foro.hub.api.domain.curso.DatosCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String fechacreacion,
        @NotNull
        @Valid
        DatosAutor autor,
        @NotNull
        @Valid
        DatosCurso curso,
        String respuesta) {
}
