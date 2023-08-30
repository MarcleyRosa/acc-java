package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(500, "Depósito recebido");

    assertEquals(transacao.getDescricao(), "Depósito recebido");
    assertEquals(transacao.getQuantia(), 500);

  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(500, "Depósito recebido");

    assertEquals(transacao.getQuantia(), 500);
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Banco banco = new Banco();
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    Conta contaCorrente = new Conta("Corrente", client, banco);

    Transacao transacao = new Transacao(500, "Depósito recebido");
    client.adicionarConta(contaCorrente);
    banco.adicionarConta("Corrente", client);

    banco.depositar(client, 0, 200);

    String resumo = " -------- " + transacao.getDescricao() + ": " + "R$ 500.00 +";

    assertTrue(transacao.retornarResumoTransacao().contains(resumo));

  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(500, "Depósito recebido");

    LocalDateTime instante = LocalDateTime.now();
    DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String momentoFormatado = instante.format(formatoBrasileiro);

    assertEquals(transacao.retornarInstante(), momentoFormatado);

  }

}
