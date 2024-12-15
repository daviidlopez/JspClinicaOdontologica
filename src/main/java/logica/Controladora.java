/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author davii
 */
public class Controladora {
    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario(Usuario usuario) {
        controlPersis.crearUsuario(usuario);
    }

    public List<Usuario> getUsuarios() {
        return controlPersis.getUsuarios();
    }

    public void eliminarUsuario(int id) {
        controlPersis.borrarUsuario(id);
    }

    public Usuario getUsuario(int id) {
        return controlPersis.getUsuario(id);
    }

    public void editarUsuario(Usuario usuario) {
        controlPersis.editarUsuario(usuario);
    }
}
