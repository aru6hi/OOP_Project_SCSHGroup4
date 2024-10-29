public enum Status {
	COMPLETED,
	CONFIRMED,
	CANCELLED,
	PENDING,
	OPEN;
	
	public String toString() {
		return this.name();
	}
}
