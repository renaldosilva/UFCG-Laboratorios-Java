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
     * ‘Emoji’ que representa o último sentimento do aluno.
     * Pode assumir os valores: “:(”, “*_*”, “:o)”,“<(^_^<)”, “¯\_(ツ)_/¯”, ...
     */
    private String emoji;

    /**
     * Constroi a saúde de um aluno(a). Por padrão a saúde mental e física começam com o valor boa e o emoji vazio.
     */
    public Saude() {
        this.saudeMental = "boa";
        this.saudeFisica = "boa";
        this.emoji = "";
    }

    /**
     * Define a saúde mental do aluno(a). É possível definir somente dois valores, boa ou fraca.
     * Sempre que a saúde mental sofrer alteração, o emoji que representa o sentimento geral do aluno
     * é redefinido.
     *
     * @param valor o valor que representa a saúde mental do aluno(a).
     */
    public void defineSaudeMental(String valor) {
        if (this.validaIndicadorSaude(valor)) {
            if (!this.saudeMental.equals(valor)) {
                this.saudeMental = valor;
                this.removeEmoji();
            }
        }
    }

    /**
     * Define a saúde física do aluno(a). É possível definir somente dois valores, boa ou fraca.
     * Sempre que a saúde física sofrer alteração, o emoji que representa o sentimento geral do aluno
     * é redefinido.
     *
     * @param valor o valor que representa a saúde física do aluno(a).
     */
    public void defineSaudeFisica(String valor) {
        if (this.validaIndicadorSaude(valor)) {
            if (!this.saudeFisica.equals(valor)) {
                this.saudeFisica = valor;
                this.removeEmoji();
            }
        }
    }

    /**
     * Define o emoji que representa o sentimento geral do aluno.
     * Pode assumir os valores: “:(”, “*_*”, “:o)”,“<(^_^<)”, “¯\_(ツ)_/¯”, ...
     *
     * @param emoji o emoji que representa o sentimento geral do aluno.
     */
    public void definirEmoji(String emoji) {
        if (emoji != null && !emoji.isEmpty()) {
            this.emoji = emoji;
        }
    }

    /**
     * Remove o emoji que representa o sentimento geral do aluno. O valor passa a ser vazio.
     */
    private void removeEmoji() {
        this.emoji = "";
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
     * Um emoji que representa o sentimento geral do aluno é retornado junto, caso exista.
     *
     * @return o status geral de saúde do aluno(a).
     */
    public String getStatusGeral() {
        String statusGeral = "";

        if (this.saudeMental.equals("boa") && this.saudeFisica.equals("boa")) {
            statusGeral = "boa";
        } else if (this.saudeMental.equals("fraca") && this.saudeFisica.equals("fraca")) {
            statusGeral = "fraca";
        } else {
            statusGeral = "ok";
        }

        if (!this.emoji.isEmpty()) {
            statusGeral = statusGeral + " " + this.emoji;
        }

        return statusGeral;
    }
}