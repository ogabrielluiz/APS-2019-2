/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Entidades.TbCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Otávio
 */
@Stateless
public class TbClienteFacade extends AbstractFacade<TbCliente> {

    @PersistenceContext(unitName = "APSLocadoraJSFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbClienteFacade() {
        super(TbCliente.class);
    }
    
    public TbCliente buscaclientenome(String nome){
    return getEntityManager().find(TbCliente.class, nome);
    }
    
    public TbCliente buscaclientecpf(String cpf){
    return getEntityManager().find(TbCliente.class, cpf);
    }
    
    public TbCliente buscaclienteend(String endereco){
    return getEntityManager().find(TbCliente.class, endereco);
    }
    
    public TbCliente buscaclientefone(String fone){
    return getEntityManager().find(TbCliente.class, fone);
    }
}
