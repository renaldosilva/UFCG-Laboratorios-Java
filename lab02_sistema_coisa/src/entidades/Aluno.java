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
     * Mapa de disciplinas do aluno, onde a chave é o nome da disciplina.
     */
    private HashMap<String, Disciplina> disciplinas;

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
        this.disciplinas = new HashMap<>();
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
     * Cadastra uma nova disciplina para o aluno a partir do nome.
     * O cadastro só é realizado se o nome for válido e disciplina ainda não existir.
     *
     * @param nomeDisciplina o nome da disciplina.
     */
    public void cadastraDisciplina(String nomeDisciplina) {
        if (this.validaNome(nomeDisciplina) && !this.disciplinas.containsKey(nomeDisciplina)) {
            Disciplina disciplina = new Disciplina(nomeDisciplina);
            this.disciplinas.put(nomeDisciplina, disciplina);
        }
    }

    /**
     * Cadastra uma nova disciplina para o aluno com uma quantidade específica de notas.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param quantidadeNotas a quantidade de notas da disciplina.
     */
    public void cadastraDisciplina(String nomeDisciplina, int quantidadeNotas) {
        if (this.validaNome(nomeDisciplina) && !this.disciplinas.containsKey(nomeDisciplina)) {
            Disciplina disciplina = new Disciplina(nomeDisciplina, quantidadeNotas);
            this.disciplinas.put(nomeDisciplina, disciplina);
        }
    }

    /**
     * Cadastra uma nova disciplina para o aluno com quantidade de notas e pesos específicos.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param quantidadeNotas a quantidade de notas da disciplina.
     * @param pesoNotas os pesos de cada nota.
     */
    public void cadastraDisciplina(String nomeDisciplina, int quantidadeNotas, int[] pesoNotas) {
        if (this.validaNome(nomeDisciplina) && !this.disciplinas.containsKey(nomeDisciplina)) {
            Disciplina disciplina = new Disciplina(nomeDisciplina, quantidadeNotas, pesoNotas);
            this.disciplinas.put(nomeDisciplina, disciplina);
        }
    }

    /**
     * Cadastra as horas de estudo da disciplina de forma cumulativa.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param horas as horas de estudo da disciplina.
     */
    public void cadastraHoras(String nomeDisciplina, int horas) {
        if (this.validaNome(nomeDisciplina) && this.disciplinas.containsKey(nomeDisciplina)) {
            this.disciplinas.get(nomeDisciplina).cadastraHoras(horas);
        }
    }

    /**
     * Cadastra nota obtida na disciplina. É possível cadastrar N notas diferentes, indo de 1 a N respectivamente.
     * Cada nota vai de 0.0 até 10.0.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @param nota a nota correspondente (1, 2, 3, ..., N).
     * @param valorNota o valor da nota (0.0 até 10.0).
     */
    public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
        if (this.validaNome(nomeDisciplina) && this.disciplinas.containsKey(nomeDisciplina)) {
            this.disciplinas.get(nomeDisciplina).cadastraNota(nota, valorNota);
        }
    }

    /**
     * Verifica se o aluno foi aprovado na disciplina! Para ser aprovado, a média precisa
     * ser maior ou igual a 7.0.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @return true se foi aprovado, false caso contrário.
     */
    public boolean aprovado(String nomeDisciplina) {
        if (this.validaNome(nomeDisciplina) && this.disciplinas.containsKey(nomeDisciplina)) {
            return this.disciplinas.get(nomeDisciplina).aprovado();
        }
        return false;
    }

    /**
     * Retorna a String que representa a disciplina cadastrada pelo aluno.
     *
     * @param nomeDisciplina o nome da disciplina.
     * @return a representação em String da disciplina ou "Disciplina não encontrada" se não existir.
     */
    public String disciplinaToString(String nomeDisciplina) {
        if (this.validaNome(nomeDisciplina) && this.disciplinas.containsKey(nomeDisciplina)) {
            return this.disciplinas.get(nomeDisciplina).toString();
        }
        return "Disciplina não encontrada";
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