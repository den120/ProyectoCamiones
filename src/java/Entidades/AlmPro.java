/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "alm_pro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlmPro.findAll", query = "SELECT a FROM AlmPro a"),
    @NamedQuery(name = "AlmPro.findByAlmProCodigo", query = "SELECT a FROM AlmPro a WHERE a.almProCodigo = :almProCodigo"),
    @NamedQuery(name = "AlmPro.findByAlmProCantidad", query = "SELECT a FROM AlmPro a WHERE a.almProCantidad = :almProCantidad")})
public class AlmPro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALM_PRO_CODIGO")
    private Integer almProCodigo;
    @Column(name = "ALM_PRO_CANTIDAD")
    private Integer almProCantidad;
    @JoinColumn(name = "PRODUCTO_CODIGO", referencedColumnName = "PRODUCTO_CODIGO")
    @ManyToOne(optional = false)
    private Producto productoCodigo;
    @JoinColumn(name = "ALMACEN_CODIGO", referencedColumnName = "ALMACEN_CODIGO")
    @ManyToOne(optional = false)
    private Almacen almacenCodigo;

    public AlmPro() {
    }

    public AlmPro(Integer almProCodigo) {
        this.almProCodigo = almProCodigo;
    }

    public Integer getAlmProCodigo() {
        return almProCodigo;
    }

    public void setAlmProCodigo(Integer almProCodigo) {
        this.almProCodigo = almProCodigo;
    }

    public Integer getAlmProCantidad() {
        return almProCantidad;
    }

    public void setAlmProCantidad(Integer almProCantidad) {
        this.almProCantidad = almProCantidad;
    }

    public Producto getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(Producto productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public Almacen getAlmacenCodigo() {
        return almacenCodigo;
    }

    public void setAlmacenCodigo(Almacen almacenCodigo) {
        this.almacenCodigo = almacenCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (almProCodigo != null ? almProCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmPro)) {
            return false;
        }
        AlmPro other = (AlmPro) object;
        if ((this.almProCodigo == null && other.almProCodigo != null) || (this.almProCodigo != null && !this.almProCodigo.equals(other.almProCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.AlmPro[ almProCodigo=" + almProCodigo + " ]";
    }
    
}
