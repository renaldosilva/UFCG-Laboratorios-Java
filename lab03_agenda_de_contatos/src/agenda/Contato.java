package agenda;


import java.util.Objects;

/**
 * Representa um contato da agenda, com nome, sobrenome e até 3 telefones.
 * Um dos telefones pode ser marcado como prioritário e o outro como WhatsApp.
 * Dois contatos são considerados iguais se tiverem o mesmo nome e sobrenome.
 */
public class Contato {

    /** A quantidade máxima de telefones que um contato possui.*/
    private static final int QUANTIDADE_TELEFONES = 3;

    /** Valor usado quando o telefone prioritário ou do WhatsApp ainda não foram definidos.*/
    private static final int NAO_DEFINIDO = 0;

    private String nome;
    private String sobrenome;
    private String[] telefones;

    /** Posição (1 a {@value #QUANTIDADE_TELEFONES}) do telefone prioritário, ou NAO_DEFINIDO se ainda não houver.*/
    private int telefonePrioritario;

    /** Posição (1 a {@value #QUANTIDADE_TELEFONES}) do telefone de WhatsApp, ou NAO_DEFINIDO se ainda não houver.*/
    private int telefoneWhatsapp;

    /**
     * Cria um contato sem telefones.
     *
     * @param nome o nome do contato (não pode ser nulo, vazio ou só espaços)
     * @param sobrenome o sobrenome do contato (não pode ser nulo, vazio ou só espaços)
     * @throws NullPointerException se o nome ou o sobrenome forem nulos
     * @throws IllegalArgumentException se o nome ou sobrenome forem vazios, ou só espaços
     */
    public Contato(String nome, String sobrenome) throws IllegalArgumentException, NullPointerException {
        this.nome = validaTexto(nome, "nome");
        this.sobrenome = validaTexto(sobrenome, "sobrenome");
        this.telefones = new String[QUANTIDADE_TELEFONES];
        this.telefonePrioritario = NAO_DEFINIDO;
        this.telefoneWhatsapp = NAO_DEFINIDO;
    }

    /**
     * Cadastra um telefone em uma das posições do contato, substituindo o anterior, se houver.
     *
     * @param telefone o telefone a ser cadastrado (não pode ser nulo, vazio ou só espaços)
     * @param posicao a posição do telefone, de 1 a {@value #QUANTIDADE_TELEFONES}
     * @throws NullPointerException se o telefone for nulo
     * @throws IllegalArgumentException se o telefone for vazio ou a posição for inválida
     */
    public void cadastraTelefone(String telefone, int posicao) {
        validaPosicaoTelefone(posicao);
        this.telefones[posicao - 1] = validaTexto(telefone, "telefone");
    }

    /**
     * Define qual dos telefones é o prioritário.
     *
     * @param posicao a posição do telefone, de 1 a {@value #QUANTIDADE_TELEFONES}
     * @throws IllegalArgumentException se a posição for inválida
     */
    public void setTelefonePrioritario(int posicao) {
        validaPosicaoTelefone(posicao);
        this.telefonePrioritario = posicao;
    }

    /**
     * Define qual dos telefones é o do WhatsApp.
     *
     * @param posicao a posição do telefone, de 1 a {@value #QUANTIDADE_TELEFONES}
     * @throws IllegalArgumentException se a posição for inválida
     */
    public void setTelefoneWhatsapp(int posicao) {
        validaPosicaoTelefone(posicao);
        this.telefoneWhatsapp = posicao;
    }

    /**
     * Retorna o nome completo do contato (nome seguido de sobrenome).
     *
     * @return o nome completo
     */
    public String nomeCompleto() {
        return this.nome + " " +  this.sobrenome;
    }

    /**
     * Dois contatos são iguais quando possuem o mesmo nome e sobrenome,
     * independentemente dos telefones cadastrados.
     *
     * @param o objeto a ser comparado com este contato
     * @return true se o objeto for um Contato com o mesmo nome e sobrenome;
     *         false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if(!(o instanceof Contato)) {
            return false;
        }
        Contato outro = (Contato) o;
        return outro.nome.equals(this.nome) && outro.sobrenome.equals(this.sobrenome);
    }

    /**
     * Gera o código hash a partir do nome e do sobrenome, de forma consistente com equals.
     *
     * @return código hash do contato
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.sobrenome);
    }

    private static String validaTexto(String texto, String campo) {
        if (texto == null) {
            throw new NullPointerException("O " + campo + " do contato não pode ser nulo.");
        }

        if (texto.trim().isEmpty()) {
            throw new IllegalArgumentException("O " + campo + " do contato não pode ser vazio.");
        }
        return texto.trim();
    }

    private static void validaPosicaoTelefone(int posicao) {
        if(posicao < 1 || posicao > QUANTIDADE_TELEFONES) {
            throw new IllegalArgumentException("A posição do telefone de estar entre 1 e " + QUANTIDADE_TELEFONES);
        }
    }
}
