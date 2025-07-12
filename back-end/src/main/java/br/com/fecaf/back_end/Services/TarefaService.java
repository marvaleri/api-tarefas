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


}
