package cl.ejercicio.service

import cl.ejercicio.Util.JwtUtil
import cl.ejercicio.Util.Utilidades
import cl.ejercicio.controlador.UsuarioController
import cl.ejercicio.converter.UsuarioConverter
import cl.ejercicio.dto.TelefonoDTO
import cl.ejercicio.dto.UsuarioRequestDTO
import cl.ejercicio.dto.UsuarioResponseDTO
import cl.ejercicio.exception.UsuarioException
import cl.ejercicio.exception.ValidacionException
import cl.ejercicio.modelo.Usuario
import cl.ejercicio.repositorio.UsuarioRepository
import cl.ejercicio.servicio.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

class UsuarioServiceSpect extends Specification{


	private UsuarioService usuarioService
	private UsuarioConverter usuarioConverter
	private UsuarioRepository usuarioRepository
	private Utilidades utilidades
	private JwtUtil jwtUtil


	def setup(){
		usuarioService=new UsuarioService()
		usuarioConverter=new UsuarioConverter()
		utilidades=new Utilidades()
		utilidades.patronMail="[a-zA-z0-9\\\\.]*@[a-zA-z0-9\\\\.]*"
		utilidades.patronPass="[a-zA-z0-9]+"
		jwtUtil=new JwtUtil()
		jwtUtil.secret="secreto"
		usuarioRepository=Mock()
		usuarioService.usuarioConverter=usuarioConverter
		usuarioService.usuarioRepository=usuarioRepository
		usuarioService.utilidades=utilidades
		usuarioService.jwtUtil=jwtUtil
	}

	def "guardar usuario"(){
		given: "usuario"
		UsuarioRequestDTO request=new UsuarioRequestDTO()
		request.setNombre("Juan")
		request.setCorreo("mail@mail")
		request.setPassword("123123")
		TelefonoDTO telefono=new TelefonoDTO()
		telefono.setNumero("12345678")
		telefono.setCodigoCiudad("2")
		telefono.setCodigoPais("56")
		request.setTelefonos(Arrays.asList(telefono))

		usuarioRepository.save(_) >> null
		usuarioRepository.findByCorreo(_) >> null

		when: "guardr usuario"
		UsuarioResponseDTO respuesta=usuarioService.guardarUsuario(request)

		then: "ok"
		respuesta.getCorreo()==request.getCorreo()

	}

	def "guardar usuario error"(){
		given: "usuario"
		UsuarioRequestDTO request=new UsuarioRequestDTO()
		request.setNombre("Juan")
		request.setCorreo(mail)
		request.setPassword(pass)
		TelefonoDTO telefono=new TelefonoDTO()
		telefono.setNumero("12345678")
		telefono.setCodigoCiudad("2")
		telefono.setCodigoPais("56")
		request.setTelefonos(Arrays.asList(telefono))

		usuarioRepository.save(_) >> null
		usuarioRepository.findByCorreo(_) >> usuario

		when: "guardr usuario"
		UsuarioResponseDTO respuesta=usuarioService.guardarUsuario(request)

		then: "ok"
		thrown(error)

		where:
		mail|pass|error                        |usuario
		null|"123"| ValidacionException        |null
		""|"123"| ValidacionException          |null
		"qweqwe"|"123"| ValidacionException    |null
		"mail@a.cl"|null| ValidacionException  |null
		"mail@a.cl"|""| ValidacionException    |null
		"mail@a.cl"|"123123"| UsuarioException |new Usuario()
	}

}
