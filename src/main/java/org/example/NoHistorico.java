package org.example;

public class NoHistorico {

        private String pagina;
        private NoHistorico proximo;

        public NoHistorico(String pagina) {
            this.pagina = pagina;
            this.proximo = null;
        }

        public String getPagina() {
            return pagina;
        }

        public void setPagina(String pagina) {
            this.pagina = pagina;
        }

        public NoHistorico getProximo() {
            return proximo;
        }

        public void setProximo(NoHistorico proximo) {
            this.proximo = proximo;
        }
    }



