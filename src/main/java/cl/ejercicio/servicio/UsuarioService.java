package cl.ejercicio.servicio;

import cl.ejercicio.Util.JwtUtil;
import cl.ejercicio.Util.Utilidades;
import cl.ejercicio.converter.UsuarioConverter;
import cl.ejercicio.dto.UsuarioRequestDTO;
import cl.ejercicio.dto.UsuarioResponseDTO;
import cl.ejercicio.exception.UsuarioException;
import cl.ejercicio.exception.ValidacionException;
import cl.ejercicio.modelo.Usuario;
import cl.ejercicio.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Utilidades utilidades;

    @Autowired
    private JwtUtil jwtUtil;



    public UsuarioResponseDTO guardarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        Function<UsuarioRequestDTO, Usuario> usuarioBdFunction=usuarioConverter::convertToBd;
        Function<Usuario,UsuarioResponseDTO> usuarioResponse=usuarioConverter::convertToResponse;

            utilidades.validarMail(usuarioRequestDTO.getCorreo());
            utilidades.validarPassword(usuarioRequestDTO.getPassword());
            validarUsuarioMail(usuarioRequestDTO.getCorreo());
            Usuario usuario=usuarioBdFunction.apply(usuarioRequestDTO);
            usuario.setToken(jwtUtil.generateToken(new User(usuario.getCorreo(), usuario.getPassword(),
                    new ArrayList<>())));
            usuarioRepository.save(usuario);
            return usuarioResponse.apply(usuario);



    }

    private void validarUsuarioMail(String mail){
        Optional<Usuario> usuarioExiste=Optional.ofNullable(usuarioRepository.findByCorreo(mail));
        if(usuarioExiste.isPresent()){
            throw new UsuarioException("email ya registrado");
        }
    }
}
