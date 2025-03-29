public class PagamentoPix extends Pagamento {
    private String chavePix;
    private String comprovante;
    
    public PagamentoPix(String id, float valor, String chavePix) {
        super(id, valor);
        this.chavePix = chavePix;
    }
    
    @Override
    public boolean processar() {
        // Lógica específica para processar pagamento via Pix
        // Por exemplo, gerar QR Code, verificar recebimento, etc.
        System.out.println("Processando pagamento via PIX para a chave: " + chavePix);
        
        // Simulação de processamento bem-sucedido
        this.comprovante = "PIX-" + getId() + "-" + System.currentTimeMillis();
        return confirmarPagamento();
    }
    
    public String getChavePix() {
        return chavePix;
    }
    
    public String getComprovante() {
        return comprovante;
    }
    
    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }
}