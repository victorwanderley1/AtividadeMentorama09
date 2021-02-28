package atividademodulo09;
 /**
 * Atividade Mentorama Java do Zero
 * Módulo 9
 * Requisitos:
 * 1) Criar 10 clientes.
 * 2) Qual foi o cliente que fez mais compras?
 * 3) Qual foi o cliente que fez menos compras?
 * 4) Qual a média de compras dos clientes?
 * 
 * Resposta implementada dentro do relatório geral da loja.
 *
 * @author Victor Wanderley
 */
public class Principal {
    
    
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        String[] nomes = {"Victor","Vanessa","Max","Lucas","Aline","Bruno","Laura","Liriel","William","Caio"};
        menu.loja.adicionarCliente(nomes);
        menu.randomCompras(menu.loja.getListaDeClientes(), 5, 10000);
        menu.menuPrincipal();
   }
}