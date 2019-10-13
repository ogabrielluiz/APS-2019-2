/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Otávio
 */
@Entity
@Table(name = "tb_funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionarios.findAll", query = "SELECT t FROM TbFuncionarios t")
    , @NamedQuery(name = "TbFuncionarios.findByIdFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "TbFuncionarios.findByNmFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.nmFuncionario = :nmFuncionario")
    , @NamedQuery(name = "TbFuncionarios.findBySalFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.salFuncionario = :salFuncionario")
    , @NamedQuery(name = "TbFuncionarios.findByEndFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.endFuncionario = :endFuncionario")
    , @NamedQuery(name = "TbFuncionarios.findByCpfFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.cpfFuncionario = :cpfFuncionario")
    , @NamedQuery(name = "TbFuncionarios.findByRuaFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.ruaFuncionario = :ruaFuncionario")
    , @NamedQuery(name = "TbFuncionarios.findByNrFuncionario", query = "SELECT t FROM TbFuncionarios t WHERE t.nrFuncionario = :nrFuncionario")})
public class TbFuncionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Size(max = 60)
    @Column(name = "nm_funcionario")
    private String nmFuncionario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sal_funcionario")
    private BigDecimal salFuncionario;
    @Size(max = 60)
    @Column(name = "end_funcionario")
    private String endFuncionario;
    @Size(max = 60)
    @Column(name = "cpf_funcionario")
    private String cpfFuncionario;
    @Size(max = 60)
    @Column(name = "rua_funcionario")
    private String ruaFuncionario;
    @Size(max = 60)
    @Column(name = "nr_funcionario")
    private String nrFuncionario;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<TbDvd> tbDvdCollection;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<TbCliente> tbClienteCollection;

    public TbFuncionarios() {
    }

    public TbFuncionarios(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNmFuncionario() {
        return nmFuncionario;
    }

    public void setNmFuncionario(String nmFuncionario) {
        this.nmFuncionario = nmFuncionario;
    }

    public BigDecimal getSalFuncionario() {
        return salFuncionario;
    }

    public void setSalFuncionario(BigDecimal salFuncionario) {
        this.salFuncionario = salFuncionario;
    }

    public String getEndFuncionario() {
        return endFuncionario;
    }

    public void setEndFuncionario(String endFuncionario) {
        this.endFuncionario = endFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getRuaFuncionario() {
        return ruaFuncionario;
    }

    public void setRuaFuncionario(String ruaFuncionario) {
        this.ruaFuncionario = ruaFuncionario;
    }

    public String getNrFuncionario() {
        return nrFuncionario;
    }

    public void setNrFuncionario(String nrFuncionario) {
        this.nrFuncionario = nrFuncionario;
    }

    @XmlTransient
    public Collection<TbDvd> getTbDvdCollection() {
        return tbDvdCollection;
    }

    public void setTbDvdCollection(Collection<TbDvd> tbDvdCollection) {
        this.tbDvdCollection = tbDvdCollection;
    }

    @XmlTransient
    public Collection<TbCliente> getTbClienteCollection() {
        return tbClienteCollection;
    }

    public void setTbClienteCollection(Collection<TbCliente> tbClienteCollection) {
        this.tbClienteCollection = tbClienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFuncionarios)) {
            return false;
        }
        TbFuncionarios other = (TbFuncionarios) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TbFuncionarios[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
