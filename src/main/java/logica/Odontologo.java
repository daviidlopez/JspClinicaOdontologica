/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;
import java.util.List;

/**
 *
 * @author davii
 */
public class Odontologo extends Persona {
    private int id_odontologo;
    private String especialidad;
    
    private List <Turno> lista_Turno;
    private Usuario usuario;
    private Horario horario;

    public Odontologo() {
    }

    public Odontologo(int id_odontologo, String especialidad, List<Turno> lista_Turno, Usuario usuario, Horario horario, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.id_odontologo = id_odontologo;
        this.especialidad = especialidad;
        this.lista_Turno = lista_Turno;
        this.usuario = usuario;
        this.horario = horario;
    }

    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
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
