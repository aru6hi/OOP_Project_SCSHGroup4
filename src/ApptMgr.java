import java.util.ArrayList;

public class ApptMgr {
	private ArrayList<Appointment> allAppt = new ArrayList<Appointment>();;
	
	public ApptMgr() {
	}
	
	public void viewAll() {
		System.out.println("Appointments:");
		System.out.println(allAppt);
	}
	
	public void addAppt(String doctorID, String patientID, int day, int month, int year, String time) {
		
		Date date = new Date(day, month, year);
		
		Appointment newAppt = new Appointment(doctorID, patientID, date, time);
		
		allAppt.add(newAppt);
	}
	
	public void addAppt(String doctorID, String patientID, int day, int month, int year, String time, Status status) {
		
		Date date = new Date(day, month, year);
		
		Appointment newAppt = new Appointment(doctorID, patientID, date, time, status);
		
		allAppt.add(newAppt);
	}
	
	public void removeAppt(Appointment targetAppt) {
		//Ideally there is no way to get duplicate appointments
		allAppt.remove(targetAppt);
	}
	
	public ArrayList<Appointment> findAllByPatientID(String PatientID) {
		
		ArrayList<Appointment> outList = new ArrayList<Appointment>();
		
		for (Appointment appt : allAppt) {
			if (appt.getPatientID().equals(PatientID)) {
				outList.add(appt);
			}
		}
		return outList;
	}
	
	public ArrayList<Appointment> findAllByDoctorID(String DoctorID) {
		ArrayList<Appointment> outList = new ArrayList<Appointment>();
		
		for (Appointment appt : allAppt) {
			if (appt.getDoctorID().equals(DoctorID)) {
				outList.add(appt);
			}
		}
		return outList;
	}
	
	public ArrayList<Appointment> findAllByStatus(Status targetStatus) {
		
		ArrayList<Appointment> outList = new ArrayList<Appointment>();
		
		for (Appointment appt : allAppt) {
			if (appt.getStatus() == targetStatus) {
				outList.add(appt);
			}
		}
		return outList;
	}
	
	public Appointment findByApptID(String targetApptID) {
		
		for (Appointment appt : allAppt) {
			if (appt.getApptID().equals(targetApptID)) {
				return appt;
			}
		}
		throw new RuntimeException("No such ApptID");
	}
	
	//All split so I can add functionality for each action
	public void cancelAppt(Appointment appt) {
		appt.setStatus(Status.CANCELLED);
	}
	
	public void bookAppt(Appointment appt) {
		appt.setStatus(Status.PENDING);
	}
	
	public void confirmAppt(Appointment appt) {
		appt.setStatus(Status.CONFIRMED);
	}
	
	public void completeAppt(Appointment appt) {
		appt.setStatus(Status.COMPLETED);
	}
}
