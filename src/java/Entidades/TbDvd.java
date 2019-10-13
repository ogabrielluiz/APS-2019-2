/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Otávio
 */
@Entity
@Table(name = "tb_dvd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbDvd.findAll", query = "SELECT t FROM TbDvd t")
    , @NamedQuery(name = "TbDvd.findByIdDvd", query = "SELECT t FROM TbDvd t WHERE t.idDvd = :idDvd")
    , @NamedQuery(name = "TbDvd.findByNmDvd", query = "SELECT t FROM TbDvd t WHERE t.nmDvd = :nmDvd")
    , @NamedQuery(name = "TbDvd.findByDispDvd", query = "SELECT t FROM TbDvd t WHERE t.dispDvd = :dispDvd")
    , @NamedQuery(name = "TbDvd.findBySinpDvd", query = "SELECT t FROM TbDvd t WHERE t.sinpDvd = :sinpDvd")
    , @NamedQuery(name = "TbDvd.findByAnoDvd", query = "SELECT t FROM TbDvd t WHERE t.anoDvd = :anoDvd")})
public class TbDvd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dvd")
    private Integer idDvd;
    @Size(max = 60)
    @Column(name = "nm_dvd")
    private String nmDvd;
    @Column(name = "disp_dvd")
    private Boolean dispDvd;
    @Size(max = 255)
    @Column(name = "sinp_dvd")
    private String sinpDvd;
    @Column(name = "ano_dvd")
    @Temporal(TemporalType.DATE)
    private Date anoDvd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbDvd")
    private Collection<TbAluga> tbAlugaCollection;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne
    private TbFuncionarios idFuncionario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbDvd")
    private TbCategoria tbCategoria;

    public TbDvd() {
    }

    public TbDvd(Integer idDvd) {
        this.idDvd = idDvd;
    }

    public Integer getIdDvd() {
        return idDvd;
    }

    public void setIdDvd(Integer idDvd) {
        this.idDvd = idDvd;
    }

    public String getNmDvd() {
        return nmDvd;
    }

    public void setNmDvd(String nmDvd) {
        this.nmDvd = nmDvd;
    }

    public Boolean getDispDvd() {
        return dispDvd;
    }

    public void setDispDvd(Boolean dispDvd) {
        this.dispDvd = dispDvd;
    }

    public String getSinpDvd() {
        return sinpDvd;
    }

    public void setSinpDvd(String sinpDvd) {
        this.sinpDvd = sinpDvd;
    }

    public Date getAnoDvd() {
        return anoDvd;
    }

    public void setAnoDvd(Date anoDvd) {
        this.anoDvd = anoDvd;
    }

    @XmlTransient
    public Collection<TbAluga> getTbAlugaCollection() {
        return tbAlugaCollection;
    }

    public void setTbAlugaCollection(Collection<TbAluga> tbAlugaCollection) {
        this.tbAlugaCollection = tbAlugaCollection;
    }

    public TbFuncionarios getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(TbFuncionarios idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public TbCategoria getTbCategoria() {
        return tbCategoria;
    }

    public void setTbCategoria(TbCategoria tbCategoria) {
        this.tbCategoria = tbCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDvd != null ? idDvd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbDvd)) {
            return false;
        }
        TbDvd other = (TbDvd) object;
        if ((this.idDvd == null && other.idDvd != null) || (this.idDvd != null && !this.idDvd.equals(other.idDvd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TbDvd[ idDvd=" + idDvd + " ]";
    }
    
}
