package fi.sos.validation;

public class Validaattori {
	
	
	public boolean checkForEmpty (String vastaus){
		
		if (!vastaus.isEmpty()){
			
			return true;
		}
				
		return false;
	}
	
	public boolean checkForAcceptedQuestionTypes (String type){
		
		String monivalinta = "monivalinta";
		String numero = "int";
		String teksti = "string";
		
		if (type.equalsIgnoreCase(monivalinta) || type.equalsIgnoreCase(numero) || type.equalsIgnoreCase(teksti)){
			
			return true;
		}		
		
		return false;
	}
	
	public boolean checkForDataType(String type, String data){
		
		String numero = "int";
		
		try {
			
			if (type.equalsIgnoreCase(numero)){
				Integer.parseInt(data);
				return true;
			}
			
			
		} catch (Exception e) {
			return false;
		}
				
		return false;
	}
	
	

}
