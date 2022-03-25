package cl.ejercicio.modelo;

import javax.persistence.*;
@Entity
@Table(name="estado")
public class Estado {



    @Id
    @Column(name="id_estado")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstado;

    @Column(name="estado")
    private String estado;
    public Estado(){

    }
    public Estado(int idEstado){
        this.idEstado=idEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
