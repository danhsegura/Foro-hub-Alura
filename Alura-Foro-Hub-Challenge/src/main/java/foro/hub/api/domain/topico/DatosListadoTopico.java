package foro.hub.api.domain.topico;

public record DatosListadoTopico(Long id, String titulo,
                                 String mensaje,
                                 String autor,
                                 String curso, String respuesta) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje()
                , topico.getAutor().toString(), topico.getCurso().toString(),topico.getRespuesta());
    }
}


