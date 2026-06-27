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
        return getFinal();
    }

    public double getFinal() {
        return getValorFinal();
    }

    @Override
    public String exportarDados() {
        return "PAGAMENTO_CONVENIO;" + getValorBase() + ";" + getValorFinal() + ";" + (convenio != null ? convenio.getNome() : "Nenhum");
    }
}