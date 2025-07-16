const cardContainer = document.getElementById('cardContainer');

let tarefas = [];

async function loadCards() {
    try {
        const response = await fetch('http://localhost:8080/api/tarefas/listarTarefas');
        tarefas = await response.json();
        renderCards();
    } catch (error) {
        console.error('Error ao carregar tarefas:', error);
    }
}

function renderCards() {
    cardContainer.innerHTML = '';
    tarefas.forEach((tarefa) => {
        console.log(tarefa);

        const card = document.createElement('div');
        card.className = 'card';

        const titulo = document.createElement('h3');
        titulo.textContent = tarefa.titulo;
        card.appendChild(titulo);

        const prioridade = document.createElement('p')
        prioridade.textContent = `Prioridade: ${tarefa.prioridade}`;
        card.appendChild(prioridade);

        const descricao = document.createElement('p');
        descricao.textContent = `Descricao: ${tarefa.descricao}`;
        card.appendChild(descricao);

        const editButton = document.createElement('button');
        editButton.textContent = 'Editar';
        editButton.onclick = () => editarTarefa(tarefa);
        card.appendChild(editButton);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Deletar';
        deleteButton.onclick = () => deletarTarefa(tarefa.id);
        card.appendChild(deleteButton);

        cardContainer.appendChild(card);
    });
}

async function adicionarTarefa() {
    const titulo = document.getElementById('tituloInput').value;
    const prioridade = document.getElementById('prioridadeInput').value;
    const descricao = document.getElementById('descricaoInput').value;

    if (titulo && prioridade && descricao) {
        const novaTarefa = {
            titulo: titulo,
            prioridade: prioridade,
            descricao: descricao
        };

        try {
            const response = await fetch('http://localhost:8080/api/tarefas/cadastrarTarefa', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(novaTarefa),
            });

            if (response.ok) {
                loadCards();
                clearForm();
            } else {
                console.error('Erro ao cadastrar tarefa:', await response.text());
            }
        } catch (error) {
            console.error('Erro ao cadastrar tarefa:', error);
        }
    } else {
        alert('Por favor, preencha todos os campos.');
    }
}

async function editarTarefa(tarefa) {
    document.getElementById('tituloInput').value = tarefa.titulo;
    document.getElementById('prioridadeInput').value = tarefa.prioridade;
    document.getElementById('descricaoInput').value = tarefa.descricao;

    const addButton = document.querySelector('.form-container button');
    addButton.textContent = 'Salvar Alterações';
    addButton.onclick = () => saveEdit(tarefa.id);
}

async function saveEdit(id) {
    const titulo = document.getElementById('tituloInput').value;
    const prioridade = document.getElementById('prioridadeInput').value;
    const descricao = document.getElementById('descricaoInput').value;

    const updateTarefa = {
        titulo: titulo,
        prioridade: prioridade,
        descricao: descricao
    };

    try {
        const response = await fetch(`http://localhost:8080/api/tarefas/atualizarTarefa/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(updateTarefa),
        });

        if (response.ok) {
            loadCards();
            clearForm();
            const addButton = document.querySelector('.form-container button');
            addButton.textContent = 'Adicionar Tarefa';
            addButton.onclick = adicionarTarefa;
        } else {
            console.error('Erro ao editar tarefa:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao editar tarefa:', error);
    }
}

async function deletarTarefa(id) {
    try {
        const response = await fetch(`http://localhost:8080/api/tarefas/deletarTarefa/${id}`, {
            method: 'DELETE',
        });

        if (response.ok) {
            loadCards();
        } else {
            console.error('Erro ao deletar tarefa:', await response.text());
        }
    } catch (error) {
        console.error('Erro ao deletar tarefa:', error);
    }
}

function clearForm() {
    document.getElementById('tituloInput').value = '';
    document.getElementById('prioridadeInput').value = '';
    document.getElementById('descricaoInput').value = '';
}

loadCards();