package atividademodulo09;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Wanderley
 */
public class Cliente implements ComprasCliente, Comparable<Cliente>{
    private String nome;
    List<Double> compras = new ArrayList();

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getCompras() {
        return compras;
    }

    public void setCompras(List<Double> compras) {
        this.compras = compras;
    }
    
    /**
     * Função recebe valor da compra e efetua a compra adicionando na
     * lista dos valores das compras feitas pelo cliente.
     * @param valorCompra
     */
    public void fazerCompra(double valorCompra){
        this.compras.add(valorCompra);
    }
    
    /**
     * A função obtem a lista dos valores das compras feitas pelo cliente
     * e retorna o valor total das compras.
     * @return
     */
    @Override
    public double totalCompras() {
        double valorTotal = 0;
        valorTotal = this.getCompras().stream().map(valor -> valor).reduce(valorTotal,(valor, acumulador) -> acumulador+valor);
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + "}\n";
    }

//    Ordenará as instâncias de Cliente por ordem alfabética.
    @Override
    public int compareTo(Cliente o) {
        return this.getNome().compareTo(o.getNome());
    }
    
}
