/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.facade;

import com.dispensario.jc.Marcas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dispensario.jc.Marcas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.dispensario.jc.Medicamentos;
import java.util.Collection;

/**
 *
 * @author josee
 */
@Stateless
public class MarcasFacade extends AbstractFacade<Marcas> {

    @PersistenceContext(unitName = "DispensarioMedicoAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcasFacade() {
        super(Marcas.class);
    }

    public boolean isMedicamentosCollectionEmpty(Marcas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Marcas> marcas = cq.from(Marcas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(marcas, entity), cb.isNotEmpty(marcas.get(Marcas_.medicamentosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Medicamentos> findMedicamentosCollection(Marcas entity) {
        Marcas mergedEntity = this.getMergedEntity(entity);
        Collection<Medicamentos> medicamentosCollection = mergedEntity.getMedicamentosCollection();
        medicamentosCollection.size();
        return medicamentosCollection;
    }
    
}
