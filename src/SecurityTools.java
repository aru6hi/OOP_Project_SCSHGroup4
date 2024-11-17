/**
 * Utility class with methods for encrypting and authenticating passwords
 */
public final class SecurityTools {

	private SecurityTools() {};
	
	/**
	 * encrypts a password
	 * @param rawPassword password to encrypt
	 * @return encrypted password
	 */
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
	
	/**
	 * authenticates a password
	 * @param encPassword the target password to match
	 * @param inputPassword the input password
	 * @return true if matches else false
	 */
	public static boolean authenticatePassword(String encPassword, String inputPassword) {
		//Pass in the input password
		//It will encrypt it and compare to encrypted password
		//A match means the input is the same as the actual password
		String encPass = SecurityTools.encryptPassword(inputPassword);
		String storedPass = encPassword;
		
		if (encPass.equals(storedPass)) {
			return true;
		}
		return false;
	}
}
