/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbCategoria;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import sessao.TbCategoriaFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "categoriaManagedBean")
@ManagedBean
@RequestScoped
public class CategoriaManagedBean {

    @EJB
    private TbCategoriaFacade tbCategoriaFacade;
    private TbCategoria categoria;

    public TbCategoria getCategoria() {
        if(categoria==null){
            categoria = new TbCategoria();
        }
        return categoria;
    }

    public void setCategoria(TbCategoria categoria) {
        this.categoria = categoria;
    }
    
    public String salvar(){
        this.tbCategoriaFacade.create(categoria);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Salvo com Sucesso", "Mensagem"));
        return null;
    }
    public String excluir(){
        this.tbCategoriaFacade.remove(categoria);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return null;
    }
    public String atualiazar(){
        this.tbCategoriaFacade.edit(categoria);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return null;
    }
    
    public String montarPaginaInserir(){
        return "/Categoria/InserirCategoria";
    }
    public String montarPaginaExcluir(){
        return "/Categoria/ExcluirCategoria";
    }
    public String montarPaginaAtualizar(){
        return "/Categoria/AtualizarCategoria";
    }
    public String montarPaginaListar(){
        //Ainda precisa ser feita
        return null;
    }
    public CategoriaManagedBean() {
    }
    
}
