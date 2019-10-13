/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Otávio
 */
@Embeddable
public class TbAlugaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dvd")
    private int idDvd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;

    public TbAlugaPK() {
    }

    public TbAlugaPK(int idDvd, int idCliente) {
        this.idDvd = idDvd;
        this.idCliente = idCliente;
    }

    public int getIdDvd() {
        return idDvd;
    }

    public void setIdDvd(int idDvd) {
        this.idDvd = idDvd;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDvd;
        hash += (int) idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAlugaPK)) {
            return false;
        }
        TbAlugaPK other = (TbAlugaPK) object;
        if (this.idDvd != other.idDvd) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TbAlugaPK[ idDvd=" + idDvd + ", idCliente=" + idCliente + " ]";
    }
    
}
