package cl.ejercicio.modelo;

import javax.persistence.*;

@Entity
@Table(name="telefono")
public class Telefono {

    @Id
    @Column(name="id_telefono")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTelefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Column(name="numero")
    private String numero;

    @Column(name="codigo_pais")
    private String codigoPais;

    @Column(name="codigo_ciudad")
    private String codigoCiudad;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }
}
