package foro.hub.api.controller;

import foro.hub.api.domain.autor.DatosAutor;
import foro.hub.api.domain.curso.DatosCurso;
import foro.hub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechacreacion(), topico.getStatus(),
                new DatosAutor(topico.getAutor().getNombre(),topico.getAutor().getEmail(),topico.getAutor().getContrasenia(),topico.getAutor().getPerfil()),
                new DatosCurso(topico.getCurso().getNombrecurso(),topico.getCurso().getCategoria())
                ,topico.getRespuesta());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        //return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechacreacion(), topico.getStatus(),
                new DatosAutor(topico.getAutor().getNombre(),topico.getAutor().getEmail(),topico.getAutor().getContrasenia(),topico.getAutor().getPerfil()),
                new DatosCurso(topico.getCurso().getNombrecurso(),topico.getCurso().getCategoria())
                ,topico.getRespuesta()));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico  = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechacreacion(), topico.getStatus(),
                new DatosAutor(topico.getAutor().getNombre(),topico.getAutor().getEmail(),topico.getAutor().getContrasenia(),topico.getAutor().getPerfil()),
                new DatosCurso(topico.getCurso().getNombrecurso(),topico.getCurso().getCategoria())
                ,topico.getRespuesta());
        return ResponseEntity.ok(datosTopico);
    }

}
