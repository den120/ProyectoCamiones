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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacen.findAll", query = "SELECT a FROM Almacen a"),
    @NamedQuery(name = "Almacen.findByAlmacenCodigo", query = "SELECT a FROM Almacen a WHERE a.almacenCodigo = :almacenCodigo"),
    @NamedQuery(name = "Almacen.findByAlmacenNumero", query = "SELECT a FROM Almacen a WHERE a.almacenNumero = :almacenNumero"),
    @NamedQuery(name = "Almacen.findByAlmacenDireccion", query = "SELECT a FROM Almacen a WHERE a.almacenDireccion = :almacenDireccion"),
    @NamedQuery(name = "Almacen.findByAlmacenTelefono", query = "SELECT a FROM Almacen a WHERE a.almacenTelefono = :almacenTelefono")})
public class Almacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALMACEN_CODIGO")
    private Integer almacenCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALMACEN_NUMERO")
    private int almacenNumero;
    @Size(max = 200)
    @Column(name = "ALMACEN_DIRECCION")
    private String almacenDireccion;
    @Size(max = 15)
    @Column(name = "ALMACEN_TELEFONO")
    private String almacenTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "almacenCodigo")
    private List<AlmPro> almProList;

    public Almacen() {
    }

    public Almacen(Integer almacenCodigo) {
        this.almacenCodigo = almacenCodigo;
    }

    public Almacen(Integer almacenCodigo, int almacenNumero) {
        this.almacenCodigo = almacenCodigo;
        this.almacenNumero = almacenNumero;
    }

    public Integer getAlmacenCodigo() {
        return almacenCodigo;
    }

    public void setAlmacenCodigo(Integer almacenCodigo) {
        this.almacenCodigo = almacenCodigo;
    }

    public int getAlmacenNumero() {
        return almacenNumero;
    }

    public void setAlmacenNumero(int almacenNumero) {
        this.almacenNumero = almacenNumero;
    }

    public String getAlmacenDireccion() {
        return almacenDireccion;
    }

    public void setAlmacenDireccion(String almacenDireccion) {
        this.almacenDireccion = almacenDireccion;
    }

    public String getAlmacenTelefono() {
        return almacenTelefono;
    }

    public void setAlmacenTelefono(String almacenTelefono) {
        this.almacenTelefono = almacenTelefono;
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
        hash += (almacenCodigo != null ? almacenCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacen)) {
            return false;
        }
        Almacen other = (Almacen) object;
        if ((this.almacenCodigo == null && other.almacenCodigo != null) || (this.almacenCodigo != null && !this.almacenCodigo.equals(other.almacenCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Almacen[ almacenCodigo=" + almacenCodigo + " ]";
    }
    
}
