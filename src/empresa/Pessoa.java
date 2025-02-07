package empresa;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
  private String nome;
  private LocalDate dataDeNascimento;
  private int idade;

  public Pessoa(String nome, LocalDate dataDeNascimento) {
    this.nome = nome;
    this.dataDeNascimento = dataDeNascimento;
    this.idade = calcularIdade();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(LocalDate dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  private int calcularIdade() {
    LocalDate dataAtual = LocalDate.now();
    Period periodo = Period.between(dataDeNascimento, dataAtual);
    return periodo.getYears();
  }

  @Override
  public String toString() {
    return "Pessoa [nome=" + nome + ", idade=" + idade + ", dataDeNascimento=" + dataDeNascimento + "]";
  }
}
