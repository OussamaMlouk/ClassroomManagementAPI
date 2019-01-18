package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public String getAllTrainees() {
		Query query = em.createQuery("Select t FROM Trainee t");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}

	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		em.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(String trainee, Long traineeID) {
		Trainee traineeInDB = findTrainee(traineeID);
		if (traineeInDB != null) {
			return "{\"message\": \"trainee successfully updated\"}";
		} else {
			return "{\"message\": \"trainee not found\"}";
		}
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeID) {
		Trainee traineeInDB = findTrainee(traineeID);
		if (traineeInDB != null) {
			return "{\"message\": \"trainee sucessfully deleted\"}";
		} else {
			return "{\"message\": \"trainee not found\"}";
		}
	}

	public Trainee findTrainee(Long traineeID) {
		return em.find(Trainee.class, traineeID);
	}

}
