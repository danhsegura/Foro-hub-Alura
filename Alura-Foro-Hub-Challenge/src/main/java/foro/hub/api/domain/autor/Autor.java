package foro.hub.api.domain.autor;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    String nombre;
    String email;
    String contrasenia;
    String perfil;


    public Autor(DatosAutor autor){

        this.nombre = autor.nombre();

        this.email = autor.email();

        this.contrasenia = autor.contrasenia();

        this.perfil = autor.perfil();
    }

    public Autor actualizarDatoa(DatosAutor autor){

        this.nombre = autor.nombre();

        this.email = autor.email();

        this.contrasenia = autor.contrasenia();

        this.perfil = autor.perfil();

        return this;
    }
}
