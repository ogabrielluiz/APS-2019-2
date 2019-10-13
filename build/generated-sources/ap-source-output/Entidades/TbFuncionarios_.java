package Entidades;

import Entidades.TbCliente;
import Entidades.TbDvd;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-13T12:47:50")
@StaticMetamodel(TbFuncionarios.class)
public class TbFuncionarios_ { 

    public static volatile SingularAttribute<TbFuncionarios, String> ruaFuncionario;
    public static volatile CollectionAttribute<TbFuncionarios, TbDvd> tbDvdCollection;
    public static volatile CollectionAttribute<TbFuncionarios, TbCliente> tbClienteCollection;
    public static volatile SingularAttribute<TbFuncionarios, String> nmFuncionario;
    public static volatile SingularAttribute<TbFuncionarios, String> nrFuncionario;
    public static volatile SingularAttribute<TbFuncionarios, String> endFuncionario;
    public static volatile SingularAttribute<TbFuncionarios, String> cpfFuncionario;
    public static volatile SingularAttribute<TbFuncionarios, Integer> idFuncionario;
    public static volatile SingularAttribute<TbFuncionarios, BigDecimal> salFuncionario;

}