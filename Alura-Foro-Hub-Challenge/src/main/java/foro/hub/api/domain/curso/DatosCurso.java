package foro.hub.api.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank
        String nombrecurso,
        @NotBlank
        String categoria

) {
}
