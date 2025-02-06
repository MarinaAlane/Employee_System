import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
  public String nome;
  public LocalDate dataDeNascimento;
  public int idade;

  public Pessoa(String nome, LocalDate dataDeNascimento) {
    this.nome = nome;
    this.dataDeNascimento = dataDeNascimento;
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
    LocalDate dataAtual = LocalDate.now();
    Period periodo = Period.between(dataDeNascimento, dataAtual);
    idade = periodo.getYears();

    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }
}
