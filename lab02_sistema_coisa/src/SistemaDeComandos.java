import entidades.Aluno;
import java.util.Scanner;

public class SistemaDeComandos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = null;

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();
            if (linha.isEmpty()) {
                continue;
            }

            String[] partes = linha.split(" ", 2);
            String opcao = partes[0].toUpperCase();
            String argumentos = partes.length > 1 ? partes[1] : "";
            String[] argsArray = argumentos.split(" ");

            try {
                switch (opcao) {
                    case "CRIAR_ALUNO" -> {
                        if (!argumentos.isEmpty()) {
                            aluno = new Aluno(argumentos);
                            System.out.println("Aluno " + argumentos + " criado com sucesso.");
                        }
                    }
                    case "CADASTRA_LAB" -> {
                        if (!argumentos.isEmpty() && aluno != null) {
                            aluno.cadastraLaboratorio(argumentos);
                        }
                    }
                    case "CONSOME" -> {
                        if (argsArray.length >= 2 && aluno != null) {
                            String nomeLaboratorio = argsArray[0];
                            int mbytes = Integer.parseInt(argsArray[1]);
                            aluno.consomeEspaco(nomeLaboratorio, mbytes);
                        }
                    }
                    case "LIBERA" -> {
                        if (argsArray.length >= 2 && aluno != null) {
                            String nomeLaboratorio = argsArray[0];
                            int mbytes = Integer.parseInt(argsArray[1]);
                            aluno.liberaEspaco(nomeLaboratorio, mbytes);
                        }
                    }
                    case "IMPRIME_LAB" -> {
                        if (!argumentos.isEmpty() && aluno != null) {
                            System.out.println(aluno.laboratorioToString(argumentos));
                        }
                    }
                    case "SAIR" -> {
                        System.out.println("Encerrando o Sistema de Comandos...");
                        scanner.close();
                        return;
                    }
                    default -> {
                        System.out.println("Comando desconhecido!");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: O valor numérico informado é inválido.");
            } catch (Exception e) {
                System.out.println("Erro ao executar comando: " + e.getMessage());
            }
        }
    }
}
