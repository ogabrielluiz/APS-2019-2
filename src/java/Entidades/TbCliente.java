/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Maxuel
 */
@Entity
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t")
    , @NamedQuery(name = "TbCliente.findByIdCliente", query = "SELECT t FROM TbCliente t WHERE t.idCliente = :idCliente")
    , @NamedQuery(name = "TbCliente.findByDatnascCliente", query = "SELECT t FROM TbCliente t WHERE t.datnascCliente = :datnascCliente")
    , @NamedQuery(name = "TbCliente.findByEmailCliente", query = "SELECT t FROM TbCliente t WHERE t.emailCliente = :emailCliente")
    , @NamedQuery(name = "TbCliente.findByNmCliente", query = "SELECT t FROM TbCliente t WHERE t.nmCliente = :nmCliente")
    , @NamedQuery(name = "TbCliente.findByCpfCliente", query = "SELECT t FROM TbCliente t WHERE t.cpfCliente = :cpfCliente")
    , @NamedQuery(name = "TbCliente.findByEndCliente", query = "SELECT t FROM TbCliente t WHERE t.endCliente = :endCliente")
    , @NamedQuery(name = "TbCliente.findByNrCliente", query = "SELECT t FROM TbCliente t WHERE t.nrCliente = :nrCliente")
    , @NamedQuery(name = "TbCliente.findByBrCliente", query = "SELECT t FROM TbCliente t WHERE t.brCliente = :brCliente")})
public class TbCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "datnasc_cliente")
    @Temporal(TemporalType.DATE)
    private Date datnascCliente;
    @Size(max = 60)
    @Column(name = "email_cliente")
    private String emailCliente;
    @Size(max = 60)
    @Column(name = "nm_cliente")
    private String nmCliente;
    @Size(max = 60)
    @Column(name = "cpf_cliente")
    private String cpfCliente;
    @Size(max = 60)
    @Column(name = "end_cliente")
    private String endCliente;
    @Size(max = 60)
    @Column(name = "nr_cliente")
    private String nrCliente;
    @Size(max = 60)
    @Column(name = "br_cliente")
    private String brCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCliente")
    private Collection<TbAluga> tbAlugaCollection;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne
    private TbFuncionarios idFuncionario;

    public TbCliente() {
    }

    public TbCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDatnascCliente() {
        return datnascCliente;
    }

    public void setDatnascCliente(Date datnascCliente) {
        this.datnascCliente = datnascCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEndCliente() {
        return endCliente;
    }

    public void setEndCliente(String endCliente) {
        this.endCliente = endCliente;
    }

    public String getNrCliente() {
        return nrCliente;
    }

    public void setNrCliente(String nrCliente) {
        this.nrCliente = nrCliente;
    }

    public String getBrCliente() {
        return brCliente;
    }

    public void setBrCliente(String brCliente) {
        this.brCliente = brCliente;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbCliente[ idCliente=" + idCliente + " ]";
    }
    
}
