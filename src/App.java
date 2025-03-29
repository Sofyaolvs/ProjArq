import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Livro> livros = new ArrayList<>();
    private static List<Aluguel> alugueis = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws Exception {
        int opcao = 0;
        
        while (opcao != 6) {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1. Criar Usuário");
            System.out.println("2. Adicionar Livro");
            System.out.println("3. Remover Livro");
            System.out.println("4. Realizar Aluguel");
            System.out.println("5. Realizar Pagamento");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                
                switch (opcao) {
                    case 1:
                        criarUsuario();
                        break;
                    case 2:
                        adicionarLivro();
                        break;
                    case 3:
                        removerLivro();
                        break;
                    case 4:
                        realizarAluguel();
                        break;
                    case 5:
                        realizarPagamento();
                        break;
                    case 6:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
        
        scanner.close();
    }
    
    private static void criarUsuario() {
        System.out.println("\n===== CRIAR USUÁRIO =====");
        System.out.print("Tipo (1-Locatário, 2-Funcionário): ");
        int tipo = Integer.parseInt(scanner.nextLine());
        
        System.out.print("ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        if (tipo == 1) {
            System.out.print("Saldo Devedor Inicial: ");
            float saldoDevedor = Float.parseFloat(scanner.nextLine());
            
            Locatario locatario = new Locatario(id, nome, email, telefone, saldoDevedor, saldoDevedor);
            usuarios.add(locatario);
            System.out.println("Locatário criado com sucesso!");
        } else if (tipo == 2) {
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();
            
            System.out.print("Salário: ");
            float salario = Float.parseFloat(scanner.nextLine());
            
            Funcionario funcionario = new Funcionario(id, nome, email, telefone, 0, cargo, salario);
            usuarios.add(funcionario);
            System.out.println("Funcionário criado com sucesso!");
        } else {
            System.out.println("Tipo de usuário inválido!");
        }
    }
    
    private static void adicionarLivro() {
        System.out.println("\n===== ADICIONAR LIVRO =====");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Valor de Aluguel: ");
        float valorAluguel = Float.parseFloat(scanner.nextLine());
        
        Livro livro = new Livro(id, titulo, autor, ano, valorAluguel);
        livros.add(livro);
        
        System.out.println("Livro adicionado com sucesso!");
    }
    
    private static void removerLivro() {
        System.out.println("\n===== REMOVER LIVRO =====");
        
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados!");
            return;
        }
        
        // Exibir livros disponíveis
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.println((i+1) + ". " + livro.getTitulo() + " (ID: " + livro.getId() + ")");
        }
        
        System.out.print("Digite o número do livro a remover: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (index >= 0 && index < livros.size()) {
            Livro livroRemovido = livros.remove(index);
            System.out.println("Livro '" + livroRemovido.getTitulo() + "' removido com sucesso!");
        } else {
            System.out.println("Número inválido!");
        }
    }
    
    private static void realizarAluguel() {
        System.out.println("\n===== REALIZAR ALUGUEL =====");
        
        // Verificar se existem locatários
        List<Locatario> locatarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Locatario) {
                locatarios.add((Locatario) usuario);
            }
        }
        
        if (locatarios.isEmpty()) {
            System.out.println("Não há locatários cadastrados!");
            return;
        }
        
        // Verificar se existem livros
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados!");
            return;
        }
        
        // Selecionar locatário
        System.out.println("Locatários disponíveis:");
        for (int i = 0; i < locatarios.size(); i++) {
            Locatario locatario = locatarios.get(i);
            System.out.println((i+1) + ". " + locatario.getNome() + " (ID: " + locatario.getId() + ")");
        }
        
        System.out.print("Escolha o número do locatário: ");
        int locatarioIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (locatarioIndex < 0 || locatarioIndex >= locatarios.size()) {
            System.out.println("Locatário inválido!");
            return;
        }
        
        Locatario locatario = locatarios.get(locatarioIndex);
        
        // Selecionar livro
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            System.out.println((i+1) + ". " + livro.getTitulo() + " (ID: " + livro.getId() + ")");
        }
        
        System.out.print("Escolha o número do livro: ");
        int livroIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (livroIndex < 0 || livroIndex >= livros.size()) {
            System.out.println("Livro inválido!");
            return;
        }
        
        Livro livro = livros.get(livroIndex);
        
        // Informações adicionais do aluguel
        System.out.print("Prazo de devolução (em dias): ");
        String prazo = scanner.nextLine();
        
        System.out.print("Data de locação (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        
        try {
            Date dataLocacao = sdf.parse(dataStr);
            
            // Gerar ID para o aluguel
            String idAluguel = "ALG" + System.currentTimeMillis();
            
            // Criar aluguel
            Aluguel aluguel = new Aluguel(idAluguel, prazo, dataLocacao, null, livro);
            alugueis.add(aluguel);
            
            // Atualizar saldo devedor do locatário
            atualizarSaldoDevedor(locatario, -livro.getValorAluguel());
            
            System.out.println("Aluguel realizado com sucesso!");
            System.out.println("Saldo devedor atualizado: R$" + locatario.getSaldoDevedor());
            
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        }
    }
    
    private static void realizarPagamento() {
        System.out.println("\n===== REALIZAR PAGAMENTO =====");
        
        // Verificar se existem aluguéis pendentes
        if (alugueis.isEmpty()) {
            System.out.println("Não há aluguéis registrados para pagamento!");
            return;
        }
        
        // Listar aluguéis sem pagamento
        System.out.println("Aluguéis disponíveis para pagamento:");
        List<Aluguel> alugueisDisponiveis = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getPagamento() == null) {
                alugueisDisponiveis.add(aluguel);
                System.out.println(alugueisDisponiveis.size() + ". Livro: " + aluguel.getLivro().getTitulo() +
                                  " - Data: " + sdf.format(aluguel.getDataLocacao()) +
                                  " - Prazo: " + aluguel.getPrazo() + " dias");
            }
        }
        
        if (alugueisDisponiveis.isEmpty()) {
            System.out.println("Não há aluguéis pendentes de pagamento!");
            return;
        }
        
        System.out.print("Escolha o número do aluguel para pagamento: ");
        int aluguelIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (aluguelIndex < 0 || aluguelIndex >= alugueisDisponiveis.size()) {
            System.out.println("Aluguel inválido!");
            return;
        }
        
        Aluguel aluguel = alugueisDisponiveis.get(aluguelIndex);
        
        // Buscar o locatário
        Locatario locatario = null;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Locatario) {
                locatario = (Locatario) usuario;
                break;
            }
        }
        
        if (locatario == null) {
            System.out.println("Erro: Não foi possível encontrar o locatário!");
            return;
        }
        
        System.out.print("Valor do pagamento: R$");
        float valor = Float.parseFloat(scanner.nextLine());
        
        if (valor <= 0) {
            System.out.println("Valor deve ser maior que zero!");
            return;
        }
        
        System.out.print("Data do pagamento (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        
        try {
            Date dataPagamento = sdf.parse(dataStr);
            
            // Gerar ID para o pagamento
            String idPagamento = "PAG" + System.currentTimeMillis();
            
            // Criar pagamento
            Pagamento pagamento = new Pagamento(idPagamento, valor, dataPagamento, locatario);
            
            // Associar pagamento ao aluguel
            for (int i = 0; i < alugueis.size(); i++) {
                if (alugueis.get(i).getId().equals(aluguel.getId())) {
                    alugueis.get(i).setPagamento(pagamento);
                    break;
                }
            }
            
            // Atualizar saldo devedor
            atualizarSaldoDevedor(locatario, valor);
            
            System.out.println("Pagamento realizado com sucesso!");
            System.out.println("Novo saldo devedor: R$" + locatario.getSaldoDevedor());
            
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        }
    }
    
    private static void atualizarSaldoDevedor(Locatario locatario, float valor) {
        // Valor positivo = pagamento (diminui saldo)
        // Valor negativo = aluguel (aumenta saldo)
        float novoSaldo = locatario.getSaldoDevedor() - valor;
        if (novoSaldo < 0) {
            novoSaldo = 0;
        }
        
        // Atualizar o objeto Locatario na lista
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(locatario.getId())) {
                usuarios.set(i, new Locatario(
                    locatario.getId(),
                    locatario.getNome(),
                    locatario.getEmail(),
                    locatario.getTelefone(),
                    novoSaldo,
                    novoSaldo
                ));
                break;
            }
        }
    }
}