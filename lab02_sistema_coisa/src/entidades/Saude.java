package entidades;

/**
 * Representação da saúde de um aluno(a) do curso de Ciência da Computação (UFCG).
 */
public class Saude {

    /**
     * Saúde mental do aluno(a). Pode assumir dois valores: boa ou fraca.
     */
    private String saudeMental;

    /**
     * Saúde física do aluno(a). Pode assumir dois valores: boa ou fraca.
     */
    private String saudeFisica;

    /**
     * Constroi a saúde de um aluno(a). Por padrão a saúde mental e física começam com o valor boa.
     */
    public Saude() {
        this.saudeMental = "boa";
        this.saudeFisica = "boa";
    }

    /**
     * Define a saúde mental do aluno(a). É possível definir somente dois valores, boa ou fraca.
     *
     * @param valor o valor que representa a saúde mental do aluno(a).
     */
    public void defineSaudeMental(String valor) {
        if (this.validaIndicadorSaude(valor)) {
            this.saudeMental = valor;
        }
    }

    /**
     * Define a saúde física do aluno(a). É possível definir somente dois valores, boa ou fraca.
     *
     * @param valor o valor que representa a saúde física do aluno(a).
     */
    public void defineSaudeFisica(String valor) {
        if (this.validaIndicadorSaude(valor)) {
            this.saudeFisica = valor;
        }
    }

    /**
     * Método privado para verificar os valores atribuídos à saúde mental e física do aluno(a).
     * O valor pode assumir dois estados, boa ou fraca.
     *
     * @param valor o valor da saúde do aluno(a).
     * @return true caso o valor seja válido, false caso contrário.
     */
    private boolean validaIndicadorSaude(String valor) {
        return valor.equals("boa") || valor.equals("fraca");
    }

    /**
     * Retorna o estado geral de saúde do aluno(a) com base na sua saúde mental e física.
     *
     * Para saúde mental boa e saúde física boa, o retorno é "boa".
     * Para saúde mental fraca e saúde física fraca, o retorno é "fraca".
     * Para quando apenas um dos indicadores de saúde for fraco, o retorno é "ok".
     *
     * @return o status geral de saúde do aluno(a).
     */
    public String getStatusGeral() {
        if (this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
            return "boa";
        } else if (this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
            return "fraca";
        } else {
            return "ok";
        }
    }
}