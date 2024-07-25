/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.facade;

import com.dispensario.jc.Medicos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dispensario.jc.Medicos_;
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
public class MedicosFacade extends AbstractFacade<Medicos> {

    @PersistenceContext(unitName = "DispensarioMedicoAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicosFacade() {
        super(Medicos.class);
    }

    public boolean isRegistroVisitasCollectionEmpty(Medicos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicos> medicos = cq.from(Medicos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicos, entity), cb.isNotEmpty(medicos.get(Medicos_.registroVisitasCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistroVisitas> findRegistroVisitasCollection(Medicos entity) {
        Medicos mergedEntity = this.getMergedEntity(entity);
        Collection<RegistroVisitas> registroVisitasCollection = mergedEntity.getRegistroVisitasCollection();
        registroVisitasCollection.size();
        return registroVisitasCollection;
    }
    
}
