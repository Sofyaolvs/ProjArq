import java.util.Date;

public class Pagamento {
    private String id;
    private float valor;
    private Date data;

    public Pagamento(String id, float valor, Date data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }
    public float efetuarPagamento(float valor) {
        // Implementar lógica de pagamento
        return valor; // Exemplo: retorna o valor pago
    }
    public boolean verificarPagamento() {
        // Implementar lógica de verificação de pagamento
        return true; // Exemplo: retorna true por padrão
    }
}
