package br.com.fecaf.back_end.Services;

import br.com.fecaf.back_end.Model.Tarefa;
import br.com.fecaf.back_end.Repository.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarTarefa() {
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setTitulo("Nova Tarefa");
        novaTarefa.setDescricao("Descrição da nova tarefa");
        novaTarefa.setPrioridade("Alta");

        when(tarefaRepository.save(novaTarefa)).thenReturn(novaTarefa);

        Tarefa tarefaSalva = tarefaService.salvarTarefa(novaTarefa);

        assertNotNull(tarefaSalva);
        assertEquals("Nova Tarefa", tarefaSalva.getTitulo());
        assertEquals("Descrição da nova tarefa", tarefaSalva.getDescricao());
        assertEquals("Alta", tarefaSalva.getPrioridade());

        verify(tarefaRepository, times(1)).save(novaTarefa);
    }
}

