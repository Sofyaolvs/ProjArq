import java.util.Date;

public class Aluguel {
    private Pagamento pagamento;
    private String id;
    private String prazo;
    private Date dataLocacao;
    private Date dataDevolucao;
    private Livro livro;
    public Aluguel(String id, String prazo, Date dataLocacao, Date dataDevolucao, Livro livro) {
        this.id = id;
        this.prazo = prazo;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
    }    
    
    public String getId() {
        return id;
    }
    
    public String getPrazo() {
        return prazo;
    }
    
    public Date getDataLocacao() {
        return dataLocacao;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
