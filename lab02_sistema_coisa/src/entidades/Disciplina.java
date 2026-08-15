package entidades;

import java.util.Arrays;

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
     * Notas da disciplina. Toda disciplina possui 4 notas no intervalo de 0.0 a 10.0.
     */
    private double[] notas;

    /**
     * Constroi uma disciplina a partir do seu nome.
     *
     * @param nome o nome da disciplina.
     */
    public Disciplina(String nome) {
        this.nome = nome;
        this.horasEstudo = 0;
        this.notas = new double[4];
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
     * Cadastra nota obtida na disciplina. É possível cadastrar 4 notas diferentes, indo de 1 a 4 respectivamente.
     * Cada nota vai de 0.0 até 10.0.
     *
     * @param nota a nota correspondente (1, 2, 3 ou 4).
     * @param valorNota o valor da nota (0.0 até 10.0).
     */
    public void cadastraNota(int nota, double valorNota) {
        // Usa length para ser adaptável caso você faça o Bônus 5.1 depois!
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
     * @return a média aritmética das notas.
     */
    private double calculaMedia() {
        double soma = 0;
        for (double nota : this.notas) {
            soma += nota;
        }

        return soma / this.notas.length;
    }

    /**
     * Retorna a String que representa a disciplina. A representação segue o seguinte formato,
     * "NomeDaDisciplina HorasDeEstudo Média [nota1, nota2, nota3, nota4]".
     *
     * @return a representação em String de uma disciplina.
     */
    public String toString() {
        return this.nome + " " + this.horasEstudo + " " + this.calculaMedia() + " " + Arrays.toString(this.notas);
    }
}