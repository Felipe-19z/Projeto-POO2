class PacienteInativoException extends Exception {
    public PacienteInativoException(String mensagem) {
        super(mensagem);
    }

    public PacienteInativoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
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