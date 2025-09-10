package ucb_aplicativo.control;
import ucb_aplicativo.model.Tarefa;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {
    private List<Tarefa> tarefas = new ArrayList<>();
    private Long id = 1L;

    public Tarefa criar(String titulo, String descricao) {
        Tarefa novaTarefa = new Tarefa(id++, titulo, descricao, false);
        tarefas.add(novaTarefa);
        return novaTarefa;
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public boolean atualizar(Long id, String novoTitulo, String novaDescricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefa.setTitulo(novoTitulo);
                tarefa.setDescricao(novaDescricao);
                return true;
            }
        }
        return false;
    }

    public boolean remover(Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefas.remove(tarefa);
                return true;
            }
        }
        return false;
    }

    public boolean marcar(Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefa.setCompleta(true);
                return true;
            }
        }
        return false;
    }

    public Tarefa pesquisar(Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                return tarefa;
            }
        }
        return null;
    }

    public List<Tarefa> listarCompletas() {
        List<Tarefa> tarefasCompletas = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.isCompleta() == true) {
                tarefasCompletas.add(tarefa);
            }
        }
        return tarefasCompletas;
    }
}