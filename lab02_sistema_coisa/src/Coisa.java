import entidades.*;

public class Coisa {
    public static void main(String[] args) {
        ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");
        contaLCC2.consomeEspaco(1999);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.consomeEspaco(2);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(1);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(1);
        System.out.println(contaLCC2.atingiuCota());
        System.out.println(contaLCC2.toString());

        Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());

        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());

        ContaCantina cantinaSeuMatias = new ContaCantina("Seu Matias");
        cantinaSeuMatias.cadastraLanche(2, 500);
        cantinaSeuMatias.cadastraLanche(1, 500);
        cantinaSeuMatias.pagaConta(200);
        System.out.println(cantinaSeuMatias.getFaltaPagar());
        System.out.println(cantinaSeuMatias.toString());

        Saude saude = new Saude();
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("boa");
        System.out.println(saude.getStatusGeral());

        saude.defineSaudeMental("fraca");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());

        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());

        // Bônus 5.1
        Disciplina prog3 = new Disciplina("PROGRAMACA 3", 5);
        prog3.cadastraNota(1, 7.8);
        prog3.cadastraNota(2, 5.9);
        prog3.cadastraNota(3, 6.6);
        prog3.cadastraNota(4, 8.1);
        prog3.cadastraNota(5, 6.8);
        System.out.println(prog3);
        System.out.println(prog3.aprovado());

        Disciplina prog4 = new Disciplina("PROGRAMACA 4", 5, new int[]{2, 4, 1, 1, 2});
        prog4.cadastraNota(1, 7.8);
        prog4.cadastraNota(2, 5.9);
        prog4.cadastraNota(3, 6.6);
        prog4.cadastraNota(4, 8.1);
        prog4.cadastraNota(5, 6.8);
        System.out.println(prog4);
        System.out.println(prog4.aprovado());

        // Bônus 5.2
        ContaCantina cantinaSeuLazaro = new ContaCantina("Seu Lázaro");
        cantinaSeuMatias.cadastraLanche(4, 600, "4 coxinhas de frango.");
        cantinaSeuMatias.cadastraLanche(1, 150, "1 xícara de café com leite.");
        cantinaSeuMatias.cadastraLanche(1, 500, "1 pastel de frango.");
        cantinaSeuMatias.cadastraLanche(2, 300, "2 fatias de bolo.");
        cantinaSeuMatias.cadastraLanche(1, 200, "1 suco de maracujá.");
        cantinaSeuMatias.cadastraLanche(1, 350, "1 coxinha e 1 suco.");
        System.out.println(cantinaSeuMatias.listarDetalhes()
        );

        // Bônus 5.3
        Saude saude2 = new Saude();
        System.out.println(saude2.getStatusGeral());
        saude2.defineSaudeMental("boa");
        saude2.defineSaudeFisica("boa");
        saude2.definirEmoji(":D");
        System.out.println(saude2.getStatusGeral());
        saude2.defineSaudeFisica("fraca");
        System.out.println(saude2.getStatusGeral());

        // Bônus 5.4
        System.out.println("----- TESTE BÔNUS 5.4: MÚLTIPLOS ALUNOS -----");

        Aluno jose = new Aluno("José");
        jose.cadastraLaboratorio("LCC1");
        jose.cadastraLaboratorio("LCC3", 1000);
        jose.consomeEspaco("LCC1", 500);

        Aluno maria = new Aluno("Maria");
        maria.cadastraLaboratorio("LCC1");
        maria.consomeEspaco("LCC1", 1990);

        System.out.println("-> Laboratórios do José:");
        System.out.println(jose.laboratorioToString("LCC1"));
        System.out.println(jose.laboratorioToString("LCC3"));

        System.out.println("\n-> Laboratórios da Maria:");
        System.out.println(maria.laboratorioToString("LCC1"));
        System.out.println("Maria atingiu a cota no LCC1? " + maria.atingiuCota("LCC1"));

        maria.consomeEspaco("LCC1", 20);
        System.out.println("E agora, atingiu a cota? " + maria.atingiuCota("LCC1"));

        System.out.println("\n-> Teste de Segurança:");
        System.out.println(jose.laboratorioToString("LCC2"));
    }
}