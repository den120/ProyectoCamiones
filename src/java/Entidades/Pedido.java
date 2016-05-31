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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByPedidoCodigo", query = "SELECT p FROM Pedido p WHERE p.pedidoCodigo = :pedidoCodigo"),
    @NamedQuery(name = "Pedido.findByPedidoNumero", query = "SELECT p FROM Pedido p WHERE p.pedidoNumero = :pedidoNumero"),
    @NamedQuery(name = "Pedido.findByPedidoPeso", query = "SELECT p FROM Pedido p WHERE p.pedidoPeso = :pedidoPeso"),
    @NamedQuery(name = "Pedido.findByPedidoVolumen", query = "SELECT p FROM Pedido p WHERE p.pedidoVolumen = :pedidoVolumen"),
    @NamedQuery(name = "Pedido.findByPedidoEstado", query = "SELECT p FROM Pedido p WHERE p.pedidoEstado = :pedidoEstado"),
    @NamedQuery(name = "Pedido.findByPedidoFecharealizacion", query = "SELECT p FROM Pedido p WHERE p.pedidoFecharealizacion = :pedidoFecharealizacion"),
    @NamedQuery(name = "Pedido.findByPedidoFechaentregra", query = "SELECT p FROM Pedido p WHERE p.pedidoFechaentregra = :pedidoFechaentregra")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PEDIDO_CODIGO")
    private Integer pedidoCodigo;
    @Column(name = "PEDIDO_NUMERO")
    private Integer pedidoNumero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PEDIDO_PESO")
    private Float pedidoPeso;
    @Column(name = "PEDIDO_VOLUMEN")
    private Float pedidoVolumen;
    @Column(name = "PEDIDO_ESTADO")
    private Integer pedidoEstado;
    @Size(max = 15)
    @Column(name = "PEDIDO_FECHAREALIZACION")
    private String pedidoFecharealizacion;
    @Size(max = 15)
    @Column(name = "PEDIDO_FECHAENTREGRA")
    private String pedidoFechaentregra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCodigo")
    private List<ViaPed> viaPedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoCodigo")
    private List<PediPro> pediProList;
    @JoinColumn(name = "TIENDA_CODIGO", referencedColumnName = "TIENDA_CODIGO")
    @ManyToOne(optional = false)
    private Tienda tiendaCodigo;

    public Pedido() {
    }

    public Pedido(Integer pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }

    public Integer getPedidoCodigo() {
        return pedidoCodigo;
    }

    public void setPedidoCodigo(Integer pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }

    public Integer getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(Integer pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }

    public Float getPedidoPeso() {
        return pedidoPeso;
    }

    public void setPedidoPeso(Float pedidoPeso) {
        this.pedidoPeso = pedidoPeso;
    }

    public Float getPedidoVolumen() {
        return pedidoVolumen;
    }

    public void setPedidoVolumen(Float pedidoVolumen) {
        this.pedidoVolumen = pedidoVolumen;
    }

    public Integer getPedidoEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(Integer pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public String getPedidoFecharealizacion() {
        return pedidoFecharealizacion;
    }

    public void setPedidoFecharealizacion(String pedidoFecharealizacion) {
        this.pedidoFecharealizacion = pedidoFecharealizacion;
    }

    public String getPedidoFechaentregra() {
        return pedidoFechaentregra;
    }

    public void setPedidoFechaentregra(String pedidoFechaentregra) {
        this.pedidoFechaentregra = pedidoFechaentregra;
    }

    @XmlTransient
    public List<ViaPed> getViaPedList() {
        return viaPedList;
    }

    public void setViaPedList(List<ViaPed> viaPedList) {
        this.viaPedList = viaPedList;
    }

    @XmlTransient
    public List<PediPro> getPediProList() {
        return pediProList;
    }

    public void setPediProList(List<PediPro> pediProList) {
        this.pediProList = pediProList;
    }

    public Tienda getTiendaCodigo() {
        return tiendaCodigo;
    }

    public void setTiendaCodigo(Tienda tiendaCodigo) {
        this.tiendaCodigo = tiendaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidoCodigo != null ? pedidoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedidoCodigo == null && other.pedidoCodigo != null) || (this.pedidoCodigo != null && !this.pedidoCodigo.equals(other.pedidoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedido[ pedidoCodigo=" + pedidoCodigo + " ]";
    }
    
}
