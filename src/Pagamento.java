import java.util.Date;

public class Pagamento {
    private String id;
    private float valor;
    private String status; // "Pendente", "Concluído", "Cancelado", etc.
    private Date dataPagamento;
    
    public Pagamento(String id, float valor) {
        this.id = id;
        this.valor = valor;
        this.status = "Pendente";
    }
    
    public Pagamento(String idPagamento, float valor2, Date dataPagamento2, Locatario locatario) {
        //TODO Auto-generated constructor stub
    }

    // Método abstrato que será implementado de forma diferente por cada subclasse
    public  boolean processar(){
        // Lógica de processamento de pagamento genérica
        // Isso pode ser sobrescrito nas subclasses
        System.out.println("Processando pagamento genérico...");
        
        // Simulação de processamento bem-sucedido
        this.status = "Concluído";
        this.dataPagamento = new Date();
        return true;
    }
    
    // Método para confirmação de pagamento
    public boolean confirmarPagamento() {
        if (this.status.equals("Pendente")) {
            this.status = "Concluído";
            this.dataPagamento = new Date();
            return true;
        }
        return false;
    }
    
    // Método para cancelar pagamento
    public boolean cancelarPagamento() {
        if (!this.status.equals("Concluído")) {
            this.status = "Cancelado";
            return true;
        }
        return false;
    }
    
    // Getters e setters
    public String getId() {
        return id;
    }
    
    public float getValor() {
        return valor;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Date getDataPagamento() {
        return dataPagamento;
    }
}