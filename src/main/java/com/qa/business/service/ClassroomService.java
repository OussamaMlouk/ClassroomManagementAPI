package com.qa.business.service;

import com.qa.persistence.domain.Classroom;

public interface ClassroomService {
	String getAllClassrooms();

	String createClassroom(String classroom);

	String findClassroom(Long classroomID);

	String updateClassroom(String classroom, Long classroomID);

	String deleteClassroom(Long classroomID);
}
