/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author davii
 */
@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_horario;
    private String horario_inicio;
    private String orario_fin;

    public Horario() {
    }

    public Horario(int id_horario, String horario_inicio, String orario_fin) {
        this.id_horario = id_horario;
        this.horario_inicio = horario_inicio;
        this.orario_fin = orario_fin;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(String horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public String getOrario_fin() {
        return orario_fin;
    }

    public void setOrario_fin(String orario_fin) {
        this.orario_fin = orario_fin;
    }
    
    
}
