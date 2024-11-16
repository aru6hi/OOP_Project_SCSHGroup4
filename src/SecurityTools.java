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
	
	public static boolean authenticatePassword(Account userToAuthenticate, String inputPassword) {
		//Pass in the input password
		//It will encrypt it and compare to encrypted password
		//A match means the input is the same as the actual password
		String encPass = SecurityTools.encryptPassword(inputPassword);
		String storedPass = userToAuthenticate.getEncPassword();
		
		if (encPass.equals(storedPass)) {
			return true;
		}
		return false;
	}
}
