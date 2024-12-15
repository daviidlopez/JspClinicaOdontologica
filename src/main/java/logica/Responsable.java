/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author davii
 */
@Entity
public class Responsable extends Persona {
    private String tipo_responsabilidad;

    public Responsable(String tipo_responsabilidad, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.tipo_responsabilidad = tipo_responsabilidad;
    }

    public Responsable() {
    }

    

    

    public String getTipo_responsabilidad() {
        return tipo_responsabilidad;
    }

    public void setTipo_responsabilidad(String tipo_responsabilidad) {
        this.tipo_responsabilidad = tipo_responsabilidad;
    }
    
    
}
