/*
Caro professor. 
Fiz a atividade pelo VS code, pois ja usava outras linguagens nele, tenho mais familiaridade e já tenho configurado... Tambem, porque, o intellij trava um pouco no meu notebook. 
Espero que compreenda... 
Obrigrada!
*/
package A3;

import java.util.ArrayList;
import java.util.Scanner;

public class FolhaPagamento {
    public static final double salarioBase = 2000.0;

        public static int numInteiro(Scanner scanner, String mensagem) //pra não repetir a validação toda hora
    {
        int valor;

        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {

                valor = scanner.nextInt();
                scanner.nextLine();//limpa o enter

                if (valor < 0) {
                    System.out.println("Valor não pode ser negativo.");
                } else {
                    return valor;
                }
            } else {
                System.out.println("Digite um número inteiro válido.");
                scanner.nextLine();
            }
        }
    }

    public static double numDouble(Scanner scanner, String mensagem) {

        double valor;

        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                scanner.nextLine();

                if (valor < 0) {
                    System.out.println("Valor não pode ser negativo.");
                } else {
                    return valor;
                }
            } else {
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> colaboradores = new ArrayList<>(); 

        int opcao = -1; //para, sempre iniciar o menu
        while (opcao != 0) {
            mostrarMenu();

            opcao = numInteiro(scanner, "Escolha uma opção: ");
            switch (opcao) {
                case 1:
                    cadastrarFuncionarioPadrao(scanner, colaboradores);
                    break;
                case 2:
                    cadastrarFuncionarioComissionado(scanner, colaboradores);
                    break;
                case 3:
                    cadastrarFuncionarioProducao(scanner, colaboradores);
                    break;
                case 4:
                    gerarFolhaPagamento(colaboradores);
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println(); //so para quebrar linha
        }
        scanner.close();
    }


    public static void mostrarMenu() {
        System.out.println("<<<<< MENU >>>>>");
        System.out.println("1 - Cadastrar funcionário padrão");
        System.out.println("2 - Cadastrar funcionário comissionado");
        System.out.println("3 - Cadastrar funcionário de produção");
        System.out.println("4 - Gerar folha de pagamento");
        System.out.println("0 - Sair");
    }

    public static void cadastrarFuncionarioPadrao(Scanner scanner, ArrayList<String> colaboradores) //recebe um scanner para ler os dados e a lista array para guardar o funcionario cadastrado
    {
        System.out.println("<<< Cadastro funcionário padrão >>>");

        String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            if (nome.trim().isEmpty()) //trim remove os espaços antes e depois, isEmpty verifica se esta vazio  
            {
                System.out.println("Digite um nome: ");
            }else{
                break;
            }
        }

        int matricula = numInteiro(scanner, "Matrícula: ");

        double salarioFinal = salarioBase;

        String dados =
                "Tipo: Funcionário padrão\n" +
                "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Salário final: R$ " + String.format("%.2f", salarioFinal); //pra fazer um num de 2 casas

        colaboradores.add(dados);//adiciona a string dados ao array

        System.out.println("Funcionário cadastrado.");
    }

    public static void cadastrarFuncionarioComissionado(Scanner scanner, ArrayList<String> colaboradores) {
        System.out.println("<<< Cadastro funcionário comissionado >>>");

        String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            if (nome.trim().isEmpty()) {
                System.out.println("Digite um nome: ");
            }else{
                break;
            }
        }

        int matricula = numInteiro(scanner, "Matrícula: ");

        int totalVendas = numInteiro(scanner, "Valor total de vendas:R$");
        double percentualComissao = numDouble(scanner, "Percentual de comissão: ");
        double comissao = totalVendas * percentualComissao / 100;

        double salarioFinal = salarioBase + comissao;

        String dados =
                "Tipo: Funcionário comissionado\n" +
                "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Comissão: R$ " + String.format("%.2f", comissao) + "\n" +
                "Salário final: R$ " + String.format("%.2f", salarioFinal);

        colaboradores.add(dados);

        System.out.println("Funcionário cadastrado.");
    }

    public static void cadastrarFuncionarioProducao(Scanner scanner, ArrayList<String> colaboradores) {
        System.out.println("<<< Cadastro funcionário produção >>>");

        String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = scanner.nextLine();

            if (nome.trim().isEmpty()) {
                System.out.println("Digite um nome: ");
            }else{
                break;
            }
        }

        int matricula = numInteiro(scanner, "Matrícula: ");

        int quantidadePecas = numInteiro(scanner, "Quantidade de peças: ");
        double valorPorPeca = numDouble(scanner, "Valor por peça: R$");
        double extraProducao = quantidadePecas * valorPorPeca;

        double salarioFinal = salarioBase + extraProducao;

        String dados =
                "Tipo: Funcionário produção\n" +
                "Nome: " + nome + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Extra produção: R$ " + String.format("%.2f", extraProducao) + "\n" +
                "Salário final: R$ " + String.format("%.2f", salarioFinal);

        colaboradores.add(dados);

        System.out.println("Funcionário cadastrado.");
    }

    public static void gerarFolhaPagamento(ArrayList<String> colaboradores) {
        System.out.println("<<< FOLHA DE PAGAMENTO >>>");

        if (colaboradores.isEmpty())//verifica se a lista ta vazia 
            {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }
        System.out.println("Total de colaboradores: " + colaboradores.size());
        System.out.println(); //quebra linha

        for (int a = 0; a < colaboradores.size(); a++)//"enquanto 'a' for menor que a quantidade de colaboradores, 'a' adiciona +1" serve pra percorrer a lista 
            {
            System.out.println("Colaborador " + (a + 1));
            System.out.println(colaboradores.get(a));
            System.out.println("---------------------");
        }
    }
}