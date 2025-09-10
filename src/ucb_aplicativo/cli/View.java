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