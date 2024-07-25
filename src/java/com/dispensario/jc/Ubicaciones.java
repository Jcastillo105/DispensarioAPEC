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
@Table(name = "UBICACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicaciones.findAll", query = "SELECT u FROM Ubicaciones u")
    , @NamedQuery(name = "Ubicaciones.findByIdUbicacion", query = "SELECT u FROM Ubicaciones u WHERE u.idUbicacion = :idUbicacion")
    , @NamedQuery(name = "Ubicaciones.findByDescripcion", query = "SELECT u FROM Ubicaciones u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "Ubicaciones.findByEstante", query = "SELECT u FROM Ubicaciones u WHERE u.estante = :estante")
    , @NamedQuery(name = "Ubicaciones.findByTramo", query = "SELECT u FROM Ubicaciones u WHERE u.tramo = :tramo")
    , @NamedQuery(name = "Ubicaciones.findByCelda", query = "SELECT u FROM Ubicaciones u WHERE u.celda = :celda")
    , @NamedQuery(name = "Ubicaciones.findByEstado", query = "SELECT u FROM Ubicaciones u WHERE u.estado = :estado")})
public class Ubicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UBICACION")
    private Integer idUbicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESTANTE")
    private String estante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TRAMO")
    private String tramo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CELDA")
    private String celda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "idUbicacion")
    private Collection<Medicamentos> medicamentosCollection;

    public Ubicaciones() {
    }

    public Ubicaciones(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Ubicaciones(Integer idUbicacion, String descripcion, String estante, String tramo, String celda, String estado) {
        this.idUbicacion = idUbicacion;
        this.descripcion = descripcion;
        this.estante = estante;
        this.tramo = tramo;
        this.celda = celda;
        this.estado = estado;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getTramo() {
        return tramo;
    }

    public void setTramo(String tramo) {
        this.tramo = tramo;
    }

    public String getCelda() {
        return celda;
    }

    public void setCelda(String celda) {
        this.celda = celda;
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
        hash += (idUbicacion != null ? idUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicaciones)) {
            return false;
        }
        Ubicaciones other = (Ubicaciones) object;
        if ((this.idUbicacion == null && other.idUbicacion != null) || (this.idUbicacion != null && !this.idUbicacion.equals(other.idUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dispensario.jc.Ubicaciones[ idUbicacion=" + idUbicacion + " ]";
    }
    
}
