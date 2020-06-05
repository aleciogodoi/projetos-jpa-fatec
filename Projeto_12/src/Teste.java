import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.entidades.Pessoa;
import com.servicos.Dao;

public abstract class Teste {
	
	public static void main(String[] args) {
		String opcao="";
		do {
			opcao= JOptionPane.showInputDialog(
					  "1 - Inclusão\n"
					+ "2 - Pesquisa por Id\n"
					+ "3 - Pesquisa por Nome\n"
					+ "4 - Pesquisa CPF\n"
					+ "5 - Alteração\n"
					+ "6 - Exclusão\n"
					+ "7 - Listagem\n"
					+ "0 - Sair"
			);
			switch (opcao) {
			case "1":
				insert();
				break;
			case "2":
				findId();
				break;
			case "3":
				findNome();
				break;
			case "4":
				findCpf();
				break;
			case "5":
				update();
				break;
			case "6":
				delete();
				break;
			case "7":
				list();
				break;
			}
		} while(!opcao.contains("0"));
		
	}
	
	public static void insert() {
		Pessoa pessoa = new Pessoa();
		pessoa = inputData(pessoa);
		Dao.insertPessoa(pessoa);;
	}
	
	public static void update() {
		Pessoa pessoa = findId();
		pessoa = inputData(pessoa);
		Dao.updatePessoa(pessoa);
	}
	
	public static void delete() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa"));
		Dao.deletePessoa(id);
	}

	public static Pessoa findId() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id Pessoa"));
		Pessoa pessoa = Dao.findPessoaId(id);
		JOptionPane.showMessageDialog(null, pessoa);
		return pessoa;
	}
	
	public static Pessoa findCpf() {
		String cpf = JOptionPane.showInputDialog("Cpf");
		Pessoa pessoa = Dao.findPessoaCpf(cpf);
		JOptionPane.showMessageDialog(null, pessoa);
		return pessoa;
	}
	
	public static Pessoa findNome() {
		String nome = JOptionPane.showInputDialog("Nome");
		Pessoa pessoa = Dao.findPessoaNome(nome);
		JOptionPane.showMessageDialog(null, pessoa);		
		return pessoa;
	}
	
	public static void list() {
		List<Pessoa> pessoas = Dao.allPessoas();
		String dados = "";
		
		for(Pessoa pessoa: pessoas) {
			dados += pessoa.toString()+"\n";
		}
		JOptionPane.showMessageDialog(null,dados);
	}
	
	public static Pessoa inputData(Pessoa pessoa) {
    	int dia=0, mes=0, ano=0;
    	
    	if (pessoa.getIdPessoa() !=0 && pessoa.getDtNascimento() != null) {
	    	LocalDate data = pessoa.getDtNascimento().toLocalDate();
	    	dia = data.getDayOfMonth();
	    	mes = data.getMonthValue();
	    	ano = data.getYear();
    	}
    	
    	pessoa.setNome(JOptionPane.showInputDialog("Nome",pessoa.getNome()));
    	pessoa.setCpf(JOptionPane.showInputDialog("CPF",pessoa.getCpf()));
    	pessoa.setRg(JOptionPane.showInputDialog("RG",pessoa.getRg()));
    	dia = Integer.parseInt(JOptionPane.showInputDialog("Dia Nascimento",(dia==0 ? "": dia) ));
    	mes = Integer.parseInt(JOptionPane.showInputDialog("Mês Nascimento",(mes==0 ? "": mes) ));
    	ano = Integer.parseInt(JOptionPane.showInputDialog("Ano Nascimento",(ano==0 ? "": ano) ));
    	pessoa.setDtNascimento(Date.valueOf((LocalDate.of(ano, mes, dia))));
    	pessoa.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso", pessoa.getPeso())));
    	pessoa.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Altura", pessoa.getAltura())));
    	return pessoa;
    }
}
