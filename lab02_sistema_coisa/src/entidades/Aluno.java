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
     * Mapa das contas de cantina do aluno, onde a chave é o nome da cantina.
     */
    private HashMap<String, ContaCantina> cantinas;

    /**
     * Representação da saúde de um aluno(a).
     */
    private Saude saude;

    /**
     * Constrói um aluno a partir do seu nome. Inicializa as coleções de laboratórios, disciplinas e cantinas como vazias.
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
        this.cantinas = new HashMap<>();
        this.saude = new Saude();
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
     * O cadastro só é realizado se o nome for válido e a disciplina ainda não existir.
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
     * Cadastra uma nova conta de cantina do aluno a partir do nome da cantina.
     *
     * @param nomeCantina o nome da cantina.
     */
    public void cadastraCantina(String nomeCantina) {
        if (this.validaNome(nomeCantina) && !this.cantinas.containsKey(nomeCantina)) {
            ContaCantina cantina = new ContaCantina(nomeCantina);
            this.cantinas.put(nomeCantina, cantina);
        }
    }

    /**
     * Cadastra um lanche feito numa cantina a partir da quantidade de itens e o valor gasto.
     * O lanche só será cadastrado se os valores forem positivos.
     *
     * @param nomeCantina o nome da cantina.
     * @param quantidadeItens a quantidade de itens.
     * @param valor o valor em centavos do lanche.
     */
    public void cadastraLanche(String nomeCantina, int quantidadeItens, int valor) {
        if (this.validaNome(nomeCantina) && this.cantinas.containsKey(nomeCantina)) {
            this.cantinas.get(nomeCantina).cadastraLanche(quantidadeItens, valor);
        }
    }

    /**
     * Realiza o pagamento do valor em débito na cantina. O valor só será aceito se for maior que zero
     * e menor ou igual ao valor do débito.
     *
     * @param nomeCantina o nome da cantina.
     * @param valor o valor em centavos.
     */
    public void pagarConta(String nomeCantina, int valor) {
        if (this.validaNome(nomeCantina) && this.cantinas.containsKey(nomeCantina)) {
            this.cantinas.get(nomeCantina).pagaConta(valor);
        }
    }

    /**
     * Retorna o valor em centavos que está em débito na cantina.
     *
     * @param nomeCantina o nome da cantina.
     * @return o valor em centavos que está em débito ou -1 caso a conta na cantina não exista.
     */
    public int getFaltaPagar(String nomeCantina) {
        if (this.validaNome(nomeCantina) && this.cantinas.containsKey(nomeCantina)) {
            return this.cantinas.get(nomeCantina).getFaltaPagar();
        }
        return -1;
    }

    /**
     * Retorna a String que representa uma cantina. A representação segue o formato:
     * "NomeDaCantina totalDeItensConsumidos TotalGasto".
     *
     * @param nomeCantina o nome da cantina.
     * @return a representação em String da cantina ou "" (vazio) caso a conta na cantina não exista.
     */
    public String cantinaToString(String nomeCantina) {
        if (this.validaNome(nomeCantina) && this.cantinas.containsKey(nomeCantina)) {
            return this.cantinas.get(nomeCantina).toString();
        }
        return "";
    }

    /**
     * Define a saúde mental do aluno(a). É possível definir somente dois valores, boa ou fraca.
     * Sempre que a saúde mental sofrer alteração, o emoji que representa o sentimento geral do aluno
     * é redefinido.
     *
     * @param valor o valor que representa a saúde mental do aluno(a).
     */
    public void defineSaudeMental(String valor) {
        this.saude.defineSaudeMental(valor);
    }

    /**
     * Define a saúde física do aluno(a). É possível definir somente dois valores, boa ou fraca.
     * Sempre que a saúde física sofrer alteração, o emoji que representa o sentimento geral do aluno
     * é redefinido.
     *
     * @param valor o valor que representa a saúde física do aluno(a).
     */
    public void defineSaudeFisica(String valor) {
        this.saude.defineSaudeFisica(valor);
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
        return this.saude.getStatusGeral();
    }

    /**
     * Define o emoji que representa o sentimento geral do aluno.
     *
     * @param emoji o emoji que representa o sentimento geral do aluno.
     */
    public void definirEmoji(String emoji) {
        this.saude.definirEmoji(emoji);
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