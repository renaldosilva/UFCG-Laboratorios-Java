package entidades;

/**
 * Representação de uma conta de laboratório do curso de Ciência da Computação (UFCG).
 */
public class ContaLaboratorio {

    /**
     * Nome do laboratório.
     */
    private String nome;

    /**
     * Espaço de armazenamento ocupado no laboratório, medido em megabytes.
     */
    private int espacoOcupado;

    /**
     * Cota de espaço disponível no laboratório, medido em megabytes.
     */
    private int espacoLimite;

    /**
     * Constroi um laboratório a partir do seu nome. O espaço limite padrão é de 2000 megabytes.
     *
     * @param nome o nome do laboratório.
     * @throws IllegalArgumentException caso o nome do laboratório seja nulo ou vazio.
     */
    public ContaLaboratorio(String nome) {
        this(nome, 2000);
    }

    /**
     * Constroi um laboratório a partir do seu nome e da sua cota de espaço limite.
     *
     * @param nome o nome do laboratório.
     * @param espacoLimite a cota de espaço limite medida em megabytes.
     * @throws IllegalArgumentException caso o nome do laboratório seja nulo ou vazio,
     *                                  ou se o espaço limite for menor que zero.
     */
    public ContaLaboratorio(String nome, int espacoLimite) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do laboratório não pode ser nulo ou vazio.");
        }

        if (espacoLimite < 0) {
            throw new IllegalArgumentException("O espaço limite do laboratório não pode ser menor que zero megabytes.");
        }

        this.nome = nome;
        this.espacoOcupado = 0;
        this.espacoLimite = espacoLimite;
    }

    /**
     * Consome espaço de armazenamento na cota do laboratório.
     *
     * @param mbytes o espaço que será consumido da cota de armazenamento em megabytes.
     */
    public void consomeEspaco(int mbytes) {
        if (mbytes > 0) {
            this.espacoOcupado += mbytes;
        }
    }

    /**
     * Libera espaço de armazenamento na cota do laboratório.
     * O espaço ocupado nunca será menor que zero.
     *
     * @param mbytes o espaço que será liberado da cota de armazenamento em megabytes.
     */
    public void liberaEspaco(int mbytes) {
        if (mbytes > 0) {
            this.espacoOcupado -= mbytes;

            if (this.espacoOcupado < 0) {
                this.espacoOcupado = 0;
            }
        }
    }

    /**
     * Retorna a informação que indica se a cota de armazenamento foi excedida.
     *
     * @return true se a cota de armazenamento foi ultrapassada, false caso contrário.
     */
    public boolean atingiuCota() {
        return this.espacoOcupado >= this.espacoLimite;
    }

    /**
     * Retorna a String que representa o laboratório. A representação segue o
     * formato "nome espacoOcupado/espacoLimite".
     *
     * @return a representação em String de um laboratório.
     */
    public String toString() {
        return this.nome + " " + this.espacoOcupado + "/" + this.espacoLimite;
    }
}