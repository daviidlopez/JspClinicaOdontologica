/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author davii
 */
public class ControladoraPersistencia {
    private HorarioJpaController horaJpa = new HorarioJpaController();
    private OdontologoJpaController odonJpa = new OdontologoJpaController();
    private PacienteJpaController pacienJpa = new PacienteJpaController();
    private PersonaJpaController personaJpa = new PersonaJpaController();
    private ResponsableJpaController responJpa = new ResponsableJpaController();
    private SecretarioJpaController secreJpa = new SecretarioJpaController();
    private TurnoJpaController turnoJpa = new TurnoJpaController();
    private UsuarioJpaController usuJpa = new UsuarioJpaController();

    public void crearUsuario(Usuario usuario) {
        usuJpa.create(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuario(int id) {
        return usuJpa.findUsuario(id);
    }

    public void editarUsuario(Usuario usuario) {
        try {
            usuJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
