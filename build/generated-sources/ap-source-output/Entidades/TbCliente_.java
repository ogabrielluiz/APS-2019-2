package Entidades;

import Entidades.TbAluga;
import Entidades.TbFuncionarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-13T12:47:50")
@StaticMetamodel(TbCliente.class)
public class TbCliente_ { 

    public static volatile SingularAttribute<TbCliente, String> emailCliente;
    public static volatile SingularAttribute<TbCliente, String> nmCliente;
    public static volatile SingularAttribute<TbCliente, String> cpfCliente;
    public static volatile SingularAttribute<TbCliente, Integer> idCliente;
    public static volatile SingularAttribute<TbCliente, String> endCliente;
    public static volatile CollectionAttribute<TbCliente, TbAluga> tbAlugaCollection;
    public static volatile SingularAttribute<TbCliente, Date> datnascCliente;
    public static volatile SingularAttribute<TbCliente, String> brCliente;
    public static volatile SingularAttribute<TbCliente, String> nrCliente;
    public static volatile SingularAttribute<TbCliente, TbFuncionarios> idFuncionario;

}