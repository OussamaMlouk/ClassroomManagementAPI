package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {
	
	@Inject
	private TraineeRepository repo;
	
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String createTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	public Trainee findTrainee(Long traineeID) {
		return repo.findTrainee(traineeID);
	}

	public String updateTrainee(String trainee, Long traineeID) {
		return repo.updateTrainee(trainee, traineeID);
	}

	public String deleteTrainee(Long traineeID) {
		return repo.deleteTrainee(traineeID);
	}
	
	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}
	
}
