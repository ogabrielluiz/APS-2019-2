/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.TbFuncionarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maxuel
 */
@Stateless
public class TbFuncionariosFacade extends AbstractFacade<TbFuncionarios> {

    @PersistenceContext(unitName = "TestandoApsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbFuncionariosFacade() {
        super(TbFuncionarios.class);
    }
    
}
