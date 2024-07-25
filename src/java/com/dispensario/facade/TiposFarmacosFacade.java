/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.facade;

import com.dispensario.jc.TiposFarmacos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dispensario.jc.TiposFarmacos_;
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
public class TiposFarmacosFacade extends AbstractFacade<TiposFarmacos> {

    @PersistenceContext(unitName = "DispensarioMedicoAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposFarmacosFacade() {
        super(TiposFarmacos.class);
    }

    public boolean isMedicamentosCollectionEmpty(TiposFarmacos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposFarmacos> tiposFarmacos = cq.from(TiposFarmacos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposFarmacos, entity), cb.isNotEmpty(tiposFarmacos.get(TiposFarmacos_.medicamentosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Medicamentos> findMedicamentosCollection(TiposFarmacos entity) {
        TiposFarmacos mergedEntity = this.getMergedEntity(entity);
        Collection<Medicamentos> medicamentosCollection = mergedEntity.getMedicamentosCollection();
        medicamentosCollection.size();
        return medicamentosCollection;
    }
    
}
