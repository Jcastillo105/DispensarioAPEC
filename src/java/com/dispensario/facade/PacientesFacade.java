/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.facade;

import com.dispensario.jc.Pacientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dispensario.jc.Pacientes_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.dispensario.jc.RegistroVisitas;
import java.util.Collection;

/**
 *
 * @author josee
 */
@Stateless
public class PacientesFacade extends AbstractFacade<Pacientes> {

    @PersistenceContext(unitName = "DispensarioMedicoAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacientesFacade() {
        super(Pacientes.class);
    }

    public boolean isRegistroVisitasCollectionEmpty(Pacientes entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pacientes> pacientes = cq.from(Pacientes.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pacientes, entity), cb.isNotEmpty(pacientes.get(Pacientes_.registroVisitasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistroVisitas> findRegistroVisitasCollection(Pacientes entity) {
        Pacientes mergedEntity = this.getMergedEntity(entity);
        Collection<RegistroVisitas> registroVisitasCollection = mergedEntity.getRegistroVisitasCollection();
        registroVisitasCollection.size();
        return registroVisitasCollection;
    }
    
}
