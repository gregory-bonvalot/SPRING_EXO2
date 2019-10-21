package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class Spring2Route {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Route.class, args);
    }
	
	@RequestMapping("/doctor/{num}")
    @ResponseBody
    // @PathVariable = ajoute l'extention name à la fin du lien http.
    public String doct(@PathVariable int num) {
		if (num > 0 && num <= 8) {
        	throw new ResponseStatusException(HttpStatus.SEE_OTHER, "La réponse à cette requête est ailleurs");
        }
        switch(num) {
			case 9:
				return "{\"number\": 9, \"name\": \"Christopher Eccleston\"}";
			case 10:
				return "{\"number\": 10, \"name\": \"David Tennant\"}";
			//break;
			case 11:
				return "{\"number\": 11, \"name\": \"Matt Smith\"}";
			//break;
			case 12:
				return "{\"number\": 12, \"name\": \"Peter Capaldi\"}";
			//break;
			case 13:
				return "{\"number\": 13, \"name\": \"Jodie Whittaker\"}";
			//break;
			default:
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation" + num);
        }
	}
}
