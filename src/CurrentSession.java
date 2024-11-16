/**
 * Represents the current user session
 */
public class CurrentSession {
	private Account activeUser;
	
	/**
	 * gets active user
	 * @return Account of logged in user
	 */
	public Account getActiveUser() {
		return activeUser;
	}
	
	/**
	 * set active user
	 * @param activeUser the Account that is logged in
	 */
	public void setActiveUser(Account activeUser) {
		this.activeUser = activeUser;
	}
	
	/**
	 * Creates a new CurrentSession
	 */
	public CurrentSession() {};
}
