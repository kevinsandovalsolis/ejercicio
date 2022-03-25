package cl.ejercicio.exception;

public class ValidacionException extends RuntimeException{

    private String mensaje;

    public ValidacionException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
