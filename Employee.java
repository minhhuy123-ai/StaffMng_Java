package quanlynhansu;

import java.util.List;
import java.util.Scanner;

public class Employee extends Staff {
	private float overTimeHours;

	@Override
	public void inputInfo(List<Department> departmentList, Scanner input) {
		super.inputInfo(departmentList, input);
		
		System.out.print("Nhập số giờ làm thêm: ");
		//Kiểm tra giá trị nhập vào
		while(true) {
			try {
				this.overTimeHours = Float.parseFloat(input.nextLine());
				if(this.overTimeHours >= 0) {
					break;
				}else {
					System.out.println("Số giờ làm thêm phải >= 0: ");
				}
			} catch (Exception e) {
				System.err.println("Giá trị không hợp lệ, làm ơn nhập số: ");
			}
			
		}
	
	}


	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return super.salaryRate*3000000 + this.overTimeHours*200000;
	}
	
	@Override
	public String toString() {
		return "Employee [overTimeHours=" + overTimeHours + ", id=" + id + ", name=" + name + ", age=" + age
				+ ", salaryRate=" + salaryRate + ", dayStartWork=" + dayStartWork + ", department=" + department
				+ ", numDayOff=" + numDayOff + "]";
	}

	@Override
	public String displayInformation() {
		
		return String.format("%-15s| %-20s| %-8d| %-15.1f| %-15s| %-15d| %-20s| %-25.1f| %-15.2f", id, name, age, salaryRate, dayStartWork, numDayOff, department.getDepartmentName(), overTimeHours, calculateSalary());
		
		/*
		 * System.out.printf("%-15s| %-20s| %-8d| %-15f| %-15s| %-15d| %-20s| %-25d| %-15f", id, name, age, salaryRate, dayStartWork, numDayOff, department.getDepartmentName(), overTimeHours, calculateSalary())
		*/
	}
	
}
