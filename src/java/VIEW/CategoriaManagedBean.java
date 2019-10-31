/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entidades.TbCategoria;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import sessao.TbCategoriaFacade;

/**
 *
 * @author Maxuel
 */
@Named(value = "categoriaManagedBean")
@ManagedBean
@SessionScoped
public class CategoriaManagedBean {

    @EJB
    private TbCategoriaFacade tbCategoriaFacade;
    private TbCategoria categoria;
    
    private ListDataModel categorias;

    public ListDataModel getCategorias() {
        return categorias;
    }

    public void setCategorias(ListDataModel categorias) {
        this.categorias = categorias;
    }
    
    private void retornarC(){
        categorias = new ListDataModel(tbCategoriaFacade.retornarTodos());
    }
    public void retornar(){
        this.retornarC();
    }

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
        return "listarCategoria";
    }
    public String excluir(){
        this.tbCategoriaFacade.remove(categoria);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Excluido com Sucesso", "Mensagem"));
        return "listarCategoria";
    }
    public String atualiazar(){
        this.tbCategoriaFacade.edit(categoria);
        FacesContext context = FacesContext.getCurrentInstance();
    
        context.addMessage(null, new FacesMessage("Atualizado com Sucesso", "Mensagem"));
        return "listarCategoria";
    }
    
    public String montarPaginaInserir(){
        return "/Categoria/InserirCategoria";
    }
    public String montarPaginaExcluir(){
        categoria = (TbCategoria)categorias.getRowData();
        return "/Categoria/ExcluirCategoria";
    }
    public String montarPaginaAtualizar(){
        categoria = (TbCategoria)categorias.getRowData();
        return "/Categoria/AtualizarCategoria";
    }
    public String montarPaginaListar(){
        return "/Categoria/listarCategoria";
    }
    public String montarPaginaInicial(){
        return "/";
    }
    public CategoriaManagedBean() {
    }
    
}
