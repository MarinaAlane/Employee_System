import java.time.LocalDate;
import java.math.BigDecimal;

public class Funcionario extends Pessoa {
  public BigDecimal salario;
  public String funcao;

  public Funcionario(String nome, LocalDate idade, BigDecimal salario, String funcao) {
    super(nome, idade);
    this.salario = salario;
    this.funcao = funcao;
  }
}