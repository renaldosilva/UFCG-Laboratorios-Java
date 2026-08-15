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
     * Pesos das notas da disciplina para cálculo de média ponderada. Pode ser nulo.
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
     * Constroi uma disciplina a partir do seu nome, quantidade de notas e peso das notas.
     *
     * @param nome o nome da disciplina.
     * @param quantidadeNotas a quantidade de notas da disciplina.
     * @param pesoNotas o array com os pesos de cada nota.
     */
    public Disciplina(String nome, int quantidadeNotas, int[] pesoNotas) {
        this.nome = nome;
        this.horasEstudo = 0;
        this.notas = new double[quantidadeNotas];
        this.pesoNotas = pesoNotas;
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
     * Método auxiliar privado para calcular a média do aluno na disciplina.
     *
     * @return a média ponderada caso os pesos das notas tenham sido informados
     * ou a média aritmética, caso contrário.
     */
    private double calculaMedia() {
        if (this.pesoNotas != null) {
            double media = 0;
            int totalPeso = 0;
            for (int i = 0; i < this.pesoNotas.length; i++) {
                totalPeso += this.pesoNotas[i];
                media += this.notas[i] * this.pesoNotas[i];
            }
            return media / totalPeso;
        } else {
            double soma = 0;
            for (double nota : this.notas) {
                soma += nota;
            }
            return soma / this.notas.length;
        }
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