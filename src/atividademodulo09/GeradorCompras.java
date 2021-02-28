/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividademodulo09;

import java.util.List;

/**
 *  A Interface é um randomizador de compras para melhoras a visualização da atividade.
 * @author Victor Wanderley
 */
public interface GeradorCompras {

    /**
     * O método faz uma randomização de compras de uma lista de Clientes de acordo
     *com a quantidade de repetições e o valor máximo passado como parâmetros.
     * @param listaDeClientes
     * @param repeticoes
     * @param valorMaximo
     */
    default void randomCompras(List<Cliente> listaDeClientes, int repeticoes, double valorMaximo){
        for(int i = 0; i < repeticoes; i++){
            listaDeClientes.forEach(cliente -> cliente.fazerCompra(Math.random()*valorMaximo));
        }
    }
}
