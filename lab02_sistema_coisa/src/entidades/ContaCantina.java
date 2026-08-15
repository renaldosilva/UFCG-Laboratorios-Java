package entidades;

/**
 * Representação de uma conta de cantina (UFCG).
 */
public class ContaCantina {

    /**
     * O nome da cantina.
     */
    private String nome;

    /**
     * O valor em centavos que representa o débito na cantina.
     */
    private int debito;

    /**
     * O valor total em centavos que representa todo o gasto na cantina.
     */
    private int totalGastos;

    /**
     * A quantidade total de itens que já foram consumidos na cantina.
     */
    private int totalItensConsumidos;

    /**
     * Constroi uma cantina a partir do seu nome.
     *
     * @param nome o nome da cantina.
     */
    public ContaCantina(String nome) {
        this.nome = nome;
        this.debito = 0;
        this.totalGastos = 0;
        this.totalItensConsumidos = 0;
    }

    /**
     * Cadastra um lanche feito na cantina.
     *
     * @param quantidadeItens a quantidade de itens que foram consumidos.
     * @param valor o valor total em centavos do lanche.
     */
    public void cadastraLanche(int quantidadeItens, int valor) {
        if (quantidadeItens > 0 && valor > 0) {
            this.totalItensConsumidos += quantidadeItens;
            this.totalGastos += valor;
            this.debito += valor;
        }
    }

    /**
     * Realiza o pagamento do valor em débito na cantina. O valor só será aceito se for maior que zero
     * e menor ou igual ao valor do débito.
     *
     * @param valor o valor em centavos que será descontado do débito.
     */
    public void pagaConta(int valor) {
        if (valor > 0 && valor <= this.debito) {
            this.debito -= valor;
        }
    }

    /**
     * Retorna o valor em centavos que está em débito na cantina.
     *
     * @return o valor em centavos que falta pagar.
     */
    public int getFaltaPagar() {
        return this.debito;
    }

    /**
     * Retorna a String que representa uma cantina. A representação segue o formato,
     * "NomeDaCantina totalDeItensConsumidos TotalGasto"
     *
     * @return a representação em String da cantina.
     */
    public String toString() {
        return this.nome + " " + this.totalItensConsumidos + " " + this.totalGastos;
    }
}