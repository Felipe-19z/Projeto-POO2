import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ClinicaServico servico = new ClinicaServico();
        Scanner scanner = new Scanner(System.in);
        boolean ativo = true;

        while (ativo) {
            System.out.println("\n--- GESTAO CLINICA VIDAPLENA ---");
            System.out.println("1. Cadastrar Novo Paciente");
            System.out.println("2. Consultar Cadastro por CPF");
            System.out.println("3. Fechar Sistema");
            System.out.print("Comando: ");

            try {
                String entrada = scanner.nextLine();
                int opcao = Integer.parseInt(entrada);

                if (opcao == 1) {
                    System.out.print("Nome Completo: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF (Somente Numeros): ");
                    String cpf = scanner.nextLine();
                    Paciente novoPaciente = new Paciente(nome, cpf);
                    servico.cadastrarPaciente(novoPaciente);
                    System.out.println("Operacao concluida com sucesso.");
                } else if (opcao == 2) {
                    System.out.print("Informe o CPF de Busca: ");
                    String cpfBusca = scanner.nextLine();
                    Paciente localizado = servico.buscarPaciente(cpfBusca);
                    localizado.exibirResumo();
                } else if (opcao == 3) {
                    ativo = false;
                } else {
                    System.out.println("Alerta: Comando numerico inexistente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada invalida. Digite apenas numeros para as opcoes.");
            } catch (PacienteNaoEncontradoException | PacienteInativoException | OperacaoInvalidaException e) {
                System.out.println("Inconsistencia Clinica: " + e.getMessage());
            } finally {
                System.out.println("[Auditoria] Conclusao de ciclo operacional realizada.");
            }
        }
        scanner.close();
    }
}