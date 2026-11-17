import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria catalogo = new ArvoreBinaria();
        PilhaHistorico historico = new PilhaHistorico();
        FilaPedidos filaPedidos = new FilaPedidos();

        int opcao;

        do {
            System.out.println("\n===== E-COMMERCE E LOGISTICA =====");
            System.out.println("1 - Navegar no Site (Historico - Pilha)");
            System.out.println("2 - Gerenciar Catalogo de Produtos (Arvore)");
            System.out.println("3 - Gerenciar Pedidos de Logistica (Fila)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    menuNavegacao(sc, historico);
                    break;
                case 2:
                    menuCatalogo(sc, catalogo);
                    break;
                case 3:
                    menuLogistica(sc, filaPedidos);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void menuNavegacao(Scanner sc, PilhaHistorico historico) {
        int opcao;
        do {
            System.out.println("\n--- NAVEGACAO DO USUARIO (PILHA) ---");
            System.out.println("1 - Acessar nova pagina");
            System.out.println("2 - Ver pagina atual");
            System.out.println("3 - Voltar pagina (Pop)");
            System.out.println("4 - Exibir historico completo");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da pagina/produto: ");
                    String pagina = sc.nextLine();
                    historico.push(pagina);
                    System.out.println("-> Pagina acessada!");
                    break;
                case 2:
                    String atual = historico.peek();
                    System.out.println(atual != null ? "Pagina atual: " + atual : "Historico vazio.");
                    break;
                case 3:
                    String removida = historico.pop();
                    System.out.println(removida != null ? "Voltou da pagina: " + removida : "Nenhuma pagina para voltar.");
                    break;
                case 4:
                    System.out.println("\nHistorico completo:");
                    historico.exibirHistorico();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void menuCatalogo(Scanner sc, ArvoreBinaria catalogo) {
        int opcao;
        do {
            System.out.println("\n--- CATALOGO DE PRODUTOS (ARVORE) ---");
            System.out.println("1 - Inserir produto");
            System.out.println("2 - Buscar produto por codigo");
            System.out.println("3 - Listar produtos (Em Ordem)");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Codigo do produto: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: R$ ");
                    double preco = sc.nextDouble();
                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();
                    sc.nextLine(); // Limpeza crucial após nextDouble/nextInt misturados

                    catalogo.inserir(new Produto(codigo, nome, preco, estoque));
                    System.out.println("-> Produto inserido na Arvore!");
                    break;
                case 2:
                    System.out.print("Codigo para buscar: ");
                    int codBusca = sc.nextInt();
                    sc.nextLine();
                    No resultado = catalogo.buscar(codBusca);
                    System.out.println(resultado != null ? "Encontrado: " + resultado.produto : "Nao encontrado!");
                    break;
                case 3:
                    System.out.println("\nCatalogo (Em Ordem):");
                    catalogo.emOrdem();
                    break;
                case 4:
                    System.out.print("Codigo para remover: ");
                    int codRemover = sc.nextInt();
                    sc.nextLine();
                    if (catalogo.remover(codRemover)) {
                        System.out.println("-> Produto removido!");
                    } else {
                        System.out.println("-> Produto nao encontrado.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void menuLogistica(Scanner sc, FilaPedidos fila) {
        int opcao;
        do {
            System.out.println("\n--- GESTAO DE LOGISTICA (FILA) ---");
            System.out.println("1 - Adicionar novo pedido");
            System.out.println("2 - Buscar pedido");
            System.out.println("3 - Despachar proximo pedido");
            System.out.println("4 - Listar pedidos na fila");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Numero do pedido: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Nome do produto: ");
                    String prod = sc.nextLine();
                    System.out.print("Valor: R$ ");
                    double val = sc.nextDouble();
                    sc.nextLine();

                    fila.adicionar(num, cliente, prod, val);
                    System.out.println("-> Pedido enfileirado!");
                    break;
                case 2:
                    System.out.print("Numero do pedido para buscar: ");
                    int numBusca = sc.nextInt();
                    sc.nextLine();
                    fila.buscar(numBusca);
                    break;
                case 3:
                    fila.remover();
                    break;
                case 4:
                    fila.listar();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }
}