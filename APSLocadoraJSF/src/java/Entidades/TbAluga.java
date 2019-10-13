/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Otávio
 */
@Entity
@Table(name = "tb_aluga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAluga.findAll", query = "SELECT t FROM TbAluga t")
    , @NamedQuery(name = "TbAluga.findByIdDvd", query = "SELECT t FROM TbAluga t WHERE t.tbAlugaPK.idDvd = :idDvd")
    , @NamedQuery(name = "TbAluga.findByIdCliente", query = "SELECT t FROM TbAluga t WHERE t.tbAlugaPK.idCliente = :idCliente")
    , @NamedQuery(name = "TbAluga.findByDtAluga", query = "SELECT t FROM TbAluga t WHERE t.dtAluga = :dtAluga")
    , @NamedQuery(name = "TbAluga.findByDtParaentrega", query = "SELECT t FROM TbAluga t WHERE t.dtParaentrega = :dtParaentrega")
    , @NamedQuery(name = "TbAluga.findByEntregue", query = "SELECT t FROM TbAluga t WHERE t.entregue = :entregue")})
public class TbAluga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbAlugaPK tbAlugaPK;
    @Column(name = "dt_aluga")
    @Temporal(TemporalType.DATE)
    private Date dtAluga;
    @Column(name = "dt_paraentrega")
    @Temporal(TemporalType.DATE)
    private Date dtParaentrega;
    @Column(name = "entregue")
    private Boolean entregue;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbCliente tbCliente;
    @JoinColumn(name = "id_dvd", referencedColumnName = "id_dvd", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbDvd tbDvd;

    public TbAluga() {
    }

    public TbAluga(TbAlugaPK tbAlugaPK) {
        this.tbAlugaPK = tbAlugaPK;
    }

    public TbAluga(int idDvd, int idCliente) {
        this.tbAlugaPK = new TbAlugaPK(idDvd, idCliente);
    }

    public TbAlugaPK getTbAlugaPK() {
        return tbAlugaPK;
    }

    public void setTbAlugaPK(TbAlugaPK tbAlugaPK) {
        this.tbAlugaPK = tbAlugaPK;
    }

    public Date getDtAluga() {
        return dtAluga;
    }

    public void setDtAluga(Date dtAluga) {
        this.dtAluga = dtAluga;
    }

    public Date getDtParaentrega() {
        return dtParaentrega;
    }

    public void setDtParaentrega(Date dtParaentrega) {
        this.dtParaentrega = dtParaentrega;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public TbCliente getTbCliente() {
        return tbCliente;
    }

    public void setTbCliente(TbCliente tbCliente) {
        this.tbCliente = tbCliente;
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
        hash += (tbAlugaPK != null ? tbAlugaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAluga)) {
            return false;
        }
        TbAluga other = (TbAluga) object;
        if ((this.tbAlugaPK == null && other.tbAlugaPK != null) || (this.tbAlugaPK != null && !this.tbAlugaPK.equals(other.tbAlugaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TbAluga[ tbAlugaPK=" + tbAlugaPK + " ]";
    }
    
}
