package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public static void main(String[] args) throws IOException {
    File pastaDeEntradas = new File("./entradas/");
    File pastaDeSaidas = new File("./saidas/");
    new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
  }

  /**
   * formata arquivo csv.
   * 
   * @param linha recebi a linha do arquivo.
   */
  public String formated(String linha) {
    String[] colunas = linha.split(",");

    if (linha.contains("Nome completo,Data de nascimento,Email,CPF")) {
      return linha + "\n";
    } else {

      String nome = colunas[0].toUpperCase();
      String[] formatData = colunas[1].split("/");
      String data = formatData[2] + "-" + formatData[1] + "-" + formatData[0];
      String email = colunas[2];
      String replCpf = colunas[3].replaceAll("\\D", "");
      String cpf = String.format("%s.%s.%s-%s", replCpf.substring(0, 3), replCpf.substring(3, 6),
          replCpf.substring(6, 9), replCpf.substring(9, 11));

      return nome + "," + data + "," + email + "," + cpf + "\n";
    }


  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados na pasta de
   * saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas Pasta em que serão colocados os arquivos gerados no formato requerido pelo
   *        subsistema.
   *
   * @throws IOException Caso ocorra algum problema ao ler os arquivos de entrada ou gravar os
   *         arquivos de saída.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {

    if (pastaDeEntradas.isDirectory() && pastaDeEntradas.canRead()) {
      pastaDeSaidas.mkdir();
      for (File f : pastaDeEntradas.listFiles()) {
        FileReader leitorFile = new FileReader(f);
        BufferedReader bufferLeitor = new BufferedReader(leitorFile);
        File arquivoSaida = new File(pastaDeSaidas.getPath() + File.separator + f.getName());
        arquivoSaida.createNewFile();

        String linha;

        FileWriter escritorArquivo = new FileWriter(arquivoSaida);
        BufferedWriter bufferEscritor = new BufferedWriter(escritorArquivo);

        while ((linha = bufferLeitor.readLine()) != null) {

          bufferEscritor.write(this.formated(linha));

          System.out.println(this.formated(linha));

          bufferEscritor.flush();
        }
        escritorArquivo.close();
        bufferEscritor.close();
        leitorFile.close();
        bufferLeitor.close();
      }
    }
  }
}
