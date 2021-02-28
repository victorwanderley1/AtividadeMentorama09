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

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }
    
    public void adicionarCliente(String nomeCliente){
        this.listaDeClientes.add(new Cliente(nomeCliente.toUpperCase()));
        Collections.sort(this.listaDeClientes);
    }
    
    public void adicionarCliente(String[] nome){
        for(String nomeCliente: nome){
            this.listaDeClientes.add(new Cliente(nomeCliente.toUpperCase()));
        }
        Collections.sort(this.listaDeClientes);
    }
    
    public Cliente clienteComMaiorCompra(){
        return this.listaDeClientes.stream().max(new OrdemValorCompras()).get();
    }
    
    public Cliente clienteComMenorCompra(){
        return this.listaDeClientes.stream().min(new OrdemValorCompras()).get();
    }
    public String imprimirClientes(){
        return this.getListaDeClientes().toString()
                .replace(", ", "")
                .replace("[", "")
                .replace("]","");
    }
    
    public String imprimirClientesValorCompras(){
        List<Cliente> clientes = new ArrayList();
        clientes.addAll(this.getListaDeClientes());
        clientes.sort(new OrdemValorCompras());
        return clientes.toString()
                .replace(", ", "")
                .replace("[", "")
                .replace("]","");
    }
    
    public String imprimirClientesQtdCompras(){
        List<Cliente> clientes = new ArrayList();
        clientes.addAll(this.getListaDeClientes());
        clientes.sort(new QtdComprasCliente());
        return clientes.toString()
                .replace(", ", "")
                .replace("[", "")
                .replace("]","");
    }
    
    public String imprimirNomeClientes(){
        String nomes = "";
        nomes = this.listaDeClientes.stream().map(cliente -> cliente.getNome()).reduce(nomes, (acumulador, item) -> acumulador.concat("\n"+item));
        return nomes;
    }
}
