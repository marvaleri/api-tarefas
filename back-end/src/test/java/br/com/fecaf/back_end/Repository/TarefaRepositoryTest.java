package br.com.fecaf.back_end.Repository;

import br.com.fecaf.back_end.Model.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")  // usa application-test.properties (H2)
public class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Test
    void deveSalvarETrazerTarefa() {
        // cria nova tarefa
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Testar Spring Data JPA");
        tarefa.setDescricao("Persistir dados com H2 em memória");
        tarefa.setPrioridade("Alta");

        // salva no banco (H2 em memória)
        tarefaRepository.save(tarefa);

        // busca todas tarefas salvas
        List<Tarefa> tarefas = tarefaRepository.findAll();

        // verifica se retornou pelo menos uma tarefa e se o título bate
        assertThat(tarefas).isNotEmpty();
        assertThat(tarefas.get(0).getTitulo()).isEqualTo("Testar Spring Data JPA");
    }
}
