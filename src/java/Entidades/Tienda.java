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
@Table(name = "tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tienda.findAll", query = "SELECT t FROM Tienda t"),
    @NamedQuery(name = "Tienda.findByTiendaCodigo", query = "SELECT t FROM Tienda t WHERE t.tiendaCodigo = :tiendaCodigo"),
    @NamedQuery(name = "Tienda.findByTiendaNombre", query = "SELECT t FROM Tienda t WHERE t.tiendaNombre = :tiendaNombre"),
    @NamedQuery(name = "Tienda.findByTiendaDireccion", query = "SELECT t FROM Tienda t WHERE t.tiendaDireccion = :tiendaDireccion"),
    @NamedQuery(name = "Tienda.findByTiendaTelefono", query = "SELECT t FROM Tienda t WHERE t.tiendaTelefono = :tiendaTelefono")})
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TIENDA_CODIGO")
    private Integer tiendaCodigo;
    @Size(max = 200)
    @Column(name = "TIENDA_NOMBRE")
    private String tiendaNombre;
    @Size(max = 100)
    @Column(name = "TIENDA_DIRECCION")
    private String tiendaDireccion;
    @Size(max = 15)
    @Column(name = "TIENDA_TELEFONO")
    private String tiendaTelefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiendaCodigo")
    private List<Pedido> pedidoList;

    public Tienda() {
    }

    public Tienda(Integer tiendaCodigo) {
        this.tiendaCodigo = tiendaCodigo;
    }

    public Integer getTiendaCodigo() {
        return tiendaCodigo;
    }

    public void setTiendaCodigo(Integer tiendaCodigo) {
        this.tiendaCodigo = tiendaCodigo;
    }

    public String getTiendaNombre() {
        return tiendaNombre;
    }

    public void setTiendaNombre(String tiendaNombre) {
        this.tiendaNombre = tiendaNombre;
    }

    public String getTiendaDireccion() {
        return tiendaDireccion;
    }

    public void setTiendaDireccion(String tiendaDireccion) {
        this.tiendaDireccion = tiendaDireccion;
    }

    public String getTiendaTelefono() {
        return tiendaTelefono;
    }

    public void setTiendaTelefono(String tiendaTelefono) {
        this.tiendaTelefono = tiendaTelefono;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiendaCodigo != null ? tiendaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tienda)) {
            return false;
        }
        Tienda other = (Tienda) object;
        if ((this.tiendaCodigo == null && other.tiendaCodigo != null) || (this.tiendaCodigo != null && !this.tiendaCodigo.equals(other.tiendaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tienda[ tiendaCodigo=" + tiendaCodigo + " ]";
    }
    
}
