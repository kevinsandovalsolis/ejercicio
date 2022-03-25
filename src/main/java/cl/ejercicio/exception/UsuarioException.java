package cl.ejercicio.exception;

public class UsuarioException extends RuntimeException{

    private String mensaje;

    public UsuarioException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
