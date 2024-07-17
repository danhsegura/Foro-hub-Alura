package foro.hub.api.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DatosAutor(
        @NotBlank
        String nombre,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String contrasenia,
        @NotBlank
        String perfil
) {
}
