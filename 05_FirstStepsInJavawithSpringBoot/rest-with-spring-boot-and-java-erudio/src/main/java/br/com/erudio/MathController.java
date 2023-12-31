package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	private final String template = "Hello, %s!";
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}") //@PathVariable recuperar dados da URL
	public Double sum(@PathVariable(value = "numberOne") String numberOne, 
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {		
			 throw new UnsupportedMathOperationException("Nos passe um valor numerico valido");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		
		if(strNumber == null) {
			return 0D;
		}
		
		String number = strNumber.replaceAll(",", ".");
		
		if(isNumeric(number)) {
			return Double.parseDouble(number);
		}
		
		return null;
	}

	private boolean isNumeric(String strNumber) {
		
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}
}