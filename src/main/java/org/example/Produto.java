package org.example;

public class Produto {

        private int codigo;
        private String nome;
        private double preco;
        private int quantidadeEstoque;

        // Construtor
        public Produto(int codigo, String nome, double preco, int quantidadeEstoque) {
            this.codigo = codigo;
            this.nome = nome;
            this.preco = preco;
            this.quantidadeEstoque = quantidadeEstoque;
        }

        // Getters
        public int getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public int getQuantidadeEstoque() {
            return quantidadeEstoque;
        }

        // Setters
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public void setQuantidadeEstoque(int quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
        }

        // Exibição do produto
        @Override
        public String toString() {
            return "Código: " + codigo +
                    " | Nome: " + nome +
                    " | Preço: R$ " + preco +
                    " | Estoque: " + quantidadeEstoque;
        }
    }





