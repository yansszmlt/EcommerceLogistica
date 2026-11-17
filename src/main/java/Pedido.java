public class Pedido {
    int numero;
    String cliente;
    String produto;
    double valor;
    Pedido proximo;

    public Pedido(int numero, String cliente, String produto, double valor) {
        this.numero = numero;
        this.cliente = cliente;
        this.produto = produto;
        this.valor = valor;
        this.proximo = null;
    }
}
