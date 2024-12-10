/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author davii
 */
@Entity
public class Odontologo extends Persona {
    
    private String especialidad;
    
    //Recuerda que si no mapeas es como si hicieses un N:M en XAMP
    //En la base de datos la fk va al lado de la N, pero usando clases la N va al lado del uno, o sea la coleccion(N) va en esta clase(1)
    @OneToMany(mappedBy="odonto")
    private List <Turno> lista_Turno;
    
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Horario horario;

    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> lista_Turno, Usuario usuario, Horario horario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.lista_Turno = lista_Turno;
        this.usuario = usuario;
        this.horario = horario;
    }
    

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getLista_Turno() {
        return lista_Turno;
    }

    public void setLista_Turno(List<Turno> lista_Turno) {
        this.lista_Turno = lista_Turno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
}
