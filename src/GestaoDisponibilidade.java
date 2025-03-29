public class GestaoDisponibilidade extends Livro{
    private Livro livro;

    
    public GestaoDisponibilidade(String id, String titulo, String autor, int anoPublicacao, float valorAluguel,
            Livro livro) {
        super(id, titulo, autor, anoPublicacao, valorAluguel);
        this.livro = livro;
    }
    public boolean verificarDisponibilidade(String idLivro){
        return true;
    }
    public void marcarComoIndisponivel(String idLivro){
        // Implementar lógica para marcar o livro como indisponível
    }
    public void marcarComoDisponivel(String idLivro){
        // Implementar lógica para marcar o livro como disponível
    }
}