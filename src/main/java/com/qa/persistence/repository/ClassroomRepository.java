package com.qa.persistence.repository;

import com.qa.persistence.domain.Classroom;

public interface ClassroomRepository {
	String getAllClassrooms();

	String createClassroom(String classroom);

	String findClassroom(Long classroomID);

	String updateClassroom(String classroom, Long classroomID);

	String deleteClassroom(Long classroomID);
}
