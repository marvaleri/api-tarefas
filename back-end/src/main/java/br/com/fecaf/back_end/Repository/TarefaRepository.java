package br.com.fecaf.back_end.Repository;

import br.com.fecaf.back_end.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
