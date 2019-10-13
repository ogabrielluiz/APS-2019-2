/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Entidades.TbCliente;
import Sessao.TbClienteFacade;
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
@Named(value = "newJSFManagedBean")
@ManagedBean
@RequestScoped
public class ClienteManagedBean {

    @EJB
    private TbClienteFacade clienteFacade;
    private TbCliente cliente;

    public TbCliente getCliente() {
        if(cliente == null){
        cliente = new TbCliente();
        }
        return cliente;
    }

    public void setCliente(TbCliente cliente) {
        this.cliente = cliente;
    }
    
    public String inserir(){
    this.clienteFacade.create(cliente);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Salvo com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String alterar(){
    this.clienteFacade.edit(cliente);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Alterado com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String exclui(){
    this.clienteFacade.remove(cliente);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Removido com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public TbCliente buscaId( int id){
    this.clienteFacade.find(id);
    
    return cliente;
    }
    
    public TbCliente buscaNome( String nome){
    this.clienteFacade.buscaclientenome(nome);
    
    return cliente;
    }
    
    public TbCliente buscaCpf( String cpf){
    this.clienteFacade.buscaclientecpf(cpf);
    
    return cliente;
    }
    
    public TbCliente buscaEndereco( String end){
    this.clienteFacade.buscaclienteend(end);
    
    return cliente;
    }
    
    public TbCliente buscaFone( String fone){
    this.clienteFacade.buscaclientefone(fone);
    
    return cliente;
    }
    
    
    
    public ClienteManagedBean() {
    }
    
}
