public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    

    public Usuario(String id, String nome, String email, String telefone, float saldoDevedor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }


    public boolean verificarInadiplencia() {
        return false; 
    }
    
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }


    public String getId() {
        return id;
    }
    
    
}
