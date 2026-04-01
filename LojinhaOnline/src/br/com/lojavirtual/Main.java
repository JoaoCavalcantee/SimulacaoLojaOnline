package br.com.lojavirtual;

import br.com.lojavirtual.model.*;
import br.com.lojavirtual.service.LojaService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //cria a instacia da lojaservice, ela q contem o "backend" do sistema
        LojaService lojaService = new LojaService();

        //chama o metodo de selecionar cliente aleatoriamente
        Cliente cliente = lojaService.buscarCliente();

        //cria um pedido com null, pq o usuario é obrigado a "criar" ele manualmente lá na
        //opção 2 do switch
        Pedido pedido = null;
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n=== LOJINHA ONLINE ===");
            System.out.println("=Bem-vindo(a) "+ cliente.getNome()+"!" );
            System.out.println("1 - Ver produtos");
            System.out.println("2 - Criar pedido");
            System.out.println("3 - Adicionar item ao pedido");
            System.out.println("4 - Ver o valor do pedido");
            System.out.println("5 - Finalizar compra");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- PRODUTOS ---");
                    for (Produto p : lojaService.listarProdutos()) {
                        System.out.println(p.getId() + " - " + p.getNome() + " | R$" + p.getPreco());
                    }
                    break;

                case 2:
                    pedido = lojaService.criarPedido(cliente);
                    System.out.println("Pedido criado com sucesso!");
                    break;

                case 3:
                    if (pedido == null) {
                        System.out.println("Crie um pedido primeiro!");
                        break;
                    }

                    System.out.print("Digite o ID do produto: ");
                    int idProduto = sc.nextInt();

                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();

                    //chama a função q verifica se o produto existe mesmo
                    Produto produto = lojaService.buscarProduto(idProduto);

                    if (produto != null) {
                        lojaService.adicionarItem(pedido, produto, qtd);
                        System.out.println("Item adicionado!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    if (pedido == null) {
                        System.out.println("Nenhum pedido criado!");
                    } else {
                        System.out.println("Total: R$ " + pedido.calcularTotal());
                    }
                    break;

                case 5:
                    if (pedido == null) {
                        System.out.println("Nenhum pedido criado!");
                    } else {
                        lojaService.finalizarPedido(pedido);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}