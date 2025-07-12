package br.com.fecaf.back_end.Controller;

import br.com.fecaf.back_end.Model.Tarefa;
import br.com.fecaf.back_end.Services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/listarTarefas")
    public List<Tarefa> listarTarefas() { return tarefaService.listarTarefas(); }

}
