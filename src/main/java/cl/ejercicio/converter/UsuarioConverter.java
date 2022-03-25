package cl.ejercicio.converter;

import cl.ejercicio.dto.TelefonoDTO;
import cl.ejercicio.dto.UsuarioRequestDTO;
import cl.ejercicio.dto.UsuarioResponseDTO;
import cl.ejercicio.modelo.Acceso;
import cl.ejercicio.modelo.Estado;
import cl.ejercicio.modelo.Telefono;
import cl.ejercicio.modelo.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class UsuarioConverter {

    public Usuario convertToBd(UsuarioRequestDTO usuarioRequestDTO){

        Usuario usuario=new Usuario();
        usuario.setIdUsuario(UUID.randomUUID().toString());
        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setCorreo(usuarioRequestDTO.getCorreo());
        usuario.setPassword(usuarioRequestDTO.getPassword());
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaActuaizacion(LocalDateTime.now());
        usuario.setEstado(new Estado(1));
        usuario.setAccesos(Arrays.asList(new Acceso(usuario.getFechaCreacion())));
        usuario.setTelefonos(usuarioRequestDTO.getTelefonos().stream()
                .collect(ArrayList::new,(l,t)->l.add(getTelefono(t)),ArrayList::addAll));

        usuario.getTelefonos().forEach(t-> t.setUsuario(usuario));
        usuario.getAccesos().forEach(t-> t.setUsuario(usuario));
        return usuario;


    }

    private Telefono getTelefono(TelefonoDTO telefonoDTO){

        Telefono telefono= new Telefono();

        telefono.setNumero(telefonoDTO.getNumero());
        telefono.setCodigoCiudad(telefonoDTO.getCodigoCiudad());
        telefono.setCodigoPais(telefonoDTO.getCodigoPais());

        return telefono;

    }



    public UsuarioResponseDTO convertToResponse(Usuario usuario){

        UsuarioResponseDTO usuarioResponse=new UsuarioResponseDTO();
        usuarioResponse.setIdUsuario(usuario.getIdUsuario());
        usuarioResponse.setNombre(usuario.getNombre());
        usuarioResponse.setCorreo(usuario.getCorreo());
        usuarioResponse.setPassword(usuario.getPassword());
        usuarioResponse.setFechaCreacion(usuario.getFechaCreacion());
        usuarioResponse.setUltimoLogin(getUltimoAcceso(usuario.getAccesos()));
        usuarioResponse.setActivo(usuario.getEstado().getIdEstado()==1?true:false);
        usuarioResponse.setToken(usuario.getToken());
        usuarioResponse.setTelefonos(usuario.getTelefonos().stream()
                .collect(ArrayList::new,(l,t)->l.add(getTelefono(t)),ArrayList::addAll));



        return usuarioResponse;


    }

    private LocalDateTime getUltimoAcceso(List<Acceso> accesos){
        Collections.sort(accesos,(a,b) -> b.getFechaIngreso().compareTo(a.getFechaIngreso()));
        return accesos.get(0).getFechaIngreso();

    }

    private TelefonoDTO getTelefono(Telefono telefono){

        TelefonoDTO telefonoResponse= new TelefonoDTO();

        telefonoResponse.setNumero(telefono.getNumero());
        telefonoResponse.setCodigoCiudad(telefono.getCodigoCiudad());
        telefonoResponse.setCodigoPais(telefono.getCodigoPais());

        return telefonoResponse;

    }
}
