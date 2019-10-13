/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Entidades.TbAluga;
import Sessao.TbAlugaFacade;
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
@Named(value = "alugaManagedBean")
@ManagedBean
@RequestScoped
public class AlugaManagedBean {

    @EJB
    private TbAluga aluga;
    private TbAlugaFacade alugaFacade;

    public TbAluga getAluga() {
        if(aluga == null){
        aluga = new TbAluga();
        }
        return aluga;
    }

    public void setAluga(TbAluga aluga) {
        this.aluga = aluga;
    }
    
    public String inserir(){
    this.alugaFacade.create(aluga);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Salvo com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String alterar(){
    this.alugaFacade.edit(aluga);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Alterado com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String exclui(){
    this.alugaFacade.remove(aluga);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Removido com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    
    public TbAluga buscaId(int id){
    this.alugaFacade.find(id);
    
    return aluga;
    }
    
    public TbAluga buscaIdDvd(int idDvd){
    this.alugaFacade.buscaAlugaIdDvD(idDvd);
    
    return aluga;
    }
    
    
    public TbAluga buscaIdCliente(int idCliente){
    this.alugaFacade.buscaAlugaIdCliente(idCliente);
    
    return aluga;
    }
    
    public TbAluga buscaDtaEntregue(String Dta){
    this.alugaFacade.buscaAlugaDtaEntregue(Dta);
    
    return aluga;
    }
    
    public TbAluga buscaAluga(String Dta){
    this.alugaFacade.buscaAlugaDtaAluga(Dta);
    
    return aluga;
    }
    
    public TbAluga buscaEntregue(String entregue){
    this.alugaFacade.buscaEntregue(entregue);
    
    return aluga;
    }
    
    public AlugaManagedBean() {
    }
    
}
