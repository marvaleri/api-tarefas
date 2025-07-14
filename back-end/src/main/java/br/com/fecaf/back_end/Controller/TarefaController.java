package br.com.fecaf.back_end.Controller;

import br.com.fecaf.back_end.Model.Tarefa;
import br.com.fecaf.back_end.Services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/listarTarefas")
    public List<Tarefa> listarTarefas() { return tarefaService.listarTarefas(); }

    @PostMapping("/cadastrarTarefa")
    public ResponseEntity<Tarefa> salvarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa newTarefa = tarefaService.salvarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTarefa);
    }

    @DeleteMapping("/deletarTarefa/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable int id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/atualizarTarefa/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable int id, @RequestBody Tarefa tarefaDetails) {
        try {
            Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaDetails);
            return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
