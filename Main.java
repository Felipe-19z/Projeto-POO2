import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class PacienteInativoException extends Exception {
    public PacienteInativoException(String mensagem) {
        super(mensagem);
    }
    public PacienteInativoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}

class PacienteNaoEncontradoException extends Exception {
    public PacienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    public PacienteNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

class HorarioIndisponivelException extends Exception {
    public HorarioIndisponivelException(String mensagem) {
        super(mensagem);
    }
    public HorarioIndisponivelException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

class ConvenioNaoCobreException extends Exception {
    public ConvenioNaoCobreException(String mensagem) {
        super(mensagem);
    }
    public ConvenioNaoCobreException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

class OperacaoInvalidaException extends Exception {
    public OperacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
    public OperacaoInvalidaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

interface Agendavel {
    void agendar();
    void cancelar();
    void remarcar();
}

interface Exportavel {
    String exportarDados();
}

class Convenio {
    private String nome;
    private double percentualCobertura;

    public Convenio(String nome, double percentualCobertura) {
        this.nome = nome;
        this.percentualCobertura = percentualCobertura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPercentualCobertura() {
        return percentualCobertura;
    }

    public void setPercentualCobertura(double percentualCobertura) {
        this.percentualCobertura = percentualCobertura;
    }
}

abstract class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;

    public Pessoa(String nome, String cpf, int idade, String telefone) {
        this.nome = nome;
        setCpf(cpf);
        setIdade(idade);
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            this.cpf = "000.000.000-00";
        } else {
            this.cpf = cpf;
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            this.idade = 0;
        } else {
            this.idade = idade;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public abstract void exibirResumo();
}

class Paciente extends Pessoa {
    private boolean temConvenio;
    private Convenio convenio;
    private boolean ativo;
    private double multaPendente;

    public Paciente(String nome, String cpf) {
        super(nome, cpf, 0, "");
        this.ativo = true;
        this.multaPendente = 0.0;
        this.temConvenio = false;
    }

    public Paciente(String nome, String cpf, int idade, String telefone) {
        super(nome, cpf, idade, telefone);
        this.ativo = true;
        this.multaPendente = 0.0;
        this.temConvenio = false;
    }

    public Paciente(String nome, String cpf, int idade, String telefone, Convenio convenio) {
        super(nome, cpf, idade, telefone);
        this.convenio = convenio;
        this.temConvenio = convenio != null;
        this.ativo = true;
        this.multaPendente = 0.0;
    }

    public void complementarDados(int novaIdade, String novoTelefone) {
        setIdade(novaIdade);
        setTelefone(novoTelefone);
    }

    public void complementarDados(int novaIdade, String novoTelefone, Convenio novoConvenio) {
        setIdade(novaIdade);
        setTelefone(novoTelefone);
        this.convenio = novoConvenio;
        this.temConvenio = novoConvenio != null;
    }

    public boolean isTemConvenio() {
        return temConvenio;
    }

    public void setTemConvenio(boolean temConvenio) {
        this.temConvenio = temConvenio;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
        this.temConvenio = convenio != null;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getMultaPendente() {
        return multaPendente;
    }

    public void setMultaPendente(double multaPendente) {
        this.multaPendente = multaPendente;
    }

    @Override
    public void exibirResumo() {
        System.out.println("Paciente: " + getNome() + " | CPF: " + getCpf() + " | Idade: " + getIdade() + " | Status: " + (ativo ? "Ativo" : "Inativo"));
    }
}

class HorarioDisponivel {
    private String dataHora;
    private boolean disponivel;

    public HorarioDisponivel(String dataHora) {
        this.dataHora = dataHora;
        this.disponivel = true;
    }

    public String getDataHora() {
        return dataHora;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

abstract class Profissional extends Pessoa {
    private String especialidade;
    private boolean ativo;
    private List<HorarioDisponivel> horarios;

    public Profissional(String nome, String cpf, int idade, String telefone, String especialidade) {
        super(nome, cpf, idade, telefone);
        this.especialidade = especialidade;
        this.ativo = true;
        this.horarios = new ArrayList<>();
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<HorarioDisponivel> getHorarios() {
        return horarios;
    }

    public void adicionarHorario(HorarioDisponivel horario) {
        this.horarios.add(horario);
    }

    protected abstract void registrarEspecifico(Atendimento atendimento);
}

class Fisioterapeuta extends Profissional {
    private int totalSessoesPrevistas;

    public Fisioterapeuta(String nome, String cpf, int idade, String telefone, int totalSessoesPrevistas) {
        super(nome, cpf, idade, telefone, "Fisioterapia");
        this.totalSessoesPrevistas = totalSessoesPrevistas;
    }

    public int getTotalSessoesPrevistas() {
        return totalSessoesPrevistas;
    }

    public void setTotalSessoesPrevistas(int totalSessoesPrevistas) {
        this.totalSessoesPrevistas = totalSessoesPrevistas;
    }

    @Override
    public void exibirResumo() {
        System.out.println("Fisioterapeuta: " + getNome() + " | CPF: " + getCpf() + " | Especialidade: " + getEspecialidade());
    }

    @Override
    protected void registrarEspecifico(Atendimento atendimento) {
    }
}

class Psicologo extends Profissional {
    private String abordagem;

    public Psicologo(String nome, String cpf, int idade, String telefone, String abordagem) {
        super(nome, cpf, idade, telefone, "Psicologia");
        this.abordagem = abordagem;
    }

    public String getAbordagem() {
        return abordagem;
    }

    public void setAbordagem(String abordagem) {
        this.abordagem = abordagem;
    }

    @Override
    public void exibirResumo() {
        System.out.println("Psicólogo: " + getNome() + " | CPF: " + getCpf() + " | Especialidade: " + getEspecialidade());
    }

    @Override
    protected void registrarEspecifico(Atendimento atendimento) {
    }
}

class Nutricionista extends Profissional {
    private String planoAlimentar;

    public Nutricionista(String nome, String cpf, int idade, String telefone, String planoAlimentar) {
        super(nome, cpf, idade, telefone, "Nutrição");
        this.planoAlimentar = planoAlimentar;
    }

    public String getPlanoAlimentar() {
        return planoAlimentar;
    }

    public void setPlanoAlimentar(String planoAlimentar) {
        this.planoAlimentar = planoAlimentar;
    }

    @Override
    public void exibirResumo() {
        System.out.println("Nutricionista: " + getNome() + " | CPF: " + getCpf() + " | Especialidade: " + getEspecialidade());
    }

    @Override
    protected void registrarEspecifico(Atendimento atendimento) {
    }
}

class ClinicoGeral extends Profissional {
    private String encaminhamento;

    public ClinicoGeral(String nome, String cpf, int idade, String telefone, String encaminhamento) {
        super(nome, cpf, idade, telefone, "Clínica Geral");
        this.encaminhamento = encaminhamento;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    @Override
    public void exibirResumo() {
        System.out.println("Clínico Geral: " + getNome() + " | CPF: " + getCpf() + " | Especialidade: " + getEspecialidade());
    }

    @Override
    protected void registrarEspecifico(Atendimento atendimento) {
    }
}

class Consulta implements Agendavel, Exportavel {
    private Paciente paciente;
    private Profissional profissional;
    private String dataHora;
    private String status;
    private double valorBase;

    public Consulta(Paciente paciente, Profissional profissional, String dataHora, double valorBase) {
        this.paciente = paciente;
        this.profissional = profissional;
        this.dataHora = dataHora;
        this.valorBase = valorBase;
        this.status = "agendada";
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValorBase() {
        return valorBase;
    }

    @Override
    public void agendar() {
        this.status = "agendada";
    }

    @Override
    public void cancelar() {
        this.status = "cancelada";
    }

    @Override
    public void remarcar() {
        this.status = "remarcada";
    }

    @Override
    public String exportarDados() {
        return "CONSULTA;" + paciente.getCpf() + ";" + profissional.getNome() + ";" + dataHora + ";" + status;
    }
}

class Prontuario {
    private String historicoClinico;
    private String observacoes;

    protected Prontuario(String historicoClinico, String observacoes) {
        this.historicoClinico = historicoClinico;
        this.observacoes = observacoes;
    }

    public String getHistoricoClinico() {
        return historicoClinico;
    }

    public String getObservacoes() {
        return observacoes;
    }
}

class Atendimento implements Exportavel {
    private Consulta consulta;
    private Prontuario prontuario;
    private String diagnostico;

    public Atendimento(Consulta consulta, String historico, String observacoes, String diagnostico) {
        this.consulta = consulta;
        this.diagnostico = diagnostico;
        this.prontuario = new Prontuario(historico, observacoes);
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    @Override
    public String exportarDados() {
        return "ATENDIMENTO;" + consulta.getPaciente().getNome() + ";" + diagnostico + ";" + prontuario.getHistoricoClinico();
    }
}

abstract class Pagamento implements Exportavel {
    private double valorBase;
    private double valorFinal;

    public Pagamento(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getValorBase() {
        return valorBase;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    protected void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public abstract double calcularValorFinal();
}

class PagamentoDinheiro extends Pagamento {
    public PagamentoDinheiro(double valorBase) {
        super(valorBase);
    }

    @Override
    public double calcularValorFinal() {
        setValorFinal(getValorBase() * 0.95);
        return getValorFinal();
    }

    @Override
    public String exportarDados() {
        return "PAGAMENTO_DINHEIRO;" + getValorBase() + ";" + getValorFinal();
    }
}

class PagamentoCartao extends Pagamento {
    private int parcelas;

    public PagamentoCartao(double valorBase, int parcelas) {
        super(valorBase);
        this.parcelas = parcelas;
    }

    @Override
    public double calcularValorFinal() {
        if (parcelas > 3) {
            setValorFinal(getValorBase() * (1 + (0.025 * (parcelas - 3))));
        } else {
            setValorFinal(getValorBase());
        }
        return getValorFinal();
    }

    @Override
    public String exportarDados() {
        return "PAGAMENTO_CARTAO;" + getValorBase() + ";" + getValorFinal() + ";" + parcelas;
    }
}

class PagamentoConvenio extends Pagamento {
    private Convenio convenio;

    public PagamentoConvenio(double valorBase, Convenio convenio) {
        super(valorBase);
        this.convenio = convenio;
    }

    @Override
    public double calcularValorFinal() {
        if (convenio != null) {
            setValorFinal(getValorBase() * (1 - (convenio.getPercentualCobertura() / 100.0)));
        } else {
            setValorFinal(getValorBase());
        }
        return getValorFinal();
    }

    @Override
    public String exportarDados() {
        return "PAGAMENTO_CONVENIO;" + getValorBase() + ";" + getValorFinal() + ";" + (convenio != null ? convenio.getNome() : "Nenhum");
    }
}

class ClinicaServico {
    private List<Pessoa> todasAsPessoas = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();
    private List<Atendimento> atendimentos = new ArrayList<>();
    private List<Pagamento> pagamentos = new ArrayList<>();
    private Set<String> cpfsCadastrados = new HashSet<>();
    private Map<String, Paciente> pacientesPorCpf = new HashMap<>();
    private Map<String, Profissional> profissionaisPorNome = new HashMap<>();

    public void cadastrarPaciente(Paciente paciente) throws OperacaoInvalidaException {
        if (cpfsCadastrados.contains(paciente.getCpf())) {
            throw new OperacaoInvalidaException("CPF ja cadastrado no sistema.");
        }
        cpfsCadastrados.add(paciente.getCpf());
        pacientesPorCpf.put(paciente.getCpf(), paciente);
        todasAsPessoas.add(paciente);
    }

    public void cadastrarProfissional(Profissional profissional) throws OperacaoInvalidaException {
        if (cpfsCadastrados.contains(profissional.getCpf())) {
            throw new OperacaoInvalidaException("CPF ja cadastrado no sistema.");
        }
        cpfsCadastrados.add(profissional.getCpf());
        profissionaisPorNome.put(profissional.getNome(), profissional);
        todasAsPessoas.add(profissional);
    }

    public Paciente buscarPaciente(String cpf) throws PacienteNaoEncontradoException, PacienteInativoException {
        Paciente p = pacientesPorCpf.get(cpf);
        if (p == null) {
            throw new PacienteNaoEncontradoException("Nenhum paciente localizado com o CPF informado.");
        }
        if (!p.isAtivo()) {
            throw new PacienteInativoException("O paciente informado encontra-se inativo.");
        }
        return p;
    }

    public Profissional buscarProfissional(String nome) throws OperacaoInvalidaException {
        Profissional p = profissionaisPorNome.get(nome);
        if (p == null) {
            throw new OperacaoInvalidaException("Profissional nao localizado no sistema.");
        }
        return p;
    }

    public void agendarConsulta(Consulta consulta) throws HorarioIndisponivelException {
        consultas.add(consulta);
    }

    public void registrarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
    }

    public void registrarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void exibirRelatorioUnificadoPessoas() {
        System.out.println("\n--- RELATORIO UNIFICADO DE PESSOAS ---");
        for (Pessoa p : todasAsPessoas) {
            p.exibirResumo();
            if (p instanceof Paciente) {
                Paciente pac = (Paciente) p;
                System.out.println(" -> Tipo: Paciente | Convenio: " + (pac.isTemConvenio() ? pac.getConvenio().getNome() : "Particular"));
            } else if (p instanceof Fisioterapeuta) {
                Fisioterapeuta fis = (Fisioterapeuta) p;
                System.out.println(" -> Tipo: Fisioterapeuta | Sessoes Planejadas: " + fis.getTotalSessoesPrevistas());
            } else if (p instanceof Psicologo) {
                Psicologo psi = (Psicologo) p;
                System.out.println(" -> Tipo: Psicologo | Abordagem: " + psi.getAbordagem());
            } else if (p instanceof Nutricionista) {
                Nutricionista nut = (Nutricionista) p;
                System.out.println(" -> Tipo: Nutricionista | Plano: " + nut.getPlanoAlimentar());
            } else if (p instanceof ClinicoGeral) {
                ClinicoGeral cli = (ClinicoGeral) p;
                System.out.println(" -> Tipo: Clinico Geral | Encaminhamento: " + cli.getEncaminhamento());
            }
        }
    }

    public void exibirRelatorioPagamentos() {
        System.out.println("\n--- RELATORIO POLIMORFICO DE PAGAMENTOS ---");
        for (Pagamento pag : pagamentos) {
            System.out.println("Transacao: " + pag.exportarDados() + " | Valor Final Calculado: " + pag.calcularValorFinal());
        }
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}

public class Main {
    public static void main(String[] args) {
        ClinicaServico servico = new ClinicaServico();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        try {
            Convenio c1 = new Convenio("SaudePlus", 40.0);
            Paciente p1 = new Paciente("Ana Silva", "11122233344", 30, "999999999", c1);
            servico.cadastrarPaciente(p1);

            Profissional pro1 = new Psicologo("Dr. Carlos", "55566677788", 40, "988888888", "TCC");
            servico.cadastrarProfissional(pro1);
        } catch (Exception ignored) {}

        while (executando) {
            System.out.println("\n=== SISTEMA DE GESTAO VIDAPLENA ===");
            System.out.println("1. Cadastrar Paciente (Particular)");
            System.out.println("2. Cadastrar Psicologo");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Registrar Atendimento e Prontuario");
            System.out.println("5. Processar Pagamento");
            System.out.println("6. Relatorio Unificado (Pessoas)");
            System.out.println("7. Relatorio Financeiro (Pagamentos)");
            System.out.println("8. Fechar Aplicacao");
            System.out.print("Escolha uma opcao: ");

            try {
                String entrada = scanner.nextLine();
                int opcao = Integer.parseInt(entrada);

                if (opcao == 1) {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Telefone: ");
                    String tel = scanner.nextLine();

                    Paciente p = new Paciente(nome, cpf, idade, tel);
                    servico.cadastrarPaciente(p);
                    System.out.println("Paciente registrado com sucesso.");

                } else if (opcao == 2) {
                    System.out.print("Nome do Psicologo: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Telefone: ");
                    String tel = scanner.nextLine();
                    System.out.print("Abordagem Clinica: ");
                    String abordagem = scanner.nextLine();

                    Profissional pro = new Psicologo(nome, cpf, idade, tel, abordagem);
                    servico.cadastrarProfissional(pro);
                    System.out.println("Profissional registrado com sucesso.");

                } else if (opcao == 3) {
                    System.out.print("CPF do Paciente: ");
                    String cpf = scanner.nextLine();
                    Paciente pac = servico.buscarPaciente(cpf);

                    System.out.print("Nome do Profissional: ");
                    String nomePro = scanner.nextLine();
                    Profissional prof = servico.buscarProfissional(nomePro);

                    System.out.print("Data e Hora: ");
                    String dt = scanner.nextLine();
                    System.out.print("Valor Base da Consulta: ");
                    double valor = Double.parseDouble(scanner.nextLine());

                    Consulta cons = new Consulta(pac, prof, dt, valor);
                    servico.agendarConsulta(cons);
                    System.out.println("Consulta marcada.");

                } else if (opcao == 4) {
                    if (servico.getConsultas().isEmpty()) {
                        throw new OperacaoInvalidaException("Nao existem consultas agendadas para iniciar um atendimento.");
                    }
                    Consulta cons = servico.getConsultas().get(0);
                    System.out.print("Historico Clinico: ");
                    String hist = scanner.nextLine();
                    System.out.print("Observacoes: ");
                    String obs = scanner.nextLine();
                    System.out.print("Diagnostico Final: ");
                    String diag = scanner.nextLine();

                    Atendimento at = new Atendimento(cons, hist, obs, diag);
                    servico.registrarAtendimento(at);
                    cons.setStatus("realizada");
                    System.out.println("Atendimento finalizado e Prontuario gerado com composicao estrutural.");

                } else if (opcao == 5) {
                    System.out.print("Valor da Transacao: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    System.out.println("Tipo: 1-Dinheiro (Desconto) | 2-Cartao (Parcelado)");
                    int tipo = Integer.parseInt(scanner.nextLine());

                    Pagamento pag;
                    if (tipo == 1) {
                        pag = new PagamentoDinheiro(valor);
                    } else {
                        System.out.print("Numero de Parcelas: ");
                        int parc = Integer.parseInt(scanner.nextLine());
                        pag = new PagamentoCartao(valor, parc);
                    }
                    servico.registrarPagamento(pag);
                    System.out.println("Pagamento adicionado ao fluxo financeiro.");

                } else if (opcao == 6) {
                    servico.exibirRelatorioUnificadoPessoas();

                } else if (opcao == 7) {
                    servico.exibirRelatorioPagamentos();

                } else if (opcao == 8) {
                    executando = false;
                } else {
                    System.out.println("Opcao invalida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro Crítico: A entrada inserida nao corresponde a um formato numerico valido.");
            } catch (PacienteInativoException | PacienteNaoEncontradoException | HorarioIndisponivelException | ConvenioNaoCobreException | OperacaoInvalidaException e) {
                System.out.println("Excecao de Negocio: " + e.getMessage());
            } finally {
                System.out.println("[Rotina de Auditoria] Operacao de ciclo terminada com seguranca.");
            }
        }
        scanner.close();
    }
}