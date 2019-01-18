package com.qa.business.service;

import com.qa.persistence.domain.Trainee;

public interface TraineeService {
	String getAllTrainees();

	String createTrainee(String trainee);

	Trainee findTrainee(Long traineeID);

	String updateTrainee(String trainee, Long traineeID);

	String deleteTrainee(Long traineeID);
}
