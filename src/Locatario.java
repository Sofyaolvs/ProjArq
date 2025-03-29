public class Locatario extends Usuario {
    private float saldoDevedor;

    public Locatario(String id, String nome, String email, String telefone, float saldoDevedor, float saldoDevedor2) {
        super(id, nome, email, telefone, saldoDevedor);
        this.saldoDevedor = saldoDevedor2;
    }
    
    public float getSaldoDevedor() {
        return saldoDevedor;
    }
    
    @Override
    public boolean verificarInadiplencia() {

        return saldoDevedor > 100;
    }
}