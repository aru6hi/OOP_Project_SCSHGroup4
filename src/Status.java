public enum Status {
	COMPLETED,
	CONFIRMED,
	PENDING,
	CANCELLED,
	OPEN,
	APPROVED,
	REJECTED;
	
	public String toString() {
		return this.name();
	}
}
