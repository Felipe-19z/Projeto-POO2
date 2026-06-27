import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ClinicaServico {
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

    public void cadastrarProfissional(Profissional profissional) {
        profissionaisPorNome.put(profissional.getNome(), profissional);
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
        pagamento.calcularValorFinal();
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
}