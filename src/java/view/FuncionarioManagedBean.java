/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbFuncionarios;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import sessao.TbFuncionariosFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "funcionarioManagedBean")
@ManagedBean
@RequestScoped
public class FuncionarioManagedBean {

    @EJB
    private TbFuncionariosFacade tbFuncionariosFacade;
    private TbFuncionarios funcionarios;

    public TbFuncionarios getFuncionarios() {
        if(funcionarios==null)
        {
            funcionarios = new TbFuncionarios();
        }
        return funcionarios;
    }

    public void setFuncionarios(TbFuncionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    public String salvar(){
        this.tbFuncionariosFacade.create(funcionarios);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Salvo com Sucesso", "Mensagem"));
        return null;
    }
    public String excluir(){
        this.tbFuncionariosFacade.remove(funcionarios);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return null;
    }
    public String atualizar(){
        this.tbFuncionariosFacade.edit(funcionarios);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return null;
    }
    public String montarPaginaInserir(){
        return "/Funcionarios/InserirFuncionario";
    }
    public String montarPaginaExcluir(){
        return "/Funcionarios/ExcluirFuncionario";
    }
    public String montarPaginaAtualizar(){
        return "/Funcionarios/AtualizarFuncionario";
    }
    public String montarPaginaListar(){
        //Ainda precisa ser feita
        return null;
    }
    public FuncionarioManagedBean() {
    }
    
}
