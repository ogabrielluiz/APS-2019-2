/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbDvd;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessao.TbDvdFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "dvdManagedBean")
@ManagedBean
@RequestScoped
public class DvdManagedBean {

    @EJB
    private TbDvdFacade tbDvdFacade;
    private TbDvd dvd;

    public TbDvd getDvd() {
        if(dvd==null)
        {
            dvd = new TbDvd();
        }
        return dvd;
    }

    public void setDvd(TbDvd dvd) {
        this.dvd = dvd;
    }
    
    public String salvar(){
        this.tbDvdFacade.create(dvd);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Salvo com Sucesso", "Mensagem"));
        return null;
    }
    public String excluir(){
        this.tbDvdFacade.remove(dvd);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return null;
    }
    public String atualiazar(){
        this.tbDvdFacade.edit(dvd);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return null;
    }
    
    public String montarPaginaInserir(){
        return "/Dvd/InserirDvd";
    }
    public String montarPaginaExcluir(){
        return "/Dvd/ExcluirDvd";
    }
    public String montarPaginaAtualizar(){
        return "/Dvd/AtualizarDvd";
    }
    public String montarPaginaListar(){
        //Ainda precisa ser feita
        return null;
    }
    public DvdManagedBean() {
    }
    
}
