public class PagamentoCartaoCredito extends Pagamento {
    private String numeroCartao;
    private String nomeTitular;
    private String codigoSeguranca;
    private String validade;
    private int parcelas;
    
    public PagamentoCartaoCredito(String id, float valor, String numeroCartao, 
                                 String nomeTitular, String codigoSeguranca, 
                                 String validade, int parcelas) {
        super(id, valor);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.codigoSeguranca = codigoSeguranca;
        this.validade = validade;
        this.parcelas = parcelas > 0 ? parcelas : 1;
    }
    
    @Override
    public boolean processar() {
        // Lógica específica para processar pagamento via cartão de crédito
        System.out.println("Processando pagamento via cartão de crédito: " + 
                          numeroCartao.substring(numeroCartao.length() - 4) + 
                          " em " + parcelas + " parcela(s)");
        
        // Simulação de autorização da operadora
        boolean autorizado = autorizarTransacao();
        
        if (autorizado) {
            return confirmarPagamento();
        } else {
            cancelarPagamento();
            return false;
        }
    }
    
    private boolean autorizarTransacao() {
        // Simulação de autorização da operadora
        // Em um sistema real, esta verificação seria feita com a integração da operadora
        return Math.random() > 0.05; // 95% de chance de ser autorizado
    }
    
    // Método para calcular valor das parcelas
    public float getValorParcela() {
        return getValor() / parcelas;
    }
    
    // Getters
    public String getNumeroCartao() {
        return numeroCartao;
    }
    
    public String getNomeTitular() {
        return nomeTitular;
    }
    
    public String getValidade() {
        return validade;
    }
    
    public int getParcelas() {
        return parcelas;
    }
}