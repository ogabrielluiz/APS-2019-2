/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbAluga;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import sessao.TbAlugaFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "alugaManagedBean")
@ManagedBean
@SessionScoped
public class AlugaManagedBean {

    @EJB
    private TbAlugaFacade tbAlugaFacade;

    private TbAluga aluga;
    private ListDataModel alugas;

    public ListDataModel getAlugas() {
        return alugas;
    }

    public void setAlugas(ListDataModel alugas) {
        this.alugas = alugas;
    }
    private void recuperarA(){
        alugas = new ListDataModel(tbAlugaFacade.recuperarTodos());
    }
    public void recuperar(){
        this.recuperarA();
    }

    public TbAluga getAluga() {
        if(aluga==null)
        {
            aluga = new TbAluga();
        }
        return aluga;
    }

    public void setAluga(TbAluga aluga) {
        this.aluga = aluga;
    }
    
    public String salvar(){
        this.tbAlugaFacade.create(aluga);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Salvo com Sucesso", "Mensagem"));
        return null;
    }
    public String excluir(){
        this.tbAlugaFacade.remove(aluga);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return null;
    }
    public String atualiazar(){
        this.tbAlugaFacade.edit(aluga);
        
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return null;
    }
    
    public String montarPaginaInserir(){
        return "/Aluga/InserirAluga";
    }
    public String montarPaginaExcluir(){
        aluga = (TbAluga)alugas.getRowData();
        return "/Aluga/ExcluirAluga";
    }
    public String montarPaginaAtualizar(){
        aluga = (TbAluga)alugas.getRowData();
        return "/Aluga/AtualizarAluga";
    }
    public String montarPaginaListar(){
        return "/Aluga/listarAluga";
    }
    public AlugaManagedBean() {
    }
    
}
