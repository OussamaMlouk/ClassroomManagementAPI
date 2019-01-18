package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.TraineeService;
import com.qa.persistence.domain.Trainee;

@Path("/trainee")
public class TraineeEndpoint {
	@Inject
	private TraineeService service;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
	
	@Path("/updateTrainee/{traineeID}")
	@POST
	@Produces({ "application/json" })
	public String updateTrainee(String trainee, @PathParam("traineeID") Long traineeID) {
		return service.updateTrainee(trainee, traineeID);
	}

	@Path("/deleteTrainee/{traineeID}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee( @PathParam("traineeID") Long traineeID) {
		return service.deleteTrainee(traineeID);
	}
}
