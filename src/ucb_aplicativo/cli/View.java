package ucb_aplicativo.cli;
import ucb_aplicativo.control.TarefaService;
import ucb_aplicativo.model.Tarefa;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {

        TarefaService servico = new TarefaService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== To Do List =====");
            System.out.println("1. Criar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Pesquisar tarefa");
            System.out.println("4. Atualizar tarefa");
            System.out.println("5. Remover tarefa");
            System.out.println("6. Marcar como concluída");
            System.out.println("7. Listar tarefas concluídas");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();


          switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    Tarefa nova = servico.criar(titulo, descricao);
                    System.out.println("Tarefa criada com sucesso: " + nova.getTitulo());
                }

                case 2 -> {
                    List<Tarefa> tarefas = servico.listar();
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println();
                        System.out.println("Lista de Tarefas:");
                        for (Tarefa tarefa : tarefas) {
                            System.out.println("ID: " + tarefa.getId());
                            System.out.println("Título: " + tarefa.getTitulo());
                            System.out.println("Descrição: " + tarefa.getDescricao());
                            System.out.println("Data de criação: " + tarefa.getDataAgora());
                            System.out.println("------------------------\n");
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Digite o id da tarefa para pesquisar: ");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    Tarefa tarefaProcurada = servico.pesquisar(id);
                    if (tarefaProcurada != null) {
                        System.out.println("--- Tarefa Encontrada ---");
                        System.out.println("ID: " + tarefaProcurada.getId());
                        System.out.println("Título: " + tarefaProcurada.getTitulo());
                        System.out.println("Descrição: " + tarefaProcurada.getDescricao());
                        System.out.println("Completa: " + (tarefaProcurada.isCompleta() ? "Sim" : "Não"));
                        System.out.println("------------------------\n");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                }
                
                case 4 -> {
                    System.out.print("Digite o id da tarefa para atualizar: ");
                    Long idAtualizar = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Novo Título: ");
                    String novoTitulo = sc.nextLine();
                    System.out.print("Nova Descrição: ");
                    String novaDescricao = sc.nextLine();
                    if(servico.atualizar(idAtualizar, novoTitulo, novaDescricao)) {
                        System.out.println("Tarefa atualizada com sucesso.");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                }