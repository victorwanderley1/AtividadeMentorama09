package atividademodulo09;

import java.util.Comparator;

/**
 * A classe ordena os clientes pela quantidade de compras.
 * @author Victor Wanderley
 */
public class QtdComprasCliente implements Comparator<Cliente>{

    @Override
    public int compare(Cliente o1, Cliente o2) {
        if(o1.getCompras().size() < o2.getCompras().size()) return -1;
        else if(o1.getCompras().size() == o2.getCompras().size()) return 0;
        else return 1;
    }
    
}
