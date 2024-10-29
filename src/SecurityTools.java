public final class SecurityTools {
	

	private SecurityTools() {};
	
	public static String encryptPassword(String rawPassword) {
		//A simple XOR cipher for encrypting passwords
		//Run it again on an encrypted password to decrypt
		char key = 'Q';
		String out = ""; 
		  
        	int length = rawPassword.length(); 

	        for (int i = 0; i < length; i++)  
	        { 
	            out = out + Character.toString((char) (rawPassword.charAt(i) ^ key)); 
	        }
	        
	        //System.out.println(out);
	        
	        return out;
	}
}
