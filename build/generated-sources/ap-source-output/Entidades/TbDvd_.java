package entidades;

import entidades.TbAluga;
import entidades.TbCategoria;
import entidades.TbFuncionarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-26T17:07:35")
@StaticMetamodel(TbDvd.class)
public class TbDvd_ { 

    public static volatile SingularAttribute<TbDvd, TbCategoria> tbCategoria;
    public static volatile SingularAttribute<TbDvd, Integer> idDvd;
    public static volatile SingularAttribute<TbDvd, String> sinpDvd;
    public static volatile SingularAttribute<TbDvd, String> nmDvd;
    public static volatile SingularAttribute<TbDvd, Boolean> dispDvd;
    public static volatile CollectionAttribute<TbDvd, TbAluga> tbAlugaCollection;
    public static volatile SingularAttribute<TbDvd, Date> anoDvd;
    public static volatile SingularAttribute<TbDvd, TbFuncionarios> idFuncionario;

}