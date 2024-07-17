package foro.hub.api.domain.topico;

import foro.hub.api.domain.autor.Autor;

public record DatosRespuesta(

        Long id,

        String mensaje,

        String topico,

        String fechacreacion,

        Autor autor,

        String solucion
) {
}
