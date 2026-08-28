package entidades;

import java.util.ArrayList;

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
     * A descrição dos lanches que foram consumidos na cantina.
     */
    private ArrayList<String> detalhes;

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
        this.detalhes = new ArrayList<>();
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
     * Cadastra um lanche feito na cantina e a sua descrição. Somente os detalhes dos últimos
     * 5 lanches são armazenados.
     *
     * @param quantidadeItens a quantidade de itens que foram consumidos.
     * @param valor o valor total em centavos do lanche.
     * @param detalhes a descrição do lanche.
     */
    public void cadastraLanche(int quantidadeItens, int valor, String detalhes) {
        this.cadastraLanche(quantidadeItens, valor);
        this.detalhes.add(detalhes);

        if (this.detalhes.size() > 5) {
            this.detalhes.removeFirst();
        }
    }

    /**
     * Retorna uma string com os últimos 5 detalhes dos lanches feitos na cantina, um em cada linha.
     *
     * @return a descrição dos últimos 5 lanches feitos.
     */
    public String listarDetalhes() {
        StringBuilder detalhes = new StringBuilder();
        for (String detalhe : this.detalhes) {
            detalhes.append(detalhe).append("\n");
        }
        return detalhes.toString().trim();
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