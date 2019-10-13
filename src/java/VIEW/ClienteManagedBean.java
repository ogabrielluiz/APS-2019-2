/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbCliente;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessao.TbClienteFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "clienteManagedBean")
@ManagedBean
@RequestScoped
public class ClienteManagedBean {

    @EJB
    private TbClienteFacade tbClienteFacade;
    private TbCliente cliente;

    public TbCliente getCliente() {
        if(cliente==null){
            cliente = new TbCliente();
        }
        return cliente;
    }

    public void setCliente(TbCliente cliente) {
        this.cliente = cliente;
    }
    
    public String salvar(){
        this.tbClienteFacade.create(cliente);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Salvo com Sucesso", "Mensagem"));
        return null;
    }
    public String excluir(){
        this.tbClienteFacade.remove(cliente);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return null;
    }
    public String atualiazar(){
        this.tbClienteFacade.edit(cliente);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return null;
    }
    
    public String montarPaginaInserir(){
        return "/Cliente/InserirCliente";
    }
    public String montarPaginaExcluir(){
        return "/Cliente/ExcluirCliente";
    }
    public String montarPaginaAtualizar(){
        return "/Cliente/AtualizarCliente";
    }
    public String montarPaginaListar(){
        //Ainda precisa ser feita
        return null;
    }
    
    public ClienteManagedBean() {
    }
    
}
