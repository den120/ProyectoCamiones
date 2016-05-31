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
@Table(name = "via_ped")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ViaPed.findAll", query = "SELECT v FROM ViaPed v"),
    @NamedQuery(name = "ViaPed.findByViaPedCodigo", query = "SELECT v FROM ViaPed v WHERE v.viaPedCodigo = :viaPedCodigo"),
    @NamedQuery(name = "ViaPed.findByViaPedPesoaux", query = "SELECT v FROM ViaPed v WHERE v.viaPedPesoaux = :viaPedPesoaux"),
    @NamedQuery(name = "ViaPed.findByViaPedVolaux", query = "SELECT v FROM ViaPed v WHERE v.viaPedVolaux = :viaPedVolaux"),
    @NamedQuery(name = "ViaPed.findByViaPedAux", query = "SELECT v FROM ViaPed v WHERE v.viaPedAux = :viaPedAux")})
public class ViaPed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIA_PED_CODIGO")
    private Integer viaPedCodigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VIA_PED_PESOAUX")
    private Float viaPedPesoaux;
    @Column(name = "VIA_PED_VOLAUX")
    private Float viaPedVolaux;
    @Column(name = "VIA_PED_AUX")
    private Integer viaPedAux;
    @JoinColumn(name = "PEDIDO_CODIGO", referencedColumnName = "PEDIDO_CODIGO")
    @ManyToOne(optional = false)
    private Pedido pedidoCodigo;
    @JoinColumn(name = "VIAJE_CODIGO", referencedColumnName = "VIAJE_CODIGO")
    @ManyToOne(optional = false)
    private Viaje viajeCodigo;

    public ViaPed() {
    }

    public ViaPed(Integer viaPedCodigo) {
        this.viaPedCodigo = viaPedCodigo;
    }

    public Integer getViaPedCodigo() {
        return viaPedCodigo;
    }

    public void setViaPedCodigo(Integer viaPedCodigo) {
        this.viaPedCodigo = viaPedCodigo;
    }

    public Float getViaPedPesoaux() {
        return viaPedPesoaux;
    }

    public void setViaPedPesoaux(Float viaPedPesoaux) {
        this.viaPedPesoaux = viaPedPesoaux;
    }

    public Float getViaPedVolaux() {
        return viaPedVolaux;
    }

    public void setViaPedVolaux(Float viaPedVolaux) {
        this.viaPedVolaux = viaPedVolaux;
    }

    public Integer getViaPedAux() {
        return viaPedAux;
    }

    public void setViaPedAux(Integer viaPedAux) {
        this.viaPedAux = viaPedAux;
    }

    public Pedido getPedidoCodigo() {
        return pedidoCodigo;
    }

    public void setPedidoCodigo(Pedido pedidoCodigo) {
        this.pedidoCodigo = pedidoCodigo;
    }

    public Viaje getViajeCodigo() {
        return viajeCodigo;
    }

    public void setViajeCodigo(Viaje viajeCodigo) {
        this.viajeCodigo = viajeCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viaPedCodigo != null ? viaPedCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ViaPed)) {
            return false;
        }
        ViaPed other = (ViaPed) object;
        if ((this.viaPedCodigo == null && other.viaPedCodigo != null) || (this.viaPedCodigo != null && !this.viaPedCodigo.equals(other.viaPedCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ViaPed[ viaPedCodigo=" + viaPedCodigo + " ]";
    }
    
}
