/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Entidades.TbDvd;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author Otávio
 */
@Stateless
public class TbDvdFacade extends AbstractFacade<TbDvd> {

    @PersistenceContext(unitName = "APSLocadoraJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbDvdFacade() {
        super(TbDvd.class);
    }
    
    public TbDvd buscaDvdNome(String nome){
        return getEntityManager().find(TbDvd.class, nome);
    }
    
    public TbDvd buscaDvdAno(String anoDvd){
        return getEntityManager().find(TbDvd.class, anoDvd);
    }
    
    public TbDvd buscaDvdDisp(String disponibilidade){
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<TbDvd> rt = cq.from(TbDvd.class);
        ParameterExpression<String> disp = getEntityManager().getCriteriaBuilder().parameter(String.class);
        cq.select(rt).where(getEntityManager().getCriteriaBuilder().equal(rt.get("disponibilidade"), disp),
                getEntityManager().getCriteriaBuilder().isFalse(rt.get("Ativo")));
        Query q = getEntityManager().createQuery(cq);
        q.setParameter(disp, disponibilidade);
        List<TbDvd> resultado = q.getResultList();
        TbDvd dvd = resultado.get(0);
        return dvd; 
        
    }
    
}
