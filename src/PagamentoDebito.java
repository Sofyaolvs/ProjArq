import java.util.Date;

public class PagamentoDebito extends Pagamento {
    private String numeroDebito;

    public PagamentoDebito(String id, float valor, Date dataPagamento, String numeroDebito) {
        super(id, valor, dataPagamento);
        this.numeroDebito = numeroDebito;
    }

    @Override
    public float efetuarPagamento(float valor) {
        return super.efetuarPagamento(valor);
    }

    @Override
    public boolean verificarPagamento() {
        return super.verificarPagamento();
    }

} 