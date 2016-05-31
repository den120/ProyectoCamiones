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
@Table(name = "pedi_pro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PediPro.findAll", query = "SELECT p FROM PediPro p"),
    @NamedQuery(name = "PediPro.findByPediProCodigo", query = "SELECT p FROM PediPro p WHERE p.pediProCodigo = :pediProCodigo"),
    @NamedQuery(name = "PediPro.findByPeproCantidad", query = "SELECT p FROM PediPro p WHERE p.peproCantidad = :peproCantidad"),
    @NamedQuery(name = "PediPro.findByPreproPeso", query = "SELECT p FROM PediPro p WHERE p.preproPeso = :preproPeso")})
public class PediPro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEDI_PRO_CODIGO")
    private Integer pediProCodigo;
    @Column(name = "PEPRO_CANTIDAD")
    private Integer peproCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PREPRO_PESO")
    private Float preproPeso;
    @JoinColumn(name = "PEDIDO_CODIGO", referencedColumnName = "PEDIDO_CODIGO")
    @ManyToOne(optional = false)
    private Pedido pedidoCodigo;
    @JoinColumn(name = "PRODUCTO_CODIGO", referencedColumnName = "PRODUCTO_CODIGO")
    @ManyToOne(optional = false)
    private Producto productoCodigo;

    public PediPro() {
    }

    public PediPro(Integer pediProCodigo) {
        this.pediProCodigo = pediProCodigo;
    }

    public Integer getPediProCodigo() {
        return pediProCodigo;
    }

    public void setPediProCodigo(Integer pediProCodigo) {
        this.pediProCodigo = pediProCodigo;
    }

    public Integer getPeproCantidad() {
        return peproCantidad;
    }

    public void setPeproCantidad(Integer peproCantidad) {
        this.peproCantidad = peproCantidad;
    }

    public Float getPreproPeso() {
        return preproPeso;
    }

    public void setPreproPeso(Float preproPeso) {
        this.preproPeso = preproPeso;
    }

    public Pedido getPedidoCodigo() {
        return pedidoCodigo;
    }

    public void setPedidoCodigo(Pedido pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }

    public Producto getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(Producto productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pediProCodigo != null ? pediProCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PediPro)) {
            return false;
        }
        PediPro other = (PediPro) object;
        if ((this.pediProCodigo == null && other.pediProCodigo != null) || (this.pediProCodigo != null && !this.pediProCodigo.equals(other.pediProCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PediPro[ pediProCodigo=" + pediProCodigo + " ]";
    }
    
}
