/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.TbAluga;
import entidades.TbAlugaPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maxuel
 */
@Stateless
public class TbAlugaFacade extends AbstractFacade<TbAluga> {

    @PersistenceContext(unitName = "TestandoApsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbAlugaFacade() {
        super(TbAluga.class);
    }
    
    public List<TbAluga> recuperarTodos(){
        return em.createQuery("select a from TbAluga as a").getResultList();
    }
    
}
