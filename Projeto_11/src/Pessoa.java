import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pessoa {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPessoa")
	@Id
	private int idPessoa;
	
	@Column(name="Nome", columnDefinition ="VARCHAR(100)", nullable=false)
	private String nome;
	
	private String cpf;
	private String rg;
	private Date dtNascimento;
	
	@Column(name="Altura", columnDefinition ="DECIMAL(10,2)", nullable=false)
	private double altura;
	
	private double peso;
	

}
