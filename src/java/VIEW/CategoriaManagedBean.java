/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import Entidades.TbCategoria;
import Sessao.TbCategoriaFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Otávio
 */
@Named(value = "categoriaManagedBean")
@ManagedBean
@RequestScoped
public class CategoriaManagedBean {
    
    @EJB
    private TbCategoria categoria;
    
    private TbCategoriaFacade categoriaFacade;

    public TbCategoria getCategoria() {
        if(categoria == null){
        categoria = new TbCategoria();
        }
        return categoria;
    }

    public void setCategoria(TbCategoria categoria) {
        this.categoria = categoria;
    }

   
    public String inserir(){
    this.categoriaFacade.create(categoria);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Salvo com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String alterar(){
    this.categoriaFacade.edit(categoria);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("Alterado com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public String exclui(){
    this.categoriaFacade.remove(categoria);
    
    FacesContext context = FacesContext.getCurrentInstance();
    
    context.addMessage(null, new FacesMessage("removido com sucesso!!!", "Mensagem"));
    
    return null;
    }
    
    public TbCategoria buscaId(int id){
    this.categoriaFacade.find(id);
    
    return categoria;
    }
    
    public TbCategoria buscaCategoria(String categ){
    this.categoriaFacade.buscaCategoria(categ);
    
    return categoria;
    }
    
    public CategoriaManagedBean() {
    }
    
}
