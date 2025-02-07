package empresa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
  public static void main(String[] args) {
    List<Funcionario> funcionarios = new ArrayList<>();

    Pessoa pessoaMaria = new Pessoa("Maria", LocalDate.of(2000, 10, 18));
    Funcionario funcionariaMaria = new Funcionario(pessoaMaria, new BigDecimal("2009.44"), "Operador");
    funcionarios.add(funcionariaMaria);

    Pessoa pessoaJoao = new Pessoa("João", LocalDate.of(1990, 05, 12));
    Funcionario funcionarioJoao = new Funcionario(pessoaJoao, new BigDecimal("2284.38"), "Operador");
    funcionarios.add(funcionarioJoao);

    Pessoa pessoaCaio = new Pessoa("Caio", LocalDate.of(1961, 05, 02));
    Funcionario funcionarioCaio = new Funcionario(pessoaCaio, new BigDecimal("9836.14"), "Coordenador");
    funcionarios.add(funcionarioCaio);

    Pessoa pessoaMiguel = new Pessoa("Miguel", LocalDate.of(1988, 10, 14));
    Funcionario funcionarioMiguel = new Funcionario(pessoaMiguel, new BigDecimal("19119.88"), "Diretor");
    funcionarios.add(funcionarioMiguel);

    Pessoa pessoaHeitor = new Pessoa("Heitor", LocalDate.of(1999, 11, 19));
    Funcionario funcionarioHeitor = new Funcionario(pessoaHeitor, new BigDecimal("1582.72"), "Operador");
    funcionarios.add(funcionarioHeitor);

    Pessoa pessoaAlice = new Pessoa("Alice", LocalDate.of(1995, 01, 05));
    Funcionario funcionariaAlice = new Funcionario(pessoaAlice, new BigDecimal("9836.14"), "Recepcionista");
    funcionarios.add(funcionariaAlice);

    Pessoa pessoaArthur = new Pessoa("Arthur", LocalDate.of(1993, 03, 31));
    Funcionario funcionarioArthur = new Funcionario(pessoaArthur, new BigDecimal("4071.84"), "Contador");
    funcionarios.add(funcionarioArthur);

    Pessoa pessoaLaura = new Pessoa("Laura", LocalDate.of(1994, 07, 8));
    Funcionario funcionariaLaura = new Funcionario(pessoaLaura, new BigDecimal("3017.45"), "Gerente");
    funcionarios.add(funcionariaLaura);

    Pessoa pessoaHeloísa = new Pessoa("Heloísa", LocalDate.of(2003, 05, 24));
    Funcionario funcionariaHeloísa = new Funcionario(pessoaHeloísa, new BigDecimal("1606.85"), "Eletricista");
    funcionarios.add(funcionariaHeloísa);

    Pessoa pessoaHelena = new Pessoa("Helena", LocalDate.of(1996, 9, 02));
    Funcionario funcionariaHelena = new Funcionario(pessoaHelena, new BigDecimal("2799.93"), "Gerente");
    funcionarios.add(funcionariaHelena);

    System.out.println("Lista de Funcionários:");
    for (Funcionario funcionario : funcionarios) {
      System.out.println(funcionario);
    }

    funcionarios.removeIf(funcionario -> funcionario.getPessoa().getNome().equals("João"));

    System.out.println("Lista de Funcionários após a exclusão:");
    for (Funcionario funcionario : funcionarios) {
      System.out.println(funcionario);
    }
  }
}
