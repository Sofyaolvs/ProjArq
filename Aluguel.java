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
    
}
