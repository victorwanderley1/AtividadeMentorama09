package atividademodulo09;

import java.util.Scanner;

/**
 *
 * @author Victor Wanderley
 */
public class Menu {
    /**
     * Menu principal
     * Menu Relatório
     * Menu Adicionar Cliente
     */
    Loja loja = new Loja();
    Scanner entradaTeclado = new Scanner(System.in);
    public void menuPrincipal() {
        while(true){
            System.out.println("--- Módulo Loja ---");
            System.out.println("1) Adicionar Cliente"
                    + "\n2) Realizar Compra"
                    + "\n3) Relatórios da Loja");
            int escolha = entradaTeclado.nextInt();
            escolhaMenu(escolha);
        }
    }
    public void menuRelatorio(){
        System.out.println("--- Relatórios de Compras ---"
                + "\n Escolha qual relatório deseja visualizar:"
                + "\n 1) Clientes Por Ordem Alfabética"
                + "\n 2) Clientes Por Valor Total de Compras"
                + "\n 3) Clientes Por Quantidade de Compras"
                + "\n 4) Relatório Geral");
        int escolha = entradaTeclado.nextInt();
        
    }
    public void escolhaMenu(int escolha){
        switch (escolha){
            case 1:
                menuAddCliente();
                break;
            case 2:
                menuRealizarCompra();
                break;
            case 3:
                menuRelatorio();
                break;
            case 4:
                System.out.println(loja.getListaDeClientes().toString().replace(", ", "").replace("[","").replace("]", ""));
                break;
            default:
                System.out.println("Opção Inválida! Tente Novamente.");
                break;
        }
    }

    private void menuAddCliente() {
        System.out.println("\n Nome do Cliente: ");
        entradaTeclado.nextLine();
        String nomeCliente = entradaTeclado.next();
        if(!loja.getListaDeClientes().stream().map(cliente -> cliente.getNome()).anyMatch(nome -> nome.equals(nomeCliente))){
            loja.adicionarCliente(nomeCliente);
            System.out.println("Cliente adicionado com sucesso!");
        }else System.out.println("Cliente já existente!");
    }

    private void menuRealizarCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
