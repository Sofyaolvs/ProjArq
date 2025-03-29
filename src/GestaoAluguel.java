import java.util.Date;

public class GestaoAluguel{
    private Aluguel aluguel;

    public GestaoAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    
    public void alugarLivro(String idLivro, String idUsuario) {

    }
    public void devolverLivro(String idLivro, String idUsuario) {

    }
    public void renovarLocacao(String idLivro, String idUsuario) {

    }
    public float multar(String idUsuario, String idLocatario) {
        return 0; 
    }
    public boolean verificarPrazo(String idLivro){
        return false; 
    }

}