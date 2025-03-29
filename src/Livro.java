public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    
    public Livro(String id, String titulo, String autor, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
       
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
    
}