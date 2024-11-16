
public class CurrentSession {
	private Account activeUser;
	
	public Account getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(Account activeUser) {
		this.activeUser = activeUser;
	}

	public CurrentSession() {
	}
}
