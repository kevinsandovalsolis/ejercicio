package cl.ejercicio.repositorio;

import cl.ejercicio.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {

    Usuario findByCorreo(String correo);
}
