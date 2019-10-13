/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Entidades.TbFuncionarios;
import Sessao.TbFuncionariosFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@Named(value = "funcionariosManagedBean")
@ManagedBean
@RequestScoped
public class FuncionariosManagedBean {

    @EJB
    private TbFuncionariosFacade funcfacade;
    private TbFuncionarios func;

    public TbFuncionarios getFunc() {
        if(func == null){
        func = new TbFuncionarios();
        }
        return func;
    }

    public void setFunc(TbFuncionarios func) {
        this.func = func;
    }
    
    public String inserir(){
    this.funcfacade.create(func);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Salvo com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String alterar(){
    this.funcfacade.edit(func);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Alterado com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String exclui(){
    this.funcfacade.remove(func);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Removido com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public TbFuncionarios buscaId(int id){
    this.funcfacade.find(id);
    
    return func;
    }
    
    public TbFuncionarios buscaNome(String nome){
    this.funcfacade.buscafuncnome(nome);
    
    return func;
    }
    
    public TbFuncionarios buscaCpf(String cpf){
    this.funcfacade.buscafuncdpf(cpf);
    
    return func;
    }
    
    
    public FuncionariosManagedBean() {
    }
    
}
