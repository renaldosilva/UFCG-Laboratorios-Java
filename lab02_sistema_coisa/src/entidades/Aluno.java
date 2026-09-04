package entidades;

import java.util.HashMap;

/**
 * Representação de um aluno do curso de Ciência da Computação (UFCG).
 * A classe gerencia as contas de laboratório, disciplinas, cantinas e a saúde do aluno.
 */
public class Aluno {

    /**
     * Nome do aluno.
     */
    private String nome;

    /**
     * Mapa de contas de laboratórios do aluno, onde a chave é o nome do laboratório.
     */
    private HashMap<String, ContaLaboratorio> laboratorios;

    /**
     * Constrói um aluno a partir do seu nome. Inicializa as coleções de laboratórios, disciplinas e cantinas como vazias,
     * e a saúde com os valores padrão (boa).
     *
     * @param nome o nome do aluno.
     * @throws IllegalArgumentException caso o nome do aluno seja nulo ou vazio.
     */
    public Aluno(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do aluno não pode ser nulo ou vazio.");
        }

        this.nome = nome;
        this.laboratorios = new HashMap<>();
    }

    /**
     * Cadastra um novo laboratório para o aluno com a cota de espaço padrão (2000 megabytes).
     * O cadastro só é realizado se o nome for válido e o laboratório ainda não existir.
     *
     * @param nomeLaboratorio o nome do laboratório a ser cadastrado.
     */
    public void cadastraLaboratorio(String nomeLaboratorio) {
        if (this.validaNome(nomeLaboratorio) && !this.laboratorios.containsKey(nomeLaboratorio)) {
            ContaLaboratorio laboratorio = new ContaLaboratorio(nomeLaboratorio);
            this.laboratorios.put(nomeLaboratorio, laboratorio);
        }
    }

    /**
     * Cadastra um novo laboratório para o aluno com uma cota de espaço específica.
     * O cadastro só é realizado se o nome for válido e o laboratório ainda não existir.
     *
     * @param nomeLaboratorio o nome do laboratório a ser cadastrado.
     * @param cota a cota de espaço limite medida em megabytes.
     */
    public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
        if (this.validaNome(nomeLaboratorio) && !this.laboratorios.containsKey(nomeLaboratorio)) {
            ContaLaboratorio laboratorio = new ContaLaboratorio(nomeLaboratorio, cota);
            this.laboratorios.put(nomeLaboratorio, laboratorio);
        }
    }

    /**
     * Consome espaço de armazenamento na cota de um laboratório específico do aluno.
     * A operação só ocorre se o laboratório estiver previamente cadastrado.
     *
     * @param nomeLaboratorio o nome do laboratório.
     * @param mbytes o espaço que será consumido da cota em megabytes.
     */
    public void consomeEspaco(String nomeLaboratorio, int mbytes) {
        if (this.validaNome(nomeLaboratorio) && this.laboratorios.containsKey(nomeLaboratorio)) {
            this.laboratorios.get(nomeLaboratorio).consomeEspaco(mbytes);
        }
    }

    /**
     * Libera espaço de armazenamento na cota de um laboratório específico do aluno.
     * A operação só ocorre se o laboratório estiver previamente cadastrado.
     *
     * @param nomeLaboratorio o nome do laboratório.
     * @param mbytes o espaço que será liberado da cota em megabytes.
     */
    public void liberaEspaco(String nomeLaboratorio, int mbytes) {
        if (this.validaNome(nomeLaboratorio) && this.laboratorios.containsKey(nomeLaboratorio)) {
            this.laboratorios.get(nomeLaboratorio).liberaEspaco(mbytes);
        }
    }

    /**
     * Verifica se a cota de armazenamento de um determinado laboratório foi excedida.
     * Caso o laboratório não exista no cadastro do aluno, retorna falso.
     *
     * @param nomeLaboratorio o nome do laboratório.
     * @return true se a cota de armazenamento foi ultrapassada, false caso contrário.
     */
    public boolean atingiuCota(String nomeLaboratorio) {
        if (this.validaNome(nomeLaboratorio) && this.laboratorios.containsKey(nomeLaboratorio)) {
            return this.laboratorios.get(nomeLaboratorio).atingiuCota();
        }
        return false;
    }

    /**
     * Retorna a String que representa o laboratório cadastrado pelo aluno.
     *
     * @param nomeLaboratorio o nome do laboratório.
     * @return a representação em String do laboratório ou "Laboratório não encontrado" se não existir.
     */
    public String laboratorioToString(String nomeLaboratorio) {
        if (this.validaNome(nomeLaboratorio) && this.laboratorios.containsKey(nomeLaboratorio)) {
            return this.laboratorios.get(nomeLaboratorio).toString();
        }
        return "Laboratório não encontrado";
    }

    /**
     * Método auxiliar para validar o nome informado, garantindo que não seja nulo e nem vazio.
     *
     * @param nome a string a ser validada.
     * @return true se o nome for válido, false caso contrário.
     */
    private boolean validaNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }
}