package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurmaTest {
    private Turma turma;

    @BeforeEach
    void setUp() throws Exception {
        turma = new Turma();
        Pessoa pessoa = new Pessoa(1, "Julia");
        Pessoa pessoa1 = new Pessoa(2, "Carla");
        turma.adicionarPessoa(pessoa);
        turma.adicionarPessoa(pessoa1);
    }

    @Test
    @DisplayName("Deveria lançar uma exeção devido ao id invalido")
    void testeFalhaPrimeiraCondicao(){
        Pessoa pessoa = new Pessoa(0, "Jana");
        Exception exception = assertThrows(Exception.class, () -> this.turma.adicionarPessoa(pessoa));
        assertEquals(exception.getMessage(),"Objeto pessoa inválido");
    }
    @Test
    @DisplayName("Deveria lançar uma exeção devido ao id repetido")
    void testeFalhaSegundaCondicao(){
        Pessoa pessoa = new Pessoa(1, "Carlos");
        Exception exception = assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoa));
        assertEquals(exception.getMessage(),"Objeto pessoa já está atribuido a turma");
    }
    @Test
    @DisplayName("Deveria adicionar pessoas a lista")
    void testeSucesso() throws Exception {
        int tamanhoDaTurmaAntes = this.turma.getPessoas().size();
        Pessoa pessoa = new Pessoa(4, "Jana");
        turma.adicionarPessoa(pessoa);
        int tamanhoDaTurmaDepois = this.turma.getPessoas().size();
        assertEquals(tamanhoDaTurmaAntes+1,tamanhoDaTurmaDepois);
    }

    @Test
    @DisplayName("Deveria remover todas as pessoas da lista")
    void testeSucessoRemocao(){
        turma.removerTodasPessoas();
        assertTrue(this.turma.getPessoas().isEmpty());
    }
}
