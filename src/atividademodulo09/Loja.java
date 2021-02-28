package atividademodulo09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Victor Wanderley
 */
public class Loja{
    private List<Cliente> listaDeClientes = new ArrayList();

    protected List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }
    
    /**
     *  Adciona uma String como Cliente.
     * @param nomeCliente
     */
    protected void adicionarCliente(String nomeCliente){
        this.listaDeClientes.add(new Cliente(nomeCliente.toUpperCase()));
        Collections.sort(this.listaDeClientes);
    }
    
    /**
     *  Adiciona um array de Strings como Cliente.
     * @param nome
     */
    protected void adicionarCliente(String[] nome){
        for(String nomeCliente: nome){
            this.listaDeClientes.add(new Cliente(nomeCliente.toUpperCase()));
        }
        Collections.sort(this.listaDeClientes);
    }
    
    private Cliente clienteComMaiorCompra(){
        return this.listaDeClientes.stream().max(new OrdemValorCompras()).get();
    }
    
    private Cliente clienteComMenorCompra(){
        return this.listaDeClientes.stream().min(new OrdemValorCompras()).get();
    }

    /**
     *  Retorna formatado o toString dos Clientes.
     * @return
     */
    protected String imprimirClientes(){
        return this.getListaDeClientes().toString()
                .replace(", ", "")
                .replace("[", "")
                .replace("]","");
    }
    
    /**
     *  Retorna formatado e por ordem decrescente de valores o toString
     * dos Clientes.
     * @return
     */
    protected String imprimirClientesValorCompras(){
        List<Cliente> clientes = new ArrayList();
        clientes.addAll(this.getListaDeClientes());
        clientes.sort(new OrdemValorCompras());
        return clientes.toString()
                .replace(", ", "")
                .replace("[", "")
                .replace("]","");
    }
    
    /**
     *  Retorna formatado e por ordem crescente da quantidade de compras o
     * o toString dos Clientes.
     * @return
     */
    protected String imprimirClientesQtdCompras(){
        List<Cliente> clientes = new ArrayList();
        clientes.addAll(this.getListaDeClientes());
        clientes.sort(new QtdComprasCliente());
        return clientes.toString()
                .replace(", ", "")
                .replace("[", "")
                .replace("]","");
    }
    
    /**
     * Retorna a lista dos nomes dos clientes concatenados em ordem alfabética
     *em uma única String.
     * @return
     */
    protected String imprimirNomeClientes(){
        String nomes = "";
        Collections.sort(listaDeClientes);
        nomes = this.listaDeClientes.stream().map(cliente -> cliente.getNome()).reduce(nomes, (acumulador, item) -> acumulador.concat("\n"+item));
        return nomes;
    }
}
