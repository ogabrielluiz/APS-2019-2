/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import entidades.TbCliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maxuel
 */
@Stateless
public class TbClienteFacade extends AbstractFacade<TbCliente> {

    @PersistenceContext(unitName = "TestandoApsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbClienteFacade() {
        super(TbCliente.class);
    }
    
    public List<TbCliente> recuperarTodos(){
        return em.createQuery("select c from TbCliente as c").getResultList();
    }
    
}
