package cl.ejercicio.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UsuarioResponseDTO {

    private String idUsuario;

    private LocalDateTime fechaCreacion;

    private LocalDateTime ultimoLogin;

    private String token;

    private boolean activo;

    private String nombre;

    private String correo;

    private String password;

    private List<TelefonoDTO> telefonos;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TelefonoDTO> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoDTO> telefonos) {
        this.telefonos = telefonos;
    }
}
