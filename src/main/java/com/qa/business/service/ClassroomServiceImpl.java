package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository repo;
	
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	public String findClassroom(Long classroomID) {
		return repo.findClassroom(classroomID);
	}

	public String updateClassroom(String classroom, Long classroomID) {
		return repo.updateClassroom(classroom, classroomID);
	}

	public String deleteClassroom(Long classroomID) {
		return repo.deleteClassroom(classroomID);
	}
	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

}
