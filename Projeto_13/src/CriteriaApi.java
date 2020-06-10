import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.entidades.Pessoa;

public class CriteriaApi {
	
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");
		EntityManager entitymanager = emfactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Pessoa> from = criteriaQuery.from(Pessoa.class);

		
		// selecionando todos os registros
		System.out.println("\n\nSelecionando todos os registros");
		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();

		for (Object o : resultlist) {
			Pessoa e = (Pessoa) o;
			System.out.println("Id : " + e.getIdPessoa() + " Nome : " + e.getNome());
		}

		
// Ordenando registros
		System.out.println("\n\nSelecionando todos os registros e ordenando por nome decrescente");
		CriteriaQuery<Object> select1 = criteriaQuery.select(from);
		select1.orderBy(criteriaBuilder.asc(from.get("nome")));
		TypedQuery<Object> typedQuery1 = entitymanager.createQuery(select1);
		List<Object> resultlist1 = typedQuery1.getResultList();

		for (Object o : resultlist1) {
			Pessoa e = (Pessoa) o;
			System.out.println("Id : " + e.getIdPessoa() + " Nome : " + e.getNome());
		}


	
//Pesquisando registro por ID
		System.out.println("\n\nSelecionando id especifico");
		CriteriaQuery<Object> select2 = criteriaQuery.select(from);
		select2.where(criteriaBuilder.greaterThanOrEqualTo(from.get("idPessoa"), 5));
		select2.orderBy(criteriaBuilder.desc(from.get("idPessoa")));
		TypedQuery<Object> typedQuery2 = entitymanager.createQuery(select2);
		List<Object> resultlist2 = typedQuery2.getResultList();

		for (Object o : resultlist2) {
			Pessoa e = (Pessoa) o;
			System.out.println("Id : " + e.getIdPessoa() + " Nome : " + e.getNome());
		}

		
//Pesquisando por like
		System.out.println("\n\nPesquisando por Like");
		CriteriaQuery<Object> select3 = criteriaQuery.select(from);
		select3.where(criteriaBuilder.like(from.get("nome"), "%A%"));
		TypedQuery<Object> typedQuery3 = entitymanager.createQuery(select3);
		List<Object> resultlist3 = typedQuery3.getResultList();

		for (Object o : resultlist3) {
			Pessoa e = (Pessoa) o;
			System.out.println("Id : " + e.getIdPessoa() + " Nome : " + e.getNome());
		}

		
//Pesquisando por IN
		System.out.println("\n\nPesquisando por IN");
		CriteriaQuery<Object> select4 = criteriaQuery.select(from);
		select4.where(criteriaBuilder.in(from.get("idPessoa")).value(1).value(2).value(3).value(4));
		TypedQuery<Object> typedQuery4 = entitymanager.createQuery(select4);
		List<Object> resultlist4 = typedQuery4.getResultList();

		for (Object o : resultlist4) {
			Pessoa e = (Pessoa) o;
			System.out.println("Id : " + e.getIdPessoa() + " Nome : " + e.getNome());
		}

//Pesquisando por Between
		System.out.println("\n\nPesquisando por Between");
		CriteriaQuery<Object> select5 = criteriaQuery.select(from);
		select5.where(criteriaBuilder.between(from.get("peso"), 50, 70));
		TypedQuery<Object> typedQuery5 = entitymanager.createQuery(select5);
		List<Object> resultlist5 = typedQuery5.getResultList();

		for (Object o : resultlist5) {
			Pessoa e = (Pessoa) o;
			System.out.println("Id : " + e.getIdPessoa() + " Nome : " + e.getNome());
		}
	
		System.out.println("\n\n");
		entitymanager.close();
		emfactory.close();
		
		
	}
}