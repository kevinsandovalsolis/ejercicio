package cl.ejercicio.Util;

import cl.ejercicio.exception.ValidacionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Utilidades {

    @Value("${patrones.mail}")
    private String patronMail;

    @Value("${patrones.password}")
    private String patronPass;

    public void validarMail(String mail){
        Pattern pattern=Pattern.compile(patronMail,Pattern.CASE_INSENSITIVE);
        if(mail==null || !pattern.matcher(mail).find()) {
            throw new ValidacionException("Error validando mail");
        }
    }

    public void validarPassword(String pass){
        Pattern pattern=Pattern.compile(patronPass,Pattern.CASE_INSENSITIVE);
        if(pass==null || !pattern.matcher(pass).find()) {
            throw new ValidacionException("Error validando password");
        }
    }
}
