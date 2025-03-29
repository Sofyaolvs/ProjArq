public class Estoque extends Livro {
    private Livro[] livro;

    public Estoque(String id, String titulo, String autor, int anoPublicacao, float valorAluguel, Livro[] livro) {
        super(id, titulo, autor, anoPublicacao, valorAluguel);
        this.livro = livro;
    }
    public void adicionarLivro(Livro novoLivro) {
    }
    public void removerLivro(String idLivro) {
    }
}