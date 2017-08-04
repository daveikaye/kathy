package com.kathy;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public class EmailAction {

	@POST
	@Path("/email")
	public String processEmailRequest(@FormParam("recaptcha_response") String recaptchaResponse) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		System.out.println(recaptchaResponse);

		SomeValue someValue = new SomeValue("val 1", "val 2");

		return mapper.writeValueAsString(someValue);
	}

}
