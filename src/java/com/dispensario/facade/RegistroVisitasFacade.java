/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.facade;

import com.dispensario.jc.RegistroVisitas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dispensario.jc.RegistroVisitas_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.dispensario.jc.Medicos;
import com.dispensario.jc.Pacientes;

/**
 *
 * @author josee
 */
@Stateless
public class RegistroVisitasFacade extends AbstractFacade<RegistroVisitas> {

    @PersistenceContext(unitName = "DispensarioMedicoAPECPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroVisitasFacade() {
        super(RegistroVisitas.class);
    }

    public boolean isIdMedicoEmpty(RegistroVisitas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistroVisitas> registroVisitas = cq.from(RegistroVisitas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registroVisitas, entity), cb.isNotNull(registroVisitas.get(RegistroVisitas_.idMedico)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Medicos findIdMedico(RegistroVisitas entity) {
        return this.getMergedEntity(entity).getIdMedico();
    }

    public boolean isIdPacienteEmpty(RegistroVisitas entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RegistroVisitas> registroVisitas = cq.from(RegistroVisitas.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(registroVisitas, entity), cb.isNotNull(registroVisitas.get(RegistroVisitas_.idPaciente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Pacientes findIdPaciente(RegistroVisitas entity) {
        return this.getMergedEntity(entity).getIdPaciente();
    }
    
}
