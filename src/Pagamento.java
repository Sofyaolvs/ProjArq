import java.util.Date;

public class Pagamento {
    private String id;
    private float valor;
    private String status; 
    private Date dataPagamento;
    
    public Pagamento(String id, float valor) {
        this.id = id;
        this.valor = valor;
        this.status = "Pendente";
    }
    
    public Pagamento(String idPagamento, float valor2, Date dataPagamento2, Locatario locatario) {
        //TODO Auto-generated constructor stub
    }

  
    public  boolean processar(){

        System.out.println("Processando pagamento genérico...");

        this.status = "Concluído";
        this.dataPagamento = new Date();
        return true;
    }

    public boolean confirmarPagamento() {
        if (this.status.equals("Pendente")) {
            this.status = "Concluído";
            this.dataPagamento = new Date();
            return true;
        }
        return false;
    }

    public boolean cancelarPagamento() {
        if (!this.status.equals("Concluído")) {
            this.status = "Cancelado";
            return true;
        }
        return false;
    }

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