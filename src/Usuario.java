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
        // Implementar lógica de verificação de inadimplência
        return false; // Exemplo: retorna false por padrão
    }
    // Adicione estes métodos à classe Usuario.java existente
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
