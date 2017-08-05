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

	private VerifyRecaptcha verifyRecaptcha = new VerifyRecaptcha();
	
	@POST
	@Path("/email")
	public RecaptchaStatus processEmailRequest(@FormParam("recaptcha_response") String recaptchaResponse) {
		if (verifyRecaptcha.verify(recaptchaResponse)) {
			System.out.println("VALID!!!");
			
			return new RecaptchaStatus("SUCCESS");
		}
		

		return new RecaptchaStatus("FAILURE");
	}

}
