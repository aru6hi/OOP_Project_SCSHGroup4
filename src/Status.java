public enum Status {
	COMPLETED,
	CONFIRMED,
	CANCELLED,
	PENDING,
	OPEN,
	APPROVED,
	REJECTED;
	
	public String toString() {
		return this.name();
	}
}
