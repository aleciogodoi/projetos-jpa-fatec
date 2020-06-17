import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.entidades.Tarefa;
import com.servicos.Dao;

public abstract class Teste {
	
	public static void main(String[] args) {
		String opcao="";
		do {
			opcao= JOptionPane.showInputDialog(
					  "1 - Inclusão\n"
					+ "2 - Pesquisa por Id\n"
					+ "3 - Pesquisa por Descrição\n"
					+ "4 - Pesquisa por Período\n"
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
				findDscTarefa();
				break;
			case "4":
				findPeriodo();
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
		Tarefa tarefa = new Tarefa();
		tarefa = inputData(tarefa);
		Dao.insertTarefa(tarefa);;
	}
	
	public static void update() {
		Tarefa tarefa = findId();
		tarefa = inputData(tarefa);
		Dao.updateTarefa(tarefa);
	}
	
	public static void delete() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id Tarefa"));
		Dao.deleteTarefa(id);
	}

	public static Tarefa findId() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Id Tarefa"));
		Tarefa tarefa = Dao.findTarefaId(id);
		JOptionPane.showMessageDialog(null, tarefa);
		return tarefa;
	}

	public static void findDscTarefa() {
		String dsc = JOptionPane.showInputDialog("Descrição Tarefa");
		List<Tarefa> tarefas = Dao.findDscTarefa(dsc);
		list(tarefas);
	}

	public static void findPeriodo() {
    	int diaInicio=0, mesInicio=0, anoInicio=0;
    	int diaFim=0, mesFim=0, anoFim=0;
    	Date dtInicio, dtFim;
    	
		diaInicio = Integer.parseInt(JOptionPane.showInputDialog("Dia Início"));
    	mesInicio = Integer.parseInt(JOptionPane.showInputDialog("Mês Início",(mesInicio==0 ? "": mesInicio) ));
    	anoInicio = Integer.parseInt(JOptionPane.showInputDialog("Ano Início",(anoInicio==0 ? "": anoInicio) ));
    	dtInicio = (Date.valueOf((LocalDate.of(anoInicio, mesInicio, diaInicio))));    		
 
       	diaFim = Integer.parseInt(JOptionPane.showInputDialog("Dia Fim"));
    	mesFim = Integer.parseInt(JOptionPane.showInputDialog("Mês Fim"));
    	anoFim = Integer.parseInt(JOptionPane.showInputDialog("Ano Fim"));
    	dtFim = (Date.valueOf((LocalDate.of(anoFim, mesFim, diaFim))));    		
		
		List<Tarefa> tarefas = Dao.findBetweenDate(dtInicio, dtFim);
		list(tarefas);
	}
	

	public static void list(List<Tarefa> tarefas) {
		String dados = "";
		
		for(Tarefa pessoa: tarefas) {
			dados += pessoa.toString()+"\n";
		}
		JOptionPane.showMessageDialog(null,dados);
	}

	public static void list() {
		List<Tarefa> tarefas = Dao.allTarefas();
		String dados = "";
		
		for(Tarefa pessoa: tarefas) {
			dados += pessoa.toString()+"\n";
		}
		JOptionPane.showMessageDialog(null,dados);
	}
	
	public static Tarefa inputData(Tarefa tarefa) {
    	int diaInicio=0, mesInicio=0, anoInicio=0;
    	int diaFim=0, mesFim=0, anoFim=0;

    	if (tarefa.getIdTarefa() !=0 && tarefa.getDtInicio() != null) {
	    	LocalDate data = tarefa.getDtInicio().toLocalDate();
	    	diaInicio = data.getDayOfMonth();
	    	mesInicio = data.getMonthValue();
	    	anoInicio = data.getYear();
    	}

    	if (tarefa.getIdTarefa() !=0 && tarefa.getDtFim() != null) {
	    	LocalDate data = tarefa.getDtFim().toLocalDate();
	    	diaFim = data.getDayOfMonth();
	    	mesFim = data.getMonthValue();
	    	anoFim = data.getYear();
    	}
    	
    	tarefa.setDscTarefa(JOptionPane.showInputDialog("Descr. Tarefa",tarefa.getDscTarefa()));
    	tarefa.setFinalizada(Boolean.parseBoolean(JOptionPane.showInputDialog("Finalizada",tarefa.isFinalizada())));
    	diaInicio = Integer.parseInt(JOptionPane.showInputDialog("Dia Início",(diaInicio==0 ? "": diaInicio) ));
    	mesInicio = Integer.parseInt(JOptionPane.showInputDialog("Mês Início",(mesInicio==0 ? "": mesInicio) ));
    	anoInicio = Integer.parseInt(JOptionPane.showInputDialog("Ano Início",(anoInicio==0 ? "": anoInicio) ));
    	
    	if (diaInicio==0 && mesInicio==0 && anoInicio==00)
        	tarefa.setDtInicio(null);
    	else
        	tarefa.setDtInicio(Date.valueOf((LocalDate.of(anoInicio, mesInicio, diaInicio))));    		

    	diaFim = Integer.parseInt(JOptionPane.showInputDialog("Dia Fim",(diaInicio==0 ? "": diaFim) ));
    	mesFim = Integer.parseInt(JOptionPane.showInputDialog("Mês Fim",(mesInicio==0 ? "": mesFim) ));
    	anoFim = Integer.parseInt(JOptionPane.showInputDialog("Ano Fim",(anoInicio==0 ? "": anoFim) ));

    	if (diaFim==0 && mesFim==0 && anoFim==00)
        	tarefa.setDtFim(null);
    	else
    		tarefa.setDtFim(Date.valueOf((LocalDate.of(anoFim, mesFim, diaFim))));

    	return tarefa;
    }
}
