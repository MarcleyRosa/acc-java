package com.trybe.gerarpessoausuaria;

public class Usuario extends Pessoa {



  /**
   * Novo usuario.
   * 
   * @param nome recebi nome.
   * @param sobrenome recebi sobrenome.
   */
  public Usuario(String nome, String sobrenome) {
    super(nome, sobrenome);
    // TODO Auto-generated constructor stub
  }

  /**
   * Método para pegar o nome e sobrenome do usuário.
   *
   */
  public String getUsuario() {
    if (this.nome == null || this.nome.isBlank() || this.sobrenome == null
        || this.sobrenome.isBlank()) {
      return "Usuário inválido";
    }
    return this.nome + "." + this.sobrenome;
  }
}
