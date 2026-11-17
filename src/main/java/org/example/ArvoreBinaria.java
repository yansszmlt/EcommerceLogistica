package org.example;

public class ArvoreBinaria {

        private No raiz;

        // Inserir produto
        public boolean inserir(Produto produto) {

            if (buscar(produto.getCodigo()) != null) {
                return false;
            }

            raiz = inserirRecursivo(raiz, produto);
            return true;
        }

        private No inserirRecursivo(No atual, Produto produto) {

            if (atual == null) {
                return new No(produto);
            }

            if (produto.getCodigo() < atual.produto.getCodigo()) {
                atual.esquerda = inserirRecursivo(atual.esquerda, produto);

            } else if (produto.getCodigo() > atual.produto.getCodigo()) {
                atual.direita = inserirRecursivo(atual.direita, produto);
            }

            return atual;
        }

        // Buscar produto pelo código
        public No buscar(int codigo) {

            No atual = raiz;

            while (atual != null) {

                if (codigo == atual.produto.getCodigo()) {
                    return atual;
                }

                if (codigo < atual.produto.getCodigo()) {
                    atual = atual.esquerda;
                } else {
                    atual = atual.direita;
                }
            }

            return null;
        }

        public boolean remover(int codigo) {
        if (buscar(codigo) == null) {
            return false;
        }

        raiz = removerRecursivo(raiz, codigo);
        return true;
    }

        private No removerRecursivo(No atual, int codigo) {
        if (atual == null) {
            return null;
        }

        if (codigo < atual.produto.getCodigo()) {
            atual.esquerda = removerRecursivo(atual.esquerda, codigo);
        } else if (codigo > atual.produto.getCodigo()) {
            atual.direita = removerRecursivo(atual.direita, codigo);
        } else {
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            if (atual.esquerda == null) {
                return atual.direita;
            }

            if (atual.direita == null) {
                return atual.esquerda;
            }

            No sucessor = encontrarMenor(atual.direita);
            atual.produto = sucessor.produto;

            atual.direita = removerRecursivo(
                    atual.direita,
                    sucessor.produto.getCodigo()
            );
        }

        return atual;
    }

    private No encontrarMenor(No atual) {
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }

        return atual;
    }

    public void emOrdem() {
        percorrerEmOrdem(raiz);
        System.out.println();
    }

    private void percorrerEmOrdem(No atual) {
        if (atual != null) {
            percorrerEmOrdem(atual.esquerda);
            System.out.println(atual.produto);
            percorrerEmOrdem(atual.direita);
        }
    }

    public void preOrdem() {
        percorrerPreOrdem(raiz);
        System.out.println();
    }

    private void percorrerPreOrdem(No atual) {
        if (atual != null) {
            System.out.println(atual.produto);
            percorrerPreOrdem(atual.esquerda);
            percorrerPreOrdem(atual.direita);
        }
    }

    public void posOrdem() {
        percorrerPosOrdem(raiz);
        System.out.println();
    }

    private void percorrerPosOrdem(No atual) {
        if (atual != null) {
            percorrerPosOrdem(atual.esquerda);
            percorrerPosOrdem(atual.direita);
            System.out.println(atual.produto);
        }
    }

}


