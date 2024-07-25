/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.facade;

import com.dispensario.jc.Medicamentos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dispensario.jc.Medicamentos_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.dispensario.jc.Marcas;
import com.dispensario.jc.TiposFarmacos;
import com.dispensario.jc.Ubicaciones;

/**
 *
 * @author josee
 */
@Stateless
public class MedicamentosFacade extends AbstractFacade<Medicamentos> {

    @PersistenceContext(unitName = "DispensarioMedicoAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicamentosFacade() {
        super(Medicamentos.class);
    }

    public boolean isIdMarcaEmpty(Medicamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicamentos> medicamentos = cq.from(Medicamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicamentos, entity), cb.isNotNull(medicamentos.get(Medicamentos_.idMarca)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Marcas findIdMarca(Medicamentos entity) {
        return this.getMergedEntity(entity).getIdMarca();
    }

    public boolean isIdTipoFarmacoEmpty(Medicamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicamentos> medicamentos = cq.from(Medicamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicamentos, entity), cb.isNotNull(medicamentos.get(Medicamentos_.idTipoFarmaco)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TiposFarmacos findIdTipoFarmaco(Medicamentos entity) {
        return this.getMergedEntity(entity).getIdTipoFarmaco();
    }

    public boolean isIdUbicacionEmpty(Medicamentos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Medicamentos> medicamentos = cq.from(Medicamentos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(medicamentos, entity), cb.isNotNull(medicamentos.get(Medicamentos_.idUbicacion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ubicaciones findIdUbicacion(Medicamentos entity) {
        return this.getMergedEntity(entity).getIdUbicacion();
    }
    
}
