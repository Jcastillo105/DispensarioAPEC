/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.jc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josee
 */
@Entity
@Table(name = "REGISTRO_VISITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroVisitas.findAll", query = "SELECT r FROM RegistroVisitas r")
    , @NamedQuery(name = "RegistroVisitas.findByIdVisita", query = "SELECT r FROM RegistroVisitas r WHERE r.idVisita = :idVisita")
    , @NamedQuery(name = "RegistroVisitas.findByFechaVisita", query = "SELECT r FROM RegistroVisitas r WHERE r.fechaVisita = :fechaVisita")
    , @NamedQuery(name = "RegistroVisitas.findByHoraVisita", query = "SELECT r FROM RegistroVisitas r WHERE r.horaVisita = :horaVisita")
    , @NamedQuery(name = "RegistroVisitas.findByMedicamentoSuministrado", query = "SELECT r FROM RegistroVisitas r WHERE r.medicamentoSuministrado = :medicamentoSuministrado")
    , @NamedQuery(name = "RegistroVisitas.findByEstado", query = "SELECT r FROM RegistroVisitas r WHERE r.estado = :estado")})
public class RegistroVisitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VISITA")
    private Integer idVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.DATE)
    private Date fechaVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA_VISITA")
    @Temporal(TemporalType.TIME)
    private Date horaVisita;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "SINTOMAS")
    private String sintomas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MEDICAMENTO_SUMINISTRADO")
    private String medicamentoSuministrado;
    @Lob
    @Column(name = "RECOMENDACIONES")
    private String recomendaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_MEDICO", referencedColumnName = "ID_MEDICO")
    @ManyToOne
    private Medicos idMedico;
    @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE")
    @ManyToOne
    private Pacientes idPaciente;

    public RegistroVisitas() {
    }

    public RegistroVisitas(Integer idVisita) {
        this.idVisita = idVisita;
    }

    public RegistroVisitas(Integer idVisita, Date fechaVisita, Date horaVisita, String sintomas, String medicamentoSuministrado, String estado) {
        this.idVisita = idVisita;
        this.fechaVisita = fechaVisita;
        this.horaVisita = horaVisita;
        this.sintomas = sintomas;
        this.medicamentoSuministrado = medicamentoSuministrado;
        this.estado = estado;
    }

    public Integer getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Integer idVisita) {
        this.idVisita = idVisita;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Date getHoraVisita() {
        return horaVisita;
    }

    public void setHoraVisita(Date horaVisita) {
        this.horaVisita = horaVisita;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getMedicamentoSuministrado() {
        return medicamentoSuministrado;
    }

    public void setMedicamentoSuministrado(String medicamentoSuministrado) {
        this.medicamentoSuministrado = medicamentoSuministrado;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medicos getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medicos idMedico) {
        this.idMedico = idMedico;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisita != null ? idVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroVisitas)) {
            return false;
        }
        RegistroVisitas other = (RegistroVisitas) object;
        if ((this.idVisita == null && other.idVisita != null) || (this.idVisita != null && !this.idVisita.equals(other.idVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dispensario.jc.RegistroVisitas[ idVisita=" + idVisita + " ]";
    }
    
}
