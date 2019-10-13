/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maxuel
 */
@Entity
@Table(name = "tb_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCategoria.findAll", query = "SELECT t FROM TbCategoria t")
    , @NamedQuery(name = "TbCategoria.findByIdDvd", query = "SELECT t FROM TbCategoria t WHERE t.idDvd = :idDvd")
    , @NamedQuery(name = "TbCategoria.findByGeneroCategoria", query = "SELECT t FROM TbCategoria t WHERE t.generoCategoria = :generoCategoria")})
public class TbCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dvd")
    private Integer idDvd;
    @Size(max = 60)
    @Column(name = "genero_categoria")
    private String generoCategoria;
    @JoinColumn(name = "id_dvd", referencedColumnName = "id_dvd", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbDvd tbDvd;

    public TbCategoria() {
    }

    public TbCategoria(Integer idDvd) {
        this.idDvd = idDvd;
    }

    public Integer getIdDvd() {
        return idDvd;
    }

    public void setIdDvd(Integer idDvd) {
        this.idDvd = idDvd;
    }

    public String getGeneroCategoria() {
        return generoCategoria;
    }

    public void setGeneroCategoria(String generoCategoria) {
        this.generoCategoria = generoCategoria;
    }

    public TbDvd getTbDvd() {
        return tbDvd;
    }

    public void setTbDvd(TbDvd tbDvd) {
        this.tbDvd = tbDvd;
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
        if (!(object instanceof TbCategoria)) {
            return false;
        }
        TbCategoria other = (TbCategoria) object;
        if ((this.idDvd == null && other.idDvd != null) || (this.idDvd != null && !this.idDvd.equals(other.idDvd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbCategoria[ idDvd=" + idDvd + " ]";
    }
    
}
