package org.example;

public class PilhaHistorico {

        private NoHistorico topo;
        private int tamanho;

        public PilhaHistorico() {
            this.topo = null;
            this.tamanho = 0;
        }

        public boolean isEmpty() {
            return topo == null;
        }

        public int getTamanho() {
            return tamanho;
        }

        public void push(String pagina) {
            NoHistorico novoNo = new NoHistorico(pagina);
            novoNo.setProximo(topo);
            topo = novoNo;
            tamanho++;
        }

        public String pop() {
            if (isEmpty()) {
                return null;
            }
            String paginaRemovida = topo.getPagina();
            topo = topo.getProximo();
            tamanho--;
            return paginaRemovida;
        }

        public String peek() {
            if (isEmpty()) {
                return null;
            }
            return topo.getPagina();
        }

        public void exibirHistorico() {
            if (isEmpty()) {
                System.out.println("Histórico de navegação vazio.");
                return;
            }
            NoHistorico atual = topo;
            while (atual != null) {
                System.out.println(atual.getPagina());
                atual = atual.getProximo();
            }
        }

        public boolean buscar(String pagina) {
            NoHistorico atual = topo;
            while (atual != null) {
                if (atual.getPagina().equalsIgnoreCase(pagina)) {
                    return true;
                }
                atual = atual.getProximo();
            }
            return false;
        }

        public void limpar() {
            topo = null;
            tamanho = 0;
        }
    }


