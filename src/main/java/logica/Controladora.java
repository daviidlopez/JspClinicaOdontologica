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

    public boolean verificarUsuario(String nomUsuario, String password) {
        //Si la base de datos fuera grande lo mejor sería hacer una query
        List<Usuario> listUsuarios = controlPersis.getUsuarios();
        boolean isLoginSuccessful = false;
        for (Usuario user: listUsuarios) {
            if (user.getNombreUsuario().equals(nomUsuario) && user.getContrasenia().equals(password))
                isLoginSuccessful = true;
        }
        return isLoginSuccessful;
    }
}
