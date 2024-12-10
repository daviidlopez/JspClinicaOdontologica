/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Turno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Odontologo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author davii
 */
public class OdontologoJpaController implements Serializable {

    public OdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public OdontologoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ConsultorioOdontologicoPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Odontologo odontologo) {
        if (odontologo.getLista_Turno() == null) {
            odontologo.setLista_Turno(new ArrayList<Turno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turno> attachedLista_Turno = new ArrayList<Turno>();
            for (Turno lista_TurnoTurnoToAttach : odontologo.getLista_Turno()) {
                lista_TurnoTurnoToAttach = em.getReference(lista_TurnoTurnoToAttach.getClass(), lista_TurnoTurnoToAttach.getId_turno());
                attachedLista_Turno.add(lista_TurnoTurnoToAttach);
            }
            odontologo.setLista_Turno(attachedLista_Turno);
            em.persist(odontologo);
            for (Turno lista_TurnoTurno : odontologo.getLista_Turno()) {
                Odontologo oldOdontoOfLista_TurnoTurno = lista_TurnoTurno.getOdonto();
                lista_TurnoTurno.setOdonto(odontologo);
                lista_TurnoTurno = em.merge(lista_TurnoTurno);
                if (oldOdontoOfLista_TurnoTurno != null) {
                    oldOdontoOfLista_TurnoTurno.getLista_Turno().remove(lista_TurnoTurno);
                    oldOdontoOfLista_TurnoTurno = em.merge(oldOdontoOfLista_TurnoTurno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Odontologo odontologo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo persistentOdontologo = em.find(Odontologo.class, odontologo.getId());
            List<Turno> lista_TurnoOld = persistentOdontologo.getLista_Turno();
            List<Turno> lista_TurnoNew = odontologo.getLista_Turno();
            List<Turno> attachedLista_TurnoNew = new ArrayList<Turno>();
            for (Turno lista_TurnoNewTurnoToAttach : lista_TurnoNew) {
                lista_TurnoNewTurnoToAttach = em.getReference(lista_TurnoNewTurnoToAttach.getClass(), lista_TurnoNewTurnoToAttach.getId_turno());
                attachedLista_TurnoNew.add(lista_TurnoNewTurnoToAttach);
            }
            lista_TurnoNew = attachedLista_TurnoNew;
            odontologo.setLista_Turno(lista_TurnoNew);
            odontologo = em.merge(odontologo);
            for (Turno lista_TurnoOldTurno : lista_TurnoOld) {
                if (!lista_TurnoNew.contains(lista_TurnoOldTurno)) {
                    lista_TurnoOldTurno.setOdonto(null);
                    lista_TurnoOldTurno = em.merge(lista_TurnoOldTurno);
                }
            }
            for (Turno lista_TurnoNewTurno : lista_TurnoNew) {
                if (!lista_TurnoOld.contains(lista_TurnoNewTurno)) {
                    Odontologo oldOdontoOfLista_TurnoNewTurno = lista_TurnoNewTurno.getOdonto();
                    lista_TurnoNewTurno.setOdonto(odontologo);
                    lista_TurnoNewTurno = em.merge(lista_TurnoNewTurno);
                    if (oldOdontoOfLista_TurnoNewTurno != null && !oldOdontoOfLista_TurnoNewTurno.equals(odontologo)) {
                        oldOdontoOfLista_TurnoNewTurno.getLista_Turno().remove(lista_TurnoNewTurno);
                        oldOdontoOfLista_TurnoNewTurno = em.merge(oldOdontoOfLista_TurnoNewTurno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = odontologo.getId();
                if (findOdontologo(id) == null) {
                    throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo odontologo;
            try {
                odontologo = em.getReference(Odontologo.class, id);
                odontologo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.", enfe);
            }
            List<Turno> lista_Turno = odontologo.getLista_Turno();
            for (Turno lista_TurnoTurno : lista_Turno) {
                lista_TurnoTurno.setOdonto(null);
                lista_TurnoTurno = em.merge(lista_TurnoTurno);
            }
            em.remove(odontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Odontologo> findOdontologoEntities() {
        return findOdontologoEntities(true, -1, -1);
    }

    public List<Odontologo> findOdontologoEntities(int maxResults, int firstResult) {
        return findOdontologoEntities(false, maxResults, firstResult);
    }

    private List<Odontologo> findOdontologoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Odontologo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Odontologo findOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Odontologo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOdontologoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Odontologo> rt = cq.from(Odontologo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
