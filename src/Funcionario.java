public class Funcionario extends Usuario{
    private String cargo;
    private float salario;
    
    public Funcionario(String id, String nome, String email, String telefone, float saldoDevedor, String cargo,
            float salario) {
        super(id, nome, email, telefone, saldoDevedor);
        this.cargo = cargo;
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }
// Adicione este método à classe Funcionario.java existente
    public String getCargo() {
        return cargo;
    }
}
