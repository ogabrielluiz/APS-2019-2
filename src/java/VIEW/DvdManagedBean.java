/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbDvd;

import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import sessao.TbDvdFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "dvdManagedBean")
@ManagedBean
@SessionScoped
public class DvdManagedBean {

    @EJB
    private TbDvdFacade tbDvdFacade;
    private TbDvd dvd;
    
    private ListDataModel dvds;

    public ListDataModel getDvds() {
        return dvds;
    }

    public void setDvds(ListDataModel dvds) {
        this.dvds = dvds;
    }
    private void recuperarD(){
        dvds = new ListDataModel(tbDvdFacade.recuperarTodos());
    }
    public void recuperar(){
        this.recuperarD();
    }
    
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
        return "listarDvd";
    }
    public String excluir(){
        this.tbDvdFacade.remove(dvd);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return "listarDvd";
    }
    public String atualiazar(){
        this.tbDvdFacade.edit(dvd);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return "listarDvd";
    }
    
    public String montarPaginaInserir(){
        return "/Dvd/InserirDvd";
    }
    public String montarPaginaExcluir(){
        dvd = (TbDvd)dvds.getRowData();
        return "/Dvd/ExcluirDvd";
    }
    public String montarPaginaAtualizar(){
        dvd = (TbDvd)dvds.getRowData();
        return "/Dvd/AtualizarDvd";
    }
    public String montarPaginaListar(){
        return "/Dvd/listarDvd";
    }
    public DvdManagedBean() {
    }
    
}
