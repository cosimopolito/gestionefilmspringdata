package it.prova.raccoltafilmspringbootservletspringdata.repository.regista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.raccoltafilmspringbootservletspringdata.model.Regista;

public class CustomRegistaRepositoryImpl implements CustomRegistaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Regista> findByExample(Regista example) {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select r from Regista r where r.id = r.id ");

		if (StringUtils.isNotEmpty(example.getNome())) {
			whereClauses.add(" r.nome  like :nome ");
			paramaterMap.put("nome", "%" + example.getNome() + "%");
		}
		if (StringUtils.isNotEmpty(example.getCognome())) {
			whereClauses.add(" r.cognome like :cognome ");
			paramaterMap.put("cognome", "%" + example.getCognome() + "%");
		}
		if (StringUtils.isNotEmpty(example.getNickName())) {
			whereClauses.add(" r.nickName like :nickName ");
			paramaterMap.put("nickName", "%" + example.getNickName() + "%");
		}
		if (example.getSesso() != null) {
			whereClauses.add(" r.sesso =:sesso ");
			paramaterMap.put("sesso", example.getSesso());
		}
		if (example.getDataDiNascita() != null) {
			whereClauses.add("r.dataDiNascita >= :dataDiNascita ");
			paramaterMap.put("dataDiNascita", example.getDataDiNascita());
		}
		
		queryBuilder.append(!whereClauses.isEmpty()?" and ":"");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Regista> typedQuery = entityManager.createQuery(queryBuilder.toString(), Regista.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

	@Override
	public Regista findOneEager(Long id) {
		Query q = entityManager.createQuery("SELECT r FROM Regista r LEFT JOIN FETCH r.films f WHERE r.id = :id");
		q.setParameter("id", id);
		return (Regista) q.getSingleResult();
	}

}
