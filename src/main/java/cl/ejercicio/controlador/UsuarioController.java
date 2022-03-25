package cl.ejercicio.controlador;

import cl.ejercicio.dto.UsuarioRequestDTO;
import cl.ejercicio.dto.UsuarioResponseDTO;
import cl.ejercicio.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping(value="/usuario",consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
    public UsuarioResponseDTO guardarUsuarios(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return usuarioService.guardarUsuario(usuarioRequestDTO);
    }
}
