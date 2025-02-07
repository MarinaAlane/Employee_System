package empresa;

import java.math.BigDecimal;

public class Funcionario extends Pessoa {
  private BigDecimal salario;
  private String funcao;
  private Pessoa pessoa;

  public Funcionario(Pessoa pessoa, BigDecimal salario, String funcao) {
    super(pessoa.getNome(), pessoa.getDataDeNascimento());
    this.pessoa = pessoa;
    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public void setSalario(BigDecimal salario) {
    this.salario = salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  @Override
  public String toString() {
    return "Funcionario [pessoa=" + super.toString() + ", salario=" + salario + ", funcao=" + funcao + "]";
  }
}
