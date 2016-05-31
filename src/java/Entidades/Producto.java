/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProductoCodigo", query = "SELECT p FROM Producto p WHERE p.productoCodigo = :productoCodigo"),
    @NamedQuery(name = "Producto.findByProductoNombre", query = "SELECT p FROM Producto p WHERE p.productoNombre = :productoNombre")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTO_CODIGO")
    private Integer productoCodigo;
    @Size(max = 100)
    @Column(name = "PRODUCTO_NOMBRE")
    private String productoNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoCodigo")
    private List<PediPro> pediProList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoCodigo")
    private List<AlmPro> almProList;

    public Producto() {
    }

    public Producto(Integer productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public Integer getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(Integer productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    @XmlTransient
    public List<PediPro> getPediProList() {
        return pediProList;
    }

    public void setPediProList(List<PediPro> pediProList) {
        this.pediProList = pediProList;
    }

    @XmlTransient
    public List<AlmPro> getAlmProList() {
        return almProList;
    }

    public void setAlmProList(List<AlmPro> almProList) {
        this.almProList = almProList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoCodigo != null ? productoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.productoCodigo == null && other.productoCodigo != null) || (this.productoCodigo != null && !this.productoCodigo.equals(other.productoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Producto[ productoCodigo=" + productoCodigo + " ]";
    }
    
}
