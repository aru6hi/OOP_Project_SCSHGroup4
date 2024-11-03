import java.util.ArrayList;

public class ApptOutcomeMgr {
	private static ArrayList<ApptOutRecord> allApptOutcomes = new ArrayList<ApptOutRecord>();;
	
	public ApptOutcomeMgr() {
	}
	
	public void viewAll() {
		System.out.println("Appointment Outcome Records:");
		System.out.println(allApptOutcomes);
	}
	
	public void addApptOutRecord(String apptID, Date date) {
		ApptOutRecord apptOut = new ApptOutRecord(apptID, date);
		
		allApptOutcomes.add(apptOut);
	}
	
	public void removeApptOutRecord(ApptOutRecord targetAppt) {
		//Ideally there is no way to get duplicate appointments
		allApptOutcomes.remove(targetAppt);
	}
	
	public void completeApptOutRecord(ApptOutRecord appt) {
		appt.setStatus(Status.COMPLETED);
	}
	
	public ArrayList<ApptOutRecord> findAllByStatus(Status status) {
		
		ArrayList<ApptOutRecord> outList = new ArrayList<ApptOutRecord>();
		
		for (ApptOutRecord appt : allApptOutcomes) {
			if (appt.getStatus() == status) {
				outList.add(appt);
			}
		}
		return outList;
	}
	
	public ArrayList<ApptOutRecord> findAllByDate(Date date) {
		
		ArrayList<ApptOutRecord> outList = new ArrayList<ApptOutRecord>();
		
		for (ApptOutRecord appt : allApptOutcomes) {
			if (appt.getDate() == date) {
				outList.add(appt);
			}
		}
		return outList;
	}
	
	public ArrayList<ApptOutRecord> findAllByApptID(String apptID) {
		
		ArrayList<ApptOutRecord> outList = new ArrayList<ApptOutRecord>();
		
		for (ApptOutRecord appt : allApptOutcomes) {
			if (appt.getApptID().equals(apptID)) {
				outList.add(appt);
			}
		}
		return outList;
	}
	
}
