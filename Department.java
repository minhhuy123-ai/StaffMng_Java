package quanlynhansu;

public class Department {
	private String departmentId;
	private String departmentName;
	private int numStaff;

	public Department(String departmentId, String departmentName, int numStaff) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.numStaff = numStaff;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getNumStaff() {
		return numStaff;
	}

	public void setNumStaff(int numStaff) {
		this.numStaff = numStaff;
	}

	@Override
	public String toString() {
		return String.format("%-12s| %-25s| %-30d", departmentId, departmentName, numStaff);
	}
	
}
