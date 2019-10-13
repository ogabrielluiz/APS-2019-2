/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Entidades.TbCategoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Otávio
 */
@Stateless
public class TbCategoriaFacade extends AbstractFacade<TbCategoria> {

    @PersistenceContext(unitName = "APSLocadoraJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbCategoriaFacade() {
        super(TbCategoria.class);
    }
    
    public TbCategoria buscaCategoria(String categoria){
    return getEntityManager().find(TbCategoria.class, categoria);
    }
}
