public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private float valorAluguel;
    
    public Livro(String id, String titulo, String autor, int anoPublicacao, float valorAluguel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.valorAluguel = valorAluguel;
    }
    
    public String getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public float getValorAluguel() {
        return valorAluguel;
    }
}