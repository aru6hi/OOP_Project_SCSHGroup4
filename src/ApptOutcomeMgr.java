package HMS;

import java.util.ArrayList;

public class ApptOutcomeMgr {
	private ArrayList<ApptOutRecord> allApptOutcomes = new ArrayList<ApptOutRecord>();;
	
	public ApptOutcomeMgr() {
	}
	
	public void viewAll() {
		System.out.println("Appointment Outcome Records:");
		System.out.println(allApptOutcomes);
	}
	
	public void addApptOutRecord(String apptID, Date date, String service) {
		ApptOutRecord apptOut = new ApptOutRecord(apptID, date, service);
		
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
	
	public ApptOutRecord findByApptID(String apptID) {
		
		for (ApptOutRecord appt : allApptOutcomes) {
			if (appt.getApptID().equals(apptID)) {
				return appt;
			}
		}
		throw new RuntimeException("No such ApptID");
	}
	
}
