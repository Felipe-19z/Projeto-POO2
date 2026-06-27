import java.util.ArrayList;
import java.util.List;

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