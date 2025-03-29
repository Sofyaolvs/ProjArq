public class PagamentoDebito extends Pagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String codigoSeguranca;
    private String banco;
    
    public PagamentoDebito(String id, float valor, String numeroCartao, String nomeTitular, 
                          String codigoSeguranca, String banco) {
        super(id, valor);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.codigoSeguranca = codigoSeguranca;
        this.banco = banco;
    }
    
    @Override
    public boolean processar() {
        // Lógica específica para processar pagamento via débito
        System.out.println("Processando pagamento via cartão de débito: " + 
                          numeroCartao.substring(numeroCartao.length() - 4));
        
        // Simulação de verificação de saldo
        boolean temSaldo = verificarSaldo();
        
        if (temSaldo) {
            return confirmarPagamento();
        } else {
            cancelarPagamento();
            return false;
        }
    }
    
    private boolean verificarSaldo() {
        // Simulação de verificação de saldo
        // Em um sistema real, esta verificação seria feita com a integração bancária
        return Math.random() > 0.1; // 90% de chance de ter saldo
    }
    
    // Getters
    public String getNumeroCartao() {
        return numeroCartao;
    }
    
    public String getNomeTitular() {
        return nomeTitular;
    }
    
    public String getBanco() {
        return banco;
    }
}