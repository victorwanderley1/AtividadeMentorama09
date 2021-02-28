package atividademodulo09;

import java.util.Comparator;

/**
 *
 * @author Victor Wanderley
 */
public class OrdemValorCompras implements Comparator<Cliente>{

    @Override
    public int compare(Cliente o1, Cliente o2) {
        if(o2.totalCompras() > o1.totalCompras()){
            return -1;
        }else if (o2.totalCompras() == o1.totalCompras()){
            return 0;
        }else{
            return 1;
        }
    }
    
}
