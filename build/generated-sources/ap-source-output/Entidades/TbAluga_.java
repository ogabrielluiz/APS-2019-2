package entidades;

import entidades.TbAlugaPK;
import entidades.TbCliente;
import entidades.TbDvd;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-26T17:07:35")
@StaticMetamodel(TbAluga.class)
public class TbAluga_ { 

    public static volatile SingularAttribute<TbAluga, TbDvd> tbDvd;
    public static volatile SingularAttribute<TbAluga, Boolean> entregue;
    public static volatile SingularAttribute<TbAluga, TbCliente> tbCliente;
    public static volatile SingularAttribute<TbAluga, TbAlugaPK> tbAlugaPK;
    public static volatile SingularAttribute<TbAluga, Date> dtAluga;
    public static volatile SingularAttribute<TbAluga, Date> dtParaentrega;

}