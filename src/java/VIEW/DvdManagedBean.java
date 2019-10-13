/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Entidades.TbDvd;
import Sessao.TbDvdFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Otávio
 */
@Named(value = "dvdManagedBean")
@ManagedBean
@RequestScoped
public class DvdManagedBean {

    @EJB
    private TbDvd dvd;
    private TbDvdFacade dvdFacade;

    public TbDvd getDvd() {
        
        if(dvd == null){
        dvd = new TbDvd();
        }
        return dvd;
    }

    public void setDvd(TbDvd dvd) {
        this.dvd = dvd;
    }
    
    public String inserir(){
    this.dvdFacade.create(dvd);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Salvo com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String alterar(){
    this.dvdFacade.edit(dvd);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Alterado com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String exclui(){
    this.dvdFacade.remove(dvd);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Removido com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    
    public TbDvd buscaId(int id){
    this.dvdFacade.find(id);
    return dvd;
    }
    
    public TbDvd buscaNome(String nome){
    this.dvdFacade.buscaDvdNome(nome);
    return dvd;
    }
    
    public TbDvd buscaAno(String ano){
    this.dvdFacade.buscaDvdAno(ano);
    return dvd;
    }
    
    public TbDvd buscaDisponibilidade(String Disponibilidade){
    this.dvdFacade.buscaDvdDisp(Disponibilidade);
    return dvd;
    }
    
    
    public DvdManagedBean() {
    }
    
}
