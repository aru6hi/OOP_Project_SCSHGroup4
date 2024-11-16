/**
 * Status enum representing all possible statuses for appointments, appointment outcome records and replenishment requests
 */
public enum Status {
	COMPLETED,
	CONFIRMED,
	PENDING,
	OPEN,
	APPROVED,
	REJECTED;
	
	public String toString() {
		return this.name();
	}
}
