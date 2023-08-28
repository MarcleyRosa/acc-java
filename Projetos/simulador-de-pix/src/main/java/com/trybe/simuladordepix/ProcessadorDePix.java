package com.trybe.simuladordepix;

import java.io.IOException;

public class ProcessadorDePix {

  private final Servidor servidor;

  public ProcessadorDePix(Servidor servidor) {
    this.servidor = servidor;
  }

  /**
   * Executa a operação do pix. Aqui é implementada a lógica de negócio sem envolver as interações
   * do aplicativo com a pessoa usuária.
   *
   * @param valor Valor em centavos a ser transferido.
   * @param chave Chave Pix do beneficiário da transação.
   *
   * @throws ErroDePix Erro de aplicação, caso ocorra qualquer inconformidade.
   * @throws IOException Caso aconteça algum problema relacionado à comunicação entre o aplicativo e
   *         o servidor na nuvem.
   */
  public void executarPix(int valor, String chave) throws ErroDePix, IOException,
      ErroValorNaoPositivo, ErroChaveEmBranco, ErroSaldoInsuficiente, ErroChaveNaoEncontrada {

    Conexao conexao = this.servidor.abrirConexao();
    try {
      if (valor <= 0) {
        throw new ErroValorNaoPositivo();
      }
      if (chave.isBlank()) {
        throw new ErroChaveEmBranco();
      }
      String status = conexao.enviarPix(valor, chave);

      if (status.contains(CodigosDeRetorno.SALDO_INSUFICIENTE)) {
        throw new ErroSaldoInsuficiente();
      }
      if (status.contains(CodigosDeRetorno.CHAVE_PIX_NAO_ENCONTRADA)) {
        throw new ErroChaveNaoEncontrada();
      }
      if (!status.contains(CodigosDeRetorno.SUCESSO)) {
        throw new ErroInterno();
      }

    } finally {
      conexao.close();
      System.out.println("Conexão fechada!");
    }
  }
}
