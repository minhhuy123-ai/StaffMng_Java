package quanlynhansu;

import java.util.List;
import java.util.Scanner;

public class Manager extends Staff {
    private String position;


    @Override
    public void inputInfo(List<Department> departmentList, Scanner input) {
        super.inputInfo(departmentList, input);
        int positionNumber = 0;
        System.out.println("Chức danh:");
		System.out.println("1. Business Leader");
		System.out.println("2. Project Leader");
		System.out.println("3. Technical Leader");
		System.out.print("Nhập chức danh: ");
		//Kiểm tra giá trị nhập vào
		while(true) {
			try {
				positionNumber = Integer.parseInt(input.nextLine());
				if(positionNumber < 1 || positionNumber > 3) {
					System.err.println("Giá trị phải nằm trong khoảng 1 - 3: ");
				}else {
					break;
				}
			} catch (Exception e) {
				System.err.println("Giá trị không hợp lệ, làm ơn nhập số: ");
			}
		}
		
		switch (positionNumber) {
		case 1:
			this.position = "Business Leader";
			break;
		case 2:
			this.position = "Project Leader";
			break;
		case 3:
			this.position = "Technical Leader";
			break;
		}
    }


    //hoi lai de ham tinh luong o day dung chua
    public double calculateSalary() {
        int dutySalary = 0;
        if (position.equalsIgnoreCase("Business Leader")) {
            dutySalary = 8000000;
        } else if (position.equalsIgnoreCase("Project Leader")) {
            dutySalary = 5000000;
        } else {
            dutySalary = 6000000;
        }
        return salaryRate * 5000000 + dutySalary;
    }
    
    

    @Override
	public String toString() {
		return "Manager [position=" + position + ", getId()=" + getId() + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getSalaryRate()=" + getSalaryRate() + ", getDayStartWork()=" + getDayStartWork()
				+ ", getDepartment()=" + getDepartment() + ", getNumDayOff()=" + getNumDayOff() + ", toString()="
				+ super.toString() + "]";
	}


	@Override
    public String displayInformation() {
		
		return String.format("%-15s| %-20s| %-8d| %-15.1f| %-15s| %-15d| %-20s| %-25s| %-15.2f", id, name, age, salaryRate, dayStartWork, numDayOff, department.getDepartmentName(), position, calculateSalary());
		
		
    }


}
