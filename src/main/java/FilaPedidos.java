public class FilaPedidos {
    private Pedido inicio;
    private Pedido fim;

    public void adicionar(int numero, String cliente, String produto, double valor) {
        Pedido novo = new Pedido(numero, cliente, produto, valor);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }

        System.out.println("Pedido adicionado com sucesso!");
    }

    public void buscar(int numero) {
        Pedido atual = inicio;

        while (atual != null) {
            if (atual.numero == numero) {
                System.out.println("\nPedido encontrado!");
                mostrarPedido(atual);
                return;
            }
            atual = atual.proximo;
        }

        System.out.println("Pedido nao encontrado!");
    }

    public void remover() {
        if (inicio == null) {
            System.out.println("A fila esta vazia!");
            return;
        }

        System.out.println("Pedido removido:");
        mostrarPedido(inicio);

        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }
    }

    public void listar() {
        if (inicio == null) {
            System.out.println("Nenhum pedido na fila!");
            return;
        }

        Pedido atual = inicio;

        System.out.println("\n===== PEDIDOS NA FILA =====");

        while (atual != null) {
            mostrarPedido(atual);
            atual = atual.proximo;
        }
    }

    private void mostrarPedido(Pedido pedido) {
        System.out.println("-------------------------");
        System.out.println("Numero: " + pedido.numero);
        System.out.println("Cliente: " + pedido.cliente);
        System.out.println("Produto: " + pedido.produto);
        System.out.println("Valor: R$ " + pedido.valor);
        System.out.println("-------------------------");
    }
}
