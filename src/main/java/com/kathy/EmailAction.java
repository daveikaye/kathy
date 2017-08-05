package com.kathy;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public class EmailAction {

	@POST
	@Path("/email")
	public SomeValue processEmailRequest(@FormParam("recaptcha_response") String recaptchaResponse) {
		System.out.println(recaptchaResponse);

		SomeValue someValue = new SomeValue("val 1", "val 2");

		return someValue;
	}

}
