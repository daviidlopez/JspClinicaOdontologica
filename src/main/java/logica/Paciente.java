/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;
import java.util.List;



public class Paciente extends Persona {
    private int id_paciente;
    private boolean tiene_OS;
    private String tipo_sangre;
    
    private Responsable responsable;
    private List <Turno> lista_Turno;

    public Paciente(int id_paciente, boolean tiene_OS, String tipo_sangre, Responsable responsable, List<Turno> lista_Turno, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.id_paciente = id_paciente;
        this.tiene_OS = tiene_OS;
        this.tipo_sangre = tipo_sangre;
        this.responsable = responsable;
        this.lista_Turno = lista_Turno;
    }
    
    

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public boolean isTiene_OS() {
        return tiene_OS;
    }

    public void setTiene_OS(boolean tiene_OS) {
        this.tiene_OS = tiene_OS;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }
    
    
    
}
