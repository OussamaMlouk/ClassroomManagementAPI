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

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public String getAllClassrooms() {
		Query query = em.createQuery("SELECT c FROM Classroom c");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		em.persist(aClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	public String findClassroom(Long classroomID) {
		return util.getJSONForObject(em.find(Classroom.class, classroomID));
	}

	@Transactional(REQUIRED)
	public String updateClassroom(String classroom, Long classroomID) {
		Classroom classroomInDB = em.find(Classroom.class, classroomID);
		if (classroomInDB != null) {
			deleteClassroom(classroomID);
			createClassroom(classroom);
			return "{\"message\": \"classroom successfully updated\"}";
		} else {
			return "{\"message\": \"classroom not found\"}";
		}
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long classroomID) {
		Classroom classroomInDB = em.find(Classroom.class, classroomID);
		if (classroomInDB != null) {
			em.remove(classroomInDB);
			return "{\"message\": \"classroom sucessfully deleted\"}";
		} else {
			return "{\"message\": \"classroom not found\"}";
		}
	}

}
