package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Gerencia os votos.
 */
public class GerenciamentoVotacao {

  ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  ArrayList<String> cpfComputado = new ArrayList<String>();
  int totalVotos = 0;

  /**
   * cadastra um candidato.
   * 
   * @param nome recebi um nome.
   * @param numero recebi um numero de cadidato.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {

    boolean find = false;
    for (PessoaCandidata pessoa : this.pessoasCandidatas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        find = true;
        break;
      }
    }
    if (!find) {
      PessoaCandidata candidato = new PessoaCandidata(nome, numero);
      this.pessoasCandidatas.add(candidato);
    }
  }

  /**
   * PessoaCandidata candidato = new PessoaCandidata(nome, numero);
   * this.pessoasCandidatas.add(candidato); Cadastra um eleitor.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean find = false;
    for (PessoaEleitora pessoa : this.pessoasEleitoras) {
      if (pessoa.getCpf().contentEquals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        find = true;
        break;
      }
    }
    if (!find) {
      PessoaEleitora eleitor = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(eleitor);
    }

  }

  /**
   * Realiza da votação.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    boolean find = false;
    for (String pessoa : this.cpfComputado) {
      if (pessoa.contentEquals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        find = true;
        break;
      }
    }
    if (!find) {
      for (PessoaCandidata pessoa : this.pessoasCandidatas) {
        if (pessoa.getNumero() == numeroPessoaCandidata) {
          pessoa.receberVoto();
          this.totalVotos += 1;
          this.cpfComputado.add(cpfPessoaEleitora);
          break;
        }
      }
    }

  }

  /**
   * mostra o resultado parcial da eleição.
   */
  public void mostrarResultado() {
    if (cpfComputado.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      String result = "";
      for (PessoaCandidata pessoa : this.pessoasCandidatas) {
        result += "Nome: " + pessoa.getNome() + " - " + pessoa.getVotos() + " Votos ( "
            + this.calcularPorcentagemVotos(pessoa.getVotos()) + "% )\nTotal de votos: "
            + this.totalVotos;
      }
      System.out.println(result);
    }
  }

  private double calcularPorcentagemVotos(int index) {
    return (index * 100) / this.totalVotos;
  }
}
