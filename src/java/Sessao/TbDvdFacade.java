/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.TbDvd;
import entidades.TbFuncionarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maxuel
 */
@Stateless
public class TbDvdFacade extends AbstractFacade<TbDvd> {

    @PersistenceContext(unitName = "TestandoApsPU")
    private EntityManager em;
    private TbFuncionarios tb;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbDvdFacade() {
        super(TbDvd.class);
    }
    
    public List<TbDvd> recuperarTodos(){
        return em.createQuery("select c from TbDvd as c").getResultList();
    }
    
}
