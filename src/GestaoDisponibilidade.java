public class GestaoDisponibilidade{
    private Livro livro;

    
    public GestaoDisponibilidade(Livro livro) {
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