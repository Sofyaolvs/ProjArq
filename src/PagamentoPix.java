import java.util.Date;

public class PagamentoPix extends Pagamento{
    private String chavePix;
    public PagamentoPix(String id, float valor, Date dataPagamento, String chavePix) {
        super(id, valor, dataPagamento);
        this.chavePix = chavePix;
    }
    @Override
    public float efetuarPagamento(float valor) {
        return super.efetuarPagamento(valor);
    }
    @Override
    public boolean verificarPagamento() {
        return super.verificarPagamento();
    }
    public String getChavePix() {
        return chavePix;
    }

}