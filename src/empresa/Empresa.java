package empresa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Empresa {
  private static List<Pessoa> pessoas = new ArrayList<>();

  private static List<Funcionario> funcionarios = new ArrayList<>();

  private static void addPessoa(String nome, LocalDate dataDeNascimento) {
    Pessoa pessoa = new Pessoa(nome, dataDeNascimento);
    pessoas.add(pessoa);
  }

  private static void addFuncionario(String nome, BigDecimal salario, String funcao) {
    for (Pessoa pessoa : pessoas) {
      Funcionario funcionario = new Funcionario(pessoa, salario, funcao);
      funcionarios.add(funcionario);
    }
  }

  private static void excluiFuncionario(String nome) {
    funcionarios.removeIf(funcionario -> funcionario.getPessoa().getNome().equals(nome));

    System.out.println("Lista de Funcionários após a exclusão:");
    for (Funcionario funcionario : funcionarios) {
      System.out.println(funcionario);
    }
  }

  private static void formatarFuncionario(Funcionario funcionario) {
    Pessoa pessoa = funcionario.getPessoa();
    String nome = pessoa.getNome();
    String dataNascimento = pessoa.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    String salario = "R$ " + funcionario.getSalario().setScale(2, RoundingMode.HALF_EVEN).toString().replace(".", ",");

    System.out.println(String.format("Nome: %s, Data de Nascimento: %s, Salário: %s, Cargo: %s", nome, dataNascimento,
        salario, funcionario.getFuncao()));
  }

  private static void aumentoSalario(String nome, BigDecimal aumento) {
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getPessoa().getNome().equals(nome)) {
        BigDecimal novoSalario = funcionario.getSalario().add(aumento);
        funcionario.setSalario(novoSalario);
        String salarioFormatado = "R$ " + novoSalario.setScale(2, RoundingMode.HALF_EVEN).toString().replace(".", ",");

        System.out.println("Salário atualizado para " + nome + ": " + salarioFormatado);
        break;
      }
    }
  }

  private static Map<String, List<String>> agruparFuncionario() {
    Map<String, List<String>> mapFuncionarios = new HashMap<>();
    for (Funcionario funcionario : funcionarios) {
      String funcao = funcionario.getFuncao();
      if (!mapFuncionarios.containsKey(funcao)) {
        mapFuncionarios.put(funcao, new ArrayList<>());
      }
      mapFuncionarios.get(funcao).add(funcionario.getPessoa().getNome());
    }
    System.out.println("Lista de funcionários agrupados por função:");
    System.out.println(mapFuncionarios);

    return mapFuncionarios;
  }

  private static List<String> filtrarPorMesAniversario(int mes) {
    List<String> nomesFiltrados = new ArrayList<>();
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getPessoa().getDataDeNascimento().getMonthValue() == mes) {
        nomesFiltrados.add(funcionario.getPessoa().getNome());
      }
    }

    if (nomesFiltrados.isEmpty()) {
      System.out.println("Nenhum funcionário com aniversário no mês " + mes + ".");
    } else {
      System.out.println("Funcionários com aniversário no mês " + mes + ":");
      for (String nome : nomesFiltrados) {
        System.out.println(nome);
      }
    }

    return nomesFiltrados;
  }

  private static void funcionarioMaisVelho() {
    Funcionario maisVelho = funcionarios.get(0);
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getPessoa().getIdade() > maisVelho.getPessoa().getIdade()) {
        maisVelho = funcionario;
      }
    }

    Pessoa pessoaMaisVelha = maisVelho.getPessoa();
    int idade = LocalDate.now().getYear() -
        pessoaMaisVelha.getDataDeNascimento().getYear();
    System.out.println("Funcionário mais velho: " + pessoaMaisVelha.getNome() +
        ", Idade: " + idade + " anos");
  }

  public static void main(String[] args) {

    addPessoa("Maria", LocalDate.of(2000, 10, 18));
    addFuncionario("Maria", new BigDecimal("2009.44"), "Operador");

    addPessoa("João", LocalDate.of(1990, 05, 12));
    addFuncionario("João", new BigDecimal("2284.38"), "Operador");

    addPessoa("Caio", LocalDate.of(1961, 05, 02));
    addFuncionario("Caio", new BigDecimal("9836.14"), "Coordenador");

    addPessoa("Miguel", LocalDate.of(1988, 10, 14));
    addFuncionario("Miguel", new BigDecimal("19119.88"), "Diretor");

    addPessoa("Heitor", LocalDate.of(1999, 11, 19));
    addFuncionario("Heitor", new BigDecimal("1582.72"), "Operador");

    addPessoa("Alice", LocalDate.of(1995, 01, 05));
    addFuncionario("Alice", new BigDecimal("9836.14"), "Recepcionista");

    addPessoa("Arthur", LocalDate.of(1993, 03, 31));
    addFuncionario("Arthur", new BigDecimal("4071.84"), "Contador");

    addPessoa("Laura", LocalDate.of(1994, 07, 8));
    addFuncionario("Laura", new BigDecimal("3017.45"), "Gerente");

    addPessoa("Heloísa", LocalDate.of(2003, 05, 24));
    addFuncionario("Heloísa", new BigDecimal("1606.85"), "Eletricista");

    addPessoa("Helena", LocalDate.of(1996, 9, 02));
    addFuncionario("Helena", new BigDecimal("2799.93"), "Gerente");

    System.out.println("Lista de Funcionários:");
    for (Funcionario func : funcionarios) {
      System.out.println(func);
    }

    excluiFuncionario("João");

    System.out.println("Lista de funcionários formatada:");
    for (Funcionario funcionario : funcionarios) {
      formatarFuncionario(funcionario);
    }

    System.out.println("Aumento de salário de 10% para todos os funcionários:");
    for (Funcionario funcionario : funcionarios) {
      aumentoSalario(funcionario.getPessoa().getNome(),
          funcionario.getSalario().multiply(new BigDecimal("0.1")));
    }

    agruparFuncionario();

    filtrarPorMesAniversario(10);
    filtrarPorMesAniversario(12);

    funcionarioMaisVelho();
  }
}
