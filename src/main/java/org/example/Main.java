package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
                FilaPedidos fila = new FilaPedidos();

                int opcao;

                do {
                    System.out.println("\n===== GESTAO DE PEDIDOS E-COMMERCE =====");
                    System.out.println("1 - Adicionar pedido");
                    System.out.println("2 - Buscar pedido");
                    System.out.println("3 - Remover pedido");
                    System.out.println("4 - Listar pedidos");
                    System.out.println("0 - Sair");
                    System.out.print("Escolha uma opcao: ");

                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.print("Numero do pedido: ");
                            int numero = entrada.nextInt();
                            entrada.nextLine();

                            System.out.print("Nome do cliente: ");
                            String cliente = entrada.nextLine();

                            System.out.print("Nome do produto: ");
                            String produto = entrada.nextLine();

                            System.out.print("Valor do pedido: R$ ");
                            double valor = entrada.nextDouble();

                            fila.adicionar(numero, cliente, produto, valor);
                            break;

                        case 2:
                            System.out.print("Digite o numero do pedido: ");
                            int busca = entrada.nextInt();
                            fila.buscar(busca);
                            break;

                        case 3:
                            fila.remover();
                            break;

                        case 4:
                            fila.listar();
                            break;

                        case 0:
                            System.out.println("Sistema encerrado!");
                            break;

                        default:
                            System.out.println("Opcao invalida!");
                    }

                } while (opcao != 0);

                entrada.close();
            }
        }

