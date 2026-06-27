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