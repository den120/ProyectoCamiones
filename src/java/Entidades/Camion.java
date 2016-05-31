/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"),
    @NamedQuery(name = "Camion.findByCamionCodigo", query = "SELECT c FROM Camion c WHERE c.camionCodigo = :camionCodigo"),
    @NamedQuery(name = "Camion.findByCamionMatricula", query = "SELECT c FROM Camion c WHERE c.camionMatricula = :camionMatricula"),
    @NamedQuery(name = "Camion.findByCamionMaxvolumen", query = "SELECT c FROM Camion c WHERE c.camionMaxvolumen = :camionMaxvolumen"),
    @NamedQuery(name = "Camion.findByCamionPesomax", query = "SELECT c FROM Camion c WHERE c.camionPesomax = :camionPesomax"),
    @NamedQuery(name = "Camion.findByCamionDueno", query = "SELECT c FROM Camion c WHERE c.camionDueno = :camionDueno")})
public class Camion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CAMION_CODIGO")
    private Integer camionCodigo;
    @Size(max = 15)
    @Column(name = "CAMION_MATRICULA")
    private String camionMatricula;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CAMION_MAXVOLUMEN")
    private Float camionMaxvolumen;
    @Column(name = "CAMION_PESOMAX")
    private Float camionPesomax;
    @Size(max = 400)
    @Column(name = "CAMION_DUENO")
    private String camionDueno;
    @OneToMany(mappedBy = "camionCodigo")
    private List<Viaje> viajeList;

    public Camion() {
    }

    public Camion(Integer camionCodigo) {
        this.camionCodigo = camionCodigo;
    }

    public Integer getCamionCodigo() {
        return camionCodigo;
    }

    public void setCamionCodigo(Integer camionCodigo) {
        this.camionCodigo = camionCodigo;
    }

    public String getCamionMatricula() {
        return camionMatricula;
    }

    public void setCamionMatricula(String camionMatricula) {
        this.camionMatricula = camionMatricula;
    }

    public Float getCamionMaxvolumen() {
        return camionMaxvolumen;
    }

    public void setCamionMaxvolumen(Float camionMaxvolumen) {
        this.camionMaxvolumen = camionMaxvolumen;
    }

    public Float getCamionPesomax() {
        return camionPesomax;
    }

    public void setCamionPesomax(Float camionPesomax) {
        this.camionPesomax = camionPesomax;
    }

    public String getCamionDueno() {
        return camionDueno;
    }

    public void setCamionDueno(String camionDueno) {
        this.camionDueno = camionDueno;
    }

    @XmlTransient
    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (camionCodigo != null ? camionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.camionCodigo == null && other.camionCodigo != null) || (this.camionCodigo != null && !this.camionCodigo.equals(other.camionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Camion[ camionCodigo=" + camionCodigo + " ]";
    }
    
}
