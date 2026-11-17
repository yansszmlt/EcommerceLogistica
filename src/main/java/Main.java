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
            sc.nextLine();

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

    private static void menuNavegacao(Scanner scanner, PilhaHistorico historico) {
        int opcao;
        do {
            System.out.println("\n--- NAVEGACAO DO USUARIO ---");
            System.out.println("1 - Acessar nova pagina");
            System.out.println("2 - Ver pagina atual");
            System.out.println("3 - Voltar pagina (Pop)");
            System.out.println("4 - Exibir historico completo");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da pagina/produto visitado: ");
                    String pagina = scanner.nextLine();
                    historico.push(pagina);
                    System.out.println("Acessado com sucesso!");
                    break;
                case 2:
                    String atual = historico.peek();
                    if (atual != null) {
                        System.out.println("Pagina atual: " + atual);
                    } else {
                        System.out.println("Historico vazio.");
                    }
                    break;
                case 3:
                    String removida = historico.pop();
                    if (removida != null) {
                        System.out.println("Saiu da pagina: " + removida);
                    } else {
                        System.out.println("Nenhuma pagina para voltar.");
                    }
                    break;
                case 4:
                    System.out.println("\nHistorico de Navegacao (do mais recente para o mais antigo):");
                    historico.exibirHistorico();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void menuCatalogo(Scanner scanner, ArvoreBinaria catalogo) {
        int opcao;
        do {
            System.out.println("\n--- CATALOGO DE PRODUTOS ---");
            System.out.println("1 - Inserir produto");
            System.out.println("2 - Buscar produto por codigo");
            System.out.println("3 - Listar produtos (Em Ordem)");
            System.out.println("4 - Remover produto");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Codigo do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: R$ ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade em estoque: ");
                    int estoque = scanner.nextInt();

                    catalogo.inserir(new Produto(codigo, nome, preco, estoque));
                    System.out.println("Produto cadastrado no catalogo!");
                    break;
                case 2:
                    System.out.print("Digite o codigo para buscar: ");
                    int codBusca = scanner.nextInt();
                    No resultado = catalogo.buscar(codBusca);
                    if (resultado != null) {
                        System.out.println("Encontrado: " + resultado.produto);
                    } else {
                        System.out.println("Produto nao encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("\nCatalogo ordenado por codigo:");
                    catalogo.emOrdem();
                    break;
                case 4:
                    System.out.print("Digite o codigo do produto para remover: ");
                    int codRemover = scanner.nextInt();
                    if (catalogo.remover(codRemover)) {
                        System.out.println("Produto removido do catalogo!");
                    } else {
                        System.out.println("Nao foi possivel remover: produto inexistente.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void menuLogistica(Scanner scanner, FilaPedidos fila) {
        int opcao;
        do {
            System.out.println("\n--- GESTAO DE PEDIDOS E LOGISTICA ---");
            System.out.println("1 - Adicionar novo pedido");
            System.out.println("2 - Buscar pedido na fila");
            System.out.println("3 - Despachar/Remover proximo pedido");
            System.out.println("4 - Listar todos os pedidos na fila");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Numero do pedido: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Nome do produto: ");
                    String prod = scanner.nextLine();
                    System.out.print("Valor do pedido: R$ ");
                    double val = scanner.nextDouble();

                    fila.adicionar(num, cliente, prod, val);
                    break;
                case 2:
                    System.out.print("Digite o numero do pedido para buscar: ");
                    int numBusca = scanner.nextInt();
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