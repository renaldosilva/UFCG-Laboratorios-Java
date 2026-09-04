package entidades;

import java.util.Arrays;
import java.util.Locale;

/**
 * Representação de uma disciplina do curso de Ciência da Computação (UFCG).
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nome;

    /**
     * Horas de estudo da disciplina.
     */
    private int horasEstudo;

    /**
     * Notas da disciplina. Toda disciplina possui N notas no intervalo de 0.0 a 10.0.
     */
    private double[] notas;

    /**
     * Pesos das notas da disciplina para cálculo de média ponderada.
     * Se não informado, todas as notas terão peso 1 (média aritmética).
     */
    private int[] pesoNotas;

    /**
     * Constroi uma disciplina a partir do seu nome.
     * Por padrão, a disciplina tem 4 notas.
     *
     * @param nome o nome da disciplina.
     */
    public Disciplina(String nome) {
        this(nome, 4);
    }

    /**
     * Constroi uma disciplina a partir do seu nome e quantidade de notas.
     *
     * @param nome o nome da disciplina.
     * @param quantidadeNotas a quantidade de notas da disciplina.
     */
    public Disciplina(String nome, int quantidadeNotas) {
        this(nome, quantidadeNotas, null);
    }

    /**
     * Constrói uma disciplina a partir do seu nome, quantidade de notas e o peso de cada nota.
     *
     * @param nome o nome da disciplina.
     * @param quantidadeNotas a quantidade de notas da disciplina.
     * @param pesoNotas o array com os pesos de cada nota (pode ser null).
     * @throws IllegalArgumentException caso o nome seja nulo/vazio, a quantidade de notas for inválida,
     *                                  ou, caso os pesos sejam informados, a quantidade de pesos for diferente
     *                                  da quantidade de notas, ou houver algum peso menor ou igual a zero.
     */
    public Disciplina(String nome, int quantidadeNotas, int[] pesoNotas) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da disciplina não pode ser nulo ou vazio.");
        }

        if (quantidadeNotas <= 0) {
            throw new IllegalArgumentException("A quantidade de notas não pode ser menor ou igual a 0.");
        }

        if (pesoNotas == null) {
            this.pesoNotas = new int[quantidadeNotas];
            for (int i = 0; i < quantidadeNotas; i++) {
                this.pesoNotas[i] = 1;
            }
        } else {
            if (pesoNotas.length != quantidadeNotas) {
                throw new IllegalArgumentException("A quantidade de pesos deve ser exatamente igual à quantidade de notas.");
            }
            for (int peso : pesoNotas) {
                if (peso <= 0) {
                    throw new IllegalArgumentException("O peso de cada nota deve ser maior que zero.");
                }
            }
            this.pesoNotas = pesoNotas;
        }

        this.nome = nome;
        this.horasEstudo = 0;
        this.notas = new double[quantidadeNotas];
    }

    /**
     * Cadastra as horas de estudo da disciplina de forma cumulativa.
     *
     * @param horas as horas de estudo da disciplina.
     */
    public void cadastraHoras(int horas) {
        if (horas > 0) {
            this.horasEstudo += horas;
        }
    }

    /**
     * Cadastra nota obtida na disciplina. É possível cadastrar N notas diferentes, indo de 1 a N respectivamente.
     * Cada nota vai de 0.0 até 10.0.
     *
     * @param nota a nota correspondente (1, 2, 3, ..., N).
     * @param valorNota o valor da nota (0.0 até 10.0).
     */
    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= this.notas.length) {
            if (valorNota >= 0.0 && valorNota <= 10.0) {
                this.notas[nota - 1] = valorNota;
            }
        }
    }

    /**
     * Verifica se o aluno foi aprovado na disciplina! Para ser aprovado, a média precisa
     * ser maior ou igual a 7.0.
     *
     * @return true se foi aprovado, false caso contrário.
     */
    public boolean aprovado() {
        return this.calculaMedia() >= 7.0;
    }

    /**
     * Método auxiliar para calcular a média do aluno na disciplina.
     * Sempre utiliza a lógica de média ponderada (usando peso 1 para média aritmética padrão).
     *
     * @return a média da disciplina.
     */
    private double calculaMedia() {
        double media = 0;
        int totalPeso = 0;

        for (int i = 0; i < this.pesoNotas.length; i++) {
            totalPeso += this.pesoNotas[i];
            media += this.notas[i] * this.pesoNotas[i];
        }

        return media / totalPeso;
    }

    /**
     * Retorna a String que representa a disciplina. A representação segue o seguinte formato,
     * "NomeDaDisciplina HorasDeEstudo Média [nota1, nota2, ..., notaN]".
     *
     * @return a representação em String de uma disciplina.
     */
    public String toString() {
        return this.nome + " " + this.horasEstudo + " " + String.format(Locale.US, "%.1f", this.calculaMedia()) +
                " " + Arrays.toString(this.notas);
    }
}