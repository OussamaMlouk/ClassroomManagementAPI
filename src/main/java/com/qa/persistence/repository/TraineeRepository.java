package com.qa.persistence.repository;

import com.qa.persistence.domain.Trainee;

public interface TraineeRepository {

	String getAllTrainees();

	String createTrainee(String trainee);

	Trainee findTrainee(Long traineeID);

	String updateTrainee(String trainee, Long traineeID);

	String deleteTrainee(Long traineeID);
}
