package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    @DisplayName("Deveria retornar true quando o id for maior que zero e o nome não for vazio")
    void testeSucesso(){
        Pessoa pessoa = new Pessoa(1, "Ana");
        boolean valido = pessoa.valido();
        Assertions.assertTrue(valido);
    }
    @Test
    @DisplayName("Deveria retornar false quando o id for menor/igual a zero e o nome não for vazio")
    void testeFalhaUmaCondicao(){
        Pessoa pessoa = new Pessoa(0, "Ana");
        Pessoa pessoa1 = new Pessoa(-5,"Ana");

        boolean valido1 = pessoa1.valido();
        boolean valido = pessoa.valido();

        Assertions.assertFalse(valido);
        Assertions.assertFalse(valido1);
    }
    @Test
    @DisplayName("Deveria retornar false quando o id for maior que zero e o nome for vazio")
    void testeFalhaSegundaCondicao(){
        Pessoa pessoa = new Pessoa(1, "");

        boolean valido = pessoa.valido();

        Assertions.assertFalse(valido);
    }
    @Test
    @DisplayName("Deveria retornar false uando o id for menor/igual a zero e o nome for vazio")
    void testeFalhaDuasCondicao(){
        Pessoa pessoa = new Pessoa(0, "");

        boolean valido = pessoa.valido();

        Assertions.assertFalse(valido);
    }
}
