package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	private final String template = "Hello, %s!";
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}") //@PathVariable recuperar dados da url
	public String sum(@PathVariable(value = "numberOne") String numberOne, 
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {		
			 throw new Exception("");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private String convertToDouble(String strNumber) {
		return null;
	}

	private boolean isNumeric(String number) {
		return false;
	}
}