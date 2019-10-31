/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbCliente;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import sessao.TbClienteFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "clienteManagedBean")
@ManagedBean
@SessionScoped
public class ClienteManagedBean {

    @EJB
    private TbClienteFacade tbClienteFacade;
    private TbCliente cliente;
    
    private ListDataModel clientes;

    public ListDataModel getClientes() {
        return clientes;
    }

    public void setClientes(ListDataModel clientes) {
        this.clientes = clientes;
    }
    
    private void recuperarC(){
        clientes = new ListDataModel(tbClienteFacade.recuperarTodos());
    }
    public void recuperar(){
       this.recuperarC();
    }
    
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
        return "listarCliente";
    }
    public String excluir(){
        this.tbClienteFacade.remove(cliente);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return "listarCliente";
    }
    public String atualiazar(){
        this.tbClienteFacade.edit(cliente);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return "listarCliente";
    }
    
    public String montarPaginaInserir(){
        return "/Cliente/InserirCliente";
    }
    public String montarPaginaExcluir(){
        cliente = (TbCliente)clientes.getRowData();
        return "/Cliente/ExcluirCliente";
    }
    public String montarPaginaAtualizar(){
        cliente = (TbCliente)clientes.getRowData();
        return "/Cliente/AtualizarCliente";
    }
    public String montarPaginaListar(){
        return "/Cliente/listarCliente";
    }
    
    public ClienteManagedBean() {
    }
    
}
