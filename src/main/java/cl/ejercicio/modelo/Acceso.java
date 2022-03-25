package cl.ejercicio.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="acceso")
public class Acceso {

    @Id
    @Column(name="id_acceso")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAcceso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @Column(name="fecha_ingreso")
    private LocalDateTime fechaIngreso;

    public Acceso(){}
    public Acceso(LocalDateTime fecha){
        this.fechaIngreso=fecha;
    }
    public int getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(int idAcceso) {
        this.idAcceso = idAcceso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
