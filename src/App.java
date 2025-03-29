import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Livro> livros = new ArrayList<>();
    private static List<Aluguel> alugueis = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final float MULTA_POR_DIA = 2.0f;

    public static void main(String[] args) throws Exception {
        int opcao = 0;
        
        while (opcao != 8) {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1. Criar Usuário");
            System.out.println("2. Remover Usuário");
            System.out.println("3. Adicionar Livro");
            System.out.println("4. Remover Livro");
            System.out.println("5. Realizar Aluguel");
            System.out.println("6. Devolver Livro");
            System.out.println("7. Realizar Pagamento");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                
                switch (opcao) {
                    case 1:
                        criarUsuario();
                        break;
                    case 2:
                        removerUsuario();
                        break;
                    case 3:
                        adicionarLivro();
                        break;
                    case 4:
                        removerLivro();
                        break;
                    case 5:
                        realizarAluguel();
                        break;
                    case 6:
                        devolverLivro();
                        break;
                    case 7:
                        realizarPagamento();
                        break;
                    case 8:
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
    
    private static void removerUsuario() {
        System.out.println("\n===== REMOVER USUÁRIO =====");
        
        if (usuarios.isEmpty()) {
            System.out.println("Não há usuários cadastrados!");
            return;
        }
        
        System.out.println("Usuários disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            String tipo = usuario instanceof Locatario ? "Locatário" : "Funcionário";
            System.out.println((i+1) + ". " + usuario.getNome() + " (" + tipo + " - ID: " + usuario.getId() + ")");
        }
        
        System.out.print("Digite o número do usuário a remover: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (index >= 0 && index < usuarios.size()) {
            Usuario usuarioRemovido = usuarios.get(index);
            

            if (usuarioRemovido instanceof Locatario) {
                boolean temAluguelPendente = false;
                for (Aluguel aluguel : alugueis) {
                    if (aluguel.getDataDevolucao() == null) {
                        temAluguelPendente = true;
                        break;
                    }
                }
                
                if (temAluguelPendente) {
                    System.out.println("Este locatário possui aluguéis pendentes. Não é possível removê-lo.");
                    return;
                }
                
                Locatario locatario = (Locatario) usuarioRemovido;
                if (locatario.getSaldoDevedor() > 0) {
                    System.out.println("Este locatário possui saldo devedor de R$" + locatario.getSaldoDevedor() + ". Não é possível removê-lo.");
                    return;
                }
            }
            
            usuarios.remove(index);
            System.out.println("Usuário '" + usuarioRemovido.getNome() + "' removido com sucesso!");
        } else {
            System.out.println("Número inválido!");
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
        
        Livro livro = new Livro(id, titulo, autor, ano);
        livros.add(livro);
        
        System.out.println("Livro adicionado com sucesso!");
    }
    
    private static void removerLivro() {
        System.out.println("\n===== REMOVER LIVRO =====");
        
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados!");
            return;
        }
        
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            String disponibilidade = livro.isDisponivel() ? "Disponível" : "Indisponível";
            System.out.println((i+1) + ". " + livro.getTitulo() + " (ID: " + livro.getId() + ") - " + disponibilidade);
        }
        
        System.out.print("Digite o número do livro a remover: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (index >= 0 && index < livros.size()) {
            Livro livroRemovido = livros.get(index);

            boolean livroEmUso = false;
            for (Aluguel aluguel : alugueis) {
                if (aluguel.getLivro().getId().equals(livroRemovido.getId()) && aluguel.getDataDevolucao() == null) {
                    livroEmUso = true;
                    break;
                }
            }
            
            if (livroEmUso) {
                System.out.println("Este livro está atualmente alugado. Não é possível removê-lo.");
                return;
            }
            
            livros.remove(index);
            System.out.println("Livro '" + livroRemovido.getTitulo() + "' removido com sucesso!");
        } else {
            System.out.println("Número inválido!");
        }
    }
    
    private static void realizarAluguel() {
        System.out.println("\n===== REALIZAR ALUGUEL =====");
        
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

        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        
        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Não há livros disponíveis para aluguel!");
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

        System.out.println("Livros disponíveis para aluguel:");
        for (int i = 0; i < livrosDisponiveis.size(); i++) {
            Livro livro = livrosDisponiveis.get(i);
            System.out.println((i+1) + ". " + livro.getTitulo() + " (ID: " + livro.getId() + ")");
        }
        
        System.out.print("Escolha o número do livro: ");
        int livroIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (livroIndex < 0 || livroIndex >= livrosDisponiveis.size()) {
            System.out.println("Livro inválido!");
            return;
        }
        
        Livro livro = livrosDisponiveis.get(livroIndex);

        System.out.print("Prazo de devolução (em dias): ");
        String prazo = scanner.nextLine();
        
        System.out.print("Data de locação (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        
        try {
            Date dataLocacao = sdf.parse(dataStr);
            
            String idAluguel = "ALG" + System.currentTimeMillis();
            
            Aluguel aluguel = new Aluguel(idAluguel, prazo, dataLocacao, null, livro);
            alugueis.add(aluguel);

            for (int i = 0; i < livros.size(); i++) {
                if (livros.get(i).getId().equals(livro.getId())) {
                    livros.get(i).setDisponivel(false);
                    break;
                }
            }
            
            System.out.println("Aluguel realizado com sucesso!");
            System.out.println("Livro '" + livro.getTitulo() + "' marcado como indisponível.");
            System.out.println("Saldo devedor atualizado: R$" + locatario.getSaldoDevedor());
            
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        }
    }
    
    private static void devolverLivro() {
        System.out.println("\n===== DEVOLVER LIVRO =====");

        List<Aluguel> aluguelPendentes = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getDataDevolucao() == null) {
                aluguelPendentes.add(aluguel);
            }
        }
        
        if (aluguelPendentes.isEmpty()) {
            System.out.println("Não há livros pendentes de devolução!");
            return;
        }
        
        System.out.println("Livros pendentes de devolução:");
        for (int i = 0; i < aluguelPendentes.size(); i++) {
            Aluguel aluguel = aluguelPendentes.get(i);
            System.out.println((i+1) + ". " + aluguel.getLivro().getTitulo() + 
                               " (Alugado em: " + sdf.format(aluguel.getDataLocacao()) + 
                               ", Prazo: " + aluguel.getPrazo() + " dias)");
        }
        
        System.out.print("Escolha o número do livro a devolver: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (index < 0 || index >= aluguelPendentes.size()) {
            System.out.println("Número inválido!");
            return;
        }
        
        Aluguel aluguel = aluguelPendentes.get(index);
        
        System.out.print("Data de devolução (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        
        try {
            Date dataDevolucao = sdf.parse(dataStr);

            long diffEmMilissegundos = dataDevolucao.getTime() - aluguel.getDataLocacao().getTime();
            long diffEmDias = TimeUnit.DAYS.convert(diffEmMilissegundos, TimeUnit.MILLISECONDS);
            int prazoEmDias = Integer.parseInt(aluguel.getPrazo());

            for (int i = 0; i < alugueis.size(); i++) {
                if (alugueis.get(i).getId().equals(aluguel.getId())) {
                    alugueis.get(i).setDataDevolucao(dataDevolucao);
                    break;
                }
            }
        
            for (int i = 0; i < livros.size(); i++) {
                if (livros.get(i).getId().equals(aluguel.getLivro().getId())) {
                    livros.get(i).setDisponivel(true);
                    break;
                }
            }
            
            System.out.println("Livro '" + aluguel.getLivro().getTitulo() + "' devolvido com sucesso!");
            System.out.println("Livro marcado como disponível novamente.");
            
            if (diffEmDias > prazoEmDias) {
                long diasAtraso = diffEmDias - prazoEmDias;
                float valorMulta = diasAtraso * MULTA_POR_DIA;
                
                System.out.println("ATENÇÃO: Prazo excedido em " + diasAtraso + " dias!");
                System.out.println("Valor da multa: R$" + valorMulta);
                
                for (Usuario usuario : usuarios) {
                    if (usuario instanceof Locatario) {
                        Locatario locatario = (Locatario) usuario;
                    
                        float novoSaldo = locatario.getSaldoDevedor() + valorMulta;
                        atualizarSaldoDevedor(locatario, -valorMulta);
                        
                        System.out.println("Saldo devedor atual do locatário " + locatario.getNome() + ": R$" + novoSaldo);
                        break;
                    }
                }
            } else {
                System.out.println("Livro devolvido dentro do prazo!");
            }
            
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        } catch (NumberFormatException e) {
            System.out.println("Prazo inválido!");
        }
    }
    
    private static void realizarPagamento() {
        System.out.println("\n===== REALIZAR PAGAMENTO =====");

        if (alugueis.isEmpty()) {
            System.out.println("Não há aluguéis registrados para pagamento!");
            return;
        }

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

            String idPagamento = "PAG" + System.currentTimeMillis();

            Pagamento pagamento = new Pagamento(idPagamento, valor, dataPagamento, locatario);

            for (int i = 0; i < alugueis.size(); i++) {
                if (alugueis.get(i).getId().equals(aluguel.getId())) {
                    alugueis.get(i).setPagamento(pagamento);
                    break;
                }
            }

            atualizarSaldoDevedor(locatario, valor);
            
            System.out.println("Pagamento realizado com sucesso!");
            System.out.println("Novo saldo devedor: R$" + locatario.getSaldoDevedor());
            
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        }
    }
    
    private static void atualizarSaldoDevedor(Locatario locatario, float valor) {
        float novoSaldo = locatario.getSaldoDevedor() - valor;
        if (novoSaldo < 0) {
            novoSaldo = 0;
        }

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