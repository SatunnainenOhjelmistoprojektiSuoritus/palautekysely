package fi.sos.validation;

public class Validaattori {
	
	// Checks if string is null
	public boolean checkForEmpty (String vastaus){
		
		vastaus = vastaus.trim();
		
		if (!vastaus.isEmpty()){
			
			return true;
		}
				
		return false;
	}
	
	// Check if question is acceptable type
	public boolean checkForAcceptedQuestionTypes (String type){
		
		String monivalinta = "monivalinta";
		String numero = "int";
		String teksti = "string";
		
		if (type.equalsIgnoreCase(monivalinta) || type.equalsIgnoreCase(numero) || type.equalsIgnoreCase(teksti)){
			
			return true;
		}		
		
		return false;
	}
	
	//Check if type is really number
	public boolean checkForDataType(String type, String data){
		
		String numero = "int";
		data = data.trim();
		
		try {
			
			if (type.equalsIgnoreCase(numero)){
				Integer.parseInt(data);
				return true;
			}
			
			if (data.isEmpty()){
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
				
		return false;
	}
	
}
