import java.util.Date;

public class GestaoAluguel extends Aluguel{
    private Aluguel aluguel;

    public GestaoAluguel(String id, String prazo, Date dataLocacao, Date dataDevolucao, Livro livro, Aluguel aluguel) {
        super(id, prazo, dataLocacao, dataDevolucao, livro);
        this.aluguel = aluguel;
    }
    public void alugarLivro(String idLivro, String idUsuario) {

    }
    public void devolverLivro(String idLivro, String idUsuario) {

    }
    public void renovarLocacao(String idLivro, String idUsuario) {

    }
    public float multar(String idUsuario, String idLocatario) {
        return 0; // Retornar o novo saldo devedor
    }
    public boolean verificarPrazo(String idLivro){
        return false; // Exemplo: retorna false por padrão
    }

}