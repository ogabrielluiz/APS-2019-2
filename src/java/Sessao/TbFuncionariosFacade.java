/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Entidades.TbFuncionarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Otávio
 */
@Stateless
public class TbFuncionariosFacade extends AbstractFacade<TbFuncionarios> {

    @PersistenceContext(unitName = "APSLocadoraJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbFuncionariosFacade() {
        super(TbFuncionarios.class);
    }
    
    public TbFuncionarios buscafuncnome(String nome){
    return getEntityManager().find(TbFuncionarios.class, nome);
    }
    
    public TbFuncionarios buscafuncdpf(String cpf){
    return getEntityManager().find(TbFuncionarios.class, cpf);
    }
    
}
