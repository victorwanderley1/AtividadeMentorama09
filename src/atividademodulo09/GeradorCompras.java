/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividademodulo09;

import java.util.List;

/**
 *
 * @author Victor Wanderley
 */
public class GeradorCompras {
    public void gerar(List<Cliente> listaDeClientes, int repeticoes){
        for(int i = 0; i < repeticoes; i++){
            listaDeClientes.forEach(cliente -> cliente.fazerCompra(Math.random()*10000));
        }
    }
}
