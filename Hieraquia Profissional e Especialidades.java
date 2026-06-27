class Atendimento {}

abstract class Profissional extends Pessoa {
    private String especialidade;
    private boolean ativo;

    public Profissional(String nome, String cpf, int idade, String telefone, String especialidade) {
        super(nome, cpf, idade, telefone);
        this.especialidade = especialidade;
        this.ativo = true;
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
        System.out.println("Fisioterapeuta: " + getNome() + " | CPF: " + getCpf() + " | Sessões Previstas: " + totalSessoesPrevistas);
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
        System.out.println("Psicólogo: " + getNome() + " | CPF: " + getCpf() + " | Abordagem: " + abordagem);
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
        System.out.println("Nutricionista: " + getNome() + " | CPF: " + getCpf() + " | Plano Alimentar: " + planoAlimentar);
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
        System.out.println("Clínico Geral: " + getNome() + " | CPF: " + getCpf() + " | Encaminhamento: " + encaminhamento);
    }

    @Override
    protected void registrarEspecifico(Atendimento atendimento) {
    }
}