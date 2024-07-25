/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.jc;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josee
 */
@Entity
@Table(name = "TIPOS_FARMACOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposFarmacos.findAll", query = "SELECT t FROM TiposFarmacos t")
    , @NamedQuery(name = "TiposFarmacos.findByIdTipoFarmaco", query = "SELECT t FROM TiposFarmacos t WHERE t.idTipoFarmaco = :idTipoFarmaco")
    , @NamedQuery(name = "TiposFarmacos.findByDescripcion", query = "SELECT t FROM TiposFarmacos t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TiposFarmacos.findByEstado", query = "SELECT t FROM TiposFarmacos t WHERE t.estado = :estado")})
public class TiposFarmacos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_FARMACO")
    private Integer idTipoFarmaco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idTipoFarmaco")
    private Collection<Medicamentos> medicamentosCollection;

    public TiposFarmacos() {
    }

    public TiposFarmacos(Integer idTipoFarmaco) {
        this.idTipoFarmaco = idTipoFarmaco;
    }

    public TiposFarmacos(Integer idTipoFarmaco, String descripcion, String estado) {
        this.idTipoFarmaco = idTipoFarmaco;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdTipoFarmaco() {
        return idTipoFarmaco;
    }

    public void setIdTipoFarmaco(Integer idTipoFarmaco) {
        this.idTipoFarmaco = idTipoFarmaco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Medicamentos> getMedicamentosCollection() {
        return medicamentosCollection;
    }

    public void setMedicamentosCollection(Collection<Medicamentos> medicamentosCollection) {
        this.medicamentosCollection = medicamentosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoFarmaco != null ? idTipoFarmaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposFarmacos)) {
            return false;
        }
        TiposFarmacos other = (TiposFarmacos) object;
        if ((this.idTipoFarmaco == null && other.idTipoFarmaco != null) || (this.idTipoFarmaco != null && !this.idTipoFarmaco.equals(other.idTipoFarmaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dispensario.jc.TiposFarmacos[ idTipoFarmaco=" + idTipoFarmaco + " ]";
    }
    
}
