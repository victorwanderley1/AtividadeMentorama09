package atividademodulo09;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Victor Wanderley
 */
public class Menu implements GeradorCompras{
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
    
    private void menuRelatorio(){
        System.out.println("--- Relatórios de Compras ---"
                + "\n Escolha qual relatório deseja visualizar:"
                + "\n 1) Clientes Por Ordem Alfabética"
                + "\n 2) Clientes Por Valor Total de Compras"
                + "\n 3) Clientes Por Quantidade de Compras"
                + "\n 4) Relatório Geral");
        int escolha = entradaTeclado.nextInt();
        switch (escolha){
            case 1:
                relatorioClienteOrdemAlfabetica();
                break;
            case 2:
                relatorioClienteOrdemValorCompras();
                break;
            case 3:
                relatorioClienteOrdemQtdCompras();
                break;
            case 4:
                relatorioGeralLoja();
                break;
            default:
                System.out.println("Opção inválida!\nTente Novamente!\n");
                break;
        }
    }
    
    private void relatorioClienteOrdemAlfabetica(){
        System.out.println("Lista de cliente por ordem alfabética:"
                + "\n"+loja.imprimirClientes()
                + "\n");
    }
    
    private void relatorioClienteOrdemValorCompras(){
        System.out.println("Lista de cliente por ordem de valor de compras:"
                + "\n"+loja.imprimirClientesValorCompras()
                + "\n");
    }
    
    private void relatorioClienteOrdemQtdCompras(){
        System.out.println("Lista de cliente por ordem de quantidade de compras:"
                + "\n"+loja.imprimirClientesQtdCompras()
                + "\n");
    }
    
    private void relatorioGeralLoja(){
        List<Cliente> clientes = List.copyOf(loja.getListaDeClientes());
        int qtdCompras = 0;
        qtdCompras = clientes.stream()
                .map(cliente -> cliente.getCompras().size())
                .reduce(qtdCompras, (acumulador, item) -> acumulador+item);
        
        double valorTotalDeCompras = 0;
        valorTotalDeCompras = clientes.stream()
                .map(cliente -> cliente.totalCompras())
                .reduce(valorTotalDeCompras, (acumulador, item) -> acumulador+item);
        
        double mediaCompras = valorTotalDeCompras/qtdCompras;
        
        Cliente clienteMaiorValorCompras = clientes.stream().max(new OrdemValorCompras()).get();
        Cliente clienteMenorValorCompras = clientes.stream().min(new OrdemValorCompras()).get();
        System.out.println("\n-------------Relatório geral-------------\n"
                + "Quantidade de compras dos clientes:      "+qtdCompras+"\n"
                + "Valor total de compras:               R$ "+String.format("%.2f", valorTotalDeCompras)+"\n"
                + "Média de compras dos clientes:        R$ "+String.format("%.2f",mediaCompras)+"\n"
                + "\n\n"
                + "O cliente que mais comprou: "+clienteMaiorValorCompras.getNome()+"\n"
                + "Com o total de "+clienteMaiorValorCompras.getCompras().size()+" compras.\n"
                + "E o valor total de R$ "+String.format("%.2f", clienteMaiorValorCompras.totalCompras())+"\n"
                + "\n"
                + "O cliente que menos comprou: "+clienteMenorValorCompras.getNome()+"\n"
                + "Com o total de "+clienteMenorValorCompras.getCompras().size()+" compras.\n"
                + "E o valor total de R$ "+String.format("%.2f", clienteMenorValorCompras.totalCompras())+"\n"
                + "\n");
    }
    
    
    
    private void escolhaMenu(int escolha){
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
        }else System.out.println("Cliente já cadastrado!");
    }

    private void menuRealizarCompra() {
        System.out.println("Qual cliente fará a compra: ");
        System.out.println(loja.imprimirNomeClientes());
        entradaTeclado.nextLine();
        String escolhaNomeCliente = entradaTeclado.nextLine();
        for (int i = 0; i<loja.getListaDeClientes().size(); i++){
            if(loja.getListaDeClientes().get(i).getNome().equalsIgnoreCase(escolhaNomeCliente)){
                System.out.println("Qual o Valor da Compra: ");
                double valorCompra = entradaTeclado.nextDouble();
                loja.getListaDeClientes().get(i).fazerCompra(valorCompra);
                System.out.println("Compra Realizada!\n");
                break;
            }else System.out.println("Cliente não cadastrado!");
        }
    }
}
