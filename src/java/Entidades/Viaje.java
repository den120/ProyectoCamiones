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
@Table(name = "viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viaje.findAll", query = "SELECT v FROM Viaje v"),
    @NamedQuery(name = "Viaje.findByViajeCodigo", query = "SELECT v FROM Viaje v WHERE v.viajeCodigo = :viajeCodigo"),
    @NamedQuery(name = "Viaje.findByViajeNumero", query = "SELECT v FROM Viaje v WHERE v.viajeNumero = :viajeNumero"),
    @NamedQuery(name = "Viaje.findByViajeFecha", query = "SELECT v FROM Viaje v WHERE v.viajeFecha = :viajeFecha"),
    @NamedQuery(name = "Viaje.findByViajeDireccion", query = "SELECT v FROM Viaje v WHERE v.viajeDireccion = :viajeDireccion")})
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VIAJE_CODIGO")
    private Integer viajeCodigo;
    @Column(name = "VIAJE_NUMERO")
    private Integer viajeNumero;
    @Size(max = 15)
    @Column(name = "VIAJE_FECHA")
    private String viajeFecha;
    @Size(max = 200)
    @Column(name = "VIAJE_DIRECCION")
    private String viajeDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "viajeCodigo")
    private List<ViaPed> viaPedList;
    @JoinColumn(name = "CAMION_CODIGO", referencedColumnName = "CAMION_CODIGO")
    @ManyToOne
    private Camion camionCodigo;

    public Viaje() {
    }

    public Viaje(Integer viajeCodigo) {
        this.viajeCodigo = viajeCodigo;
    }

    public Integer getViajeCodigo() {
        return viajeCodigo;
    }

    public void setViajeCodigo(Integer viajeCodigo) {
        this.viajeCodigo = viajeCodigo;
    }

    public Integer getViajeNumero() {
        return viajeNumero;
    }

    public void setViajeNumero(Integer viajeNumero) {
        this.viajeNumero = viajeNumero;
    }

    public String getViajeFecha() {
        return viajeFecha;
    }

    public void setViajeFecha(String viajeFecha) {
        this.viajeFecha = viajeFecha;
    }

    public String getViajeDireccion() {
        return viajeDireccion;
    }

    public void setViajeDireccion(String viajeDireccion) {
        this.viajeDireccion = viajeDireccion;
    }

    @XmlTransient
    public List<ViaPed> getViaPedList() {
        return viaPedList;
    }

    public void setViaPedList(List<ViaPed> viaPedList) {
        this.viaPedList = viaPedList;
    }

    public Camion getCamionCodigo() {
        return camionCodigo;
    }

    public void setCamionCodigo(Camion camionCodigo) {
        this.camionCodigo = camionCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (viajeCodigo != null ? viajeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.viajeCodigo == null && other.viajeCodigo != null) || (this.viajeCodigo != null && !this.viajeCodigo.equals(other.viajeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Viaje[ viajeCodigo=" + viajeCodigo + " ]";
    }
    
}
