/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dispensario.jc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josee
 */
@Entity
@Table(name = "MEDICAMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamentos.findAll", query = "SELECT m FROM Medicamentos m")
    , @NamedQuery(name = "Medicamentos.findByIdMedicamento", query = "SELECT m FROM Medicamentos m WHERE m.idMedicamento = :idMedicamento")
    , @NamedQuery(name = "Medicamentos.findByDescripcion", query = "SELECT m FROM Medicamentos m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Medicamentos.findByDosis", query = "SELECT m FROM Medicamentos m WHERE m.dosis = :dosis")
    , @NamedQuery(name = "Medicamentos.findByStock", query = "SELECT m FROM Medicamentos m WHERE m.stock = :stock")
    , @NamedQuery(name = "Medicamentos.findByEstado", query = "SELECT m FROM Medicamentos m WHERE m.estado = :estado")})
public class Medicamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MEDICAMENTO")
    private Integer idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DOSIS")
    private String dosis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STOCK")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne
    private Marcas idMarca;
    @JoinColumn(name = "ID_TIPO_FARMACO", referencedColumnName = "ID_TIPO_FARMACO")
    @ManyToOne
    private TiposFarmacos idTipoFarmaco;
    @JoinColumn(name = "ID_UBICACION", referencedColumnName = "ID_UBICACION")
    @ManyToOne
    private Ubicaciones idUbicacion;

    public Medicamentos() {
    }

    public Medicamentos(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamentos(Integer idMedicamento, String descripcion, String dosis, int stock, String estado) {
        this.idMedicamento = idMedicamento;
        this.descripcion = descripcion;
        this.dosis = dosis;
        this.stock = stock;
        this.estado = estado;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public TiposFarmacos getIdTipoFarmaco() {
        return idTipoFarmaco;
    }

    public void setIdTipoFarmaco(TiposFarmacos idTipoFarmaco) {
        this.idTipoFarmaco = idTipoFarmaco;
    }

    public Ubicaciones getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicaciones idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamentos)) {
            return false;
        }
        Medicamentos other = (Medicamentos) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dispensario.jc.Medicamentos[ idMedicamento=" + idMedicamento + " ]";
    }
    
}
