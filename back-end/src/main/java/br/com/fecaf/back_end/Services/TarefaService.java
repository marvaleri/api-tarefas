package br.com.fecaf.back_end.Services;

import br.com.fecaf.back_end.Model.Tarefa;
import br.com.fecaf.back_end.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    //Listar
    public List<Tarefa> listarTarefas() { return tarefaRepository.findAll(); }

    //Criar
    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    //Deletar
    public void deletarTarefa (int id) {
        tarefaRepository.deleteById(id);
    }

    //Atualizar
    public Tarefa atualizarTarefa (int id, Tarefa tarefaDetails) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrado"));

        tarefa.setTitulo(tarefaDetails.getTitulo());
        tarefa.setPrioridade(tarefaDetails.getPrioridade());
        tarefa.setDescricao(tarefaDetails.getDescricao());

        return tarefaRepository.save(tarefa);
    }
}
