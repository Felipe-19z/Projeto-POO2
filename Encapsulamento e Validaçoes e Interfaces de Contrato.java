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

interface Agendavel {
    void agendar();
    void cancelar();
    void remarcar();
}

interface Exportavel {
    String exportarDados();
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