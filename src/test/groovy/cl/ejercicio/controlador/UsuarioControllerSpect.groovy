package cl.ejercicio.controlador;

import cl.ejercicio.dto.UsuarioRequestDTO;
import cl.ejercicio.dto.UsuarioResponseDTO;
import cl.ejercicio.servicio.UsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification;


class UsuarioControllerSpect extends Specification{



	private UsuarioService usuarioService=Mock()

	private UsuarioController usuarioController;


	def setup(){
		usuarioController=new UsuarioController()
		usuarioController.usuarioService=usuarioService
	}

	def "guardar usuario"(){
		given: "usuario"
		usuarioService.guardarUsuario(_)>> new UsuarioResponseDTO();

		when: "guardr usuario"
		UsuarioResponseDTO respuesta=usuarioController.guardarUsuarios(new UsuarioRequestDTO())

		then: "ok"
		respuesta

	}

}
