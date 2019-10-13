/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Entidades.TbAluga;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.ParameterExpression;

/**
 *
 * @author Otávio
 */
@Stateless
public class TbAlugaFacade extends AbstractFacade<TbAluga> {

    @PersistenceContext(unitName = "APSLocadoraJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbAlugaFacade() {
        super(TbAluga.class);
    }
    
    public TbAluga buscaAlugaIdDvD(int idDvd){
    return getEntityManager().find(TbAluga.class, idDvd);
    }
    
    public TbAluga buscaAlugaIdCliente(int idCliente){
    return getEntityManager().find(TbAluga.class, idCliente);
    }
    
    public TbAluga buscaAlugaDtaAluga(String dtaAluga){
    return getEntityManager().find(TbAluga.class, dtaAluga);
    }
    
    public TbAluga buscaAlugaDtaEntregue(String dtaEntregue){
    return getEntityManager().find(TbAluga.class, dtaEntregue);
    }
    
    public TbAluga buscaEntregue (String entregue){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<TbAluga> rt = cq.from(TbAluga.class);
        ParameterExpression<String> entreg = getEntityManager().getCriteriaBuilder().parameter(String.class);
        cq.select(rt).where(getEntityManager().getCriteriaBuilder().equal(rt.get("entregue"), entreg),
                getEntityManager().getCriteriaBuilder().isFalse(rt.get("Ativo")));
        Query q = getEntityManager().createQuery(cq);
        q.setParameter(entreg, entregue);
        List<TbAluga> resultado = q.getResultList();
        TbAluga dvd = resultado.get(0);
        return dvd; 
        
    }
}
