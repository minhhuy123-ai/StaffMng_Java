package quanlynhansu;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Staff implements ICalculator {

	protected String id;
	protected String name;
	protected int age;
	protected double salaryRate;
	protected String dayStartWork;
	protected Department department;
	protected int numDayOff;

	public void inputInfo(List<Department> departmentList, Scanner input) {
		
		//kiểm tra id phải có 1 ký tự và 3 số
		/*Pattern p = Pattern.compile("^[a-zA-Z]{1}[0-9]{3}$");
		*/
		System.out.print("Nhập mã nhân viên: ");
		//Kiểm tra giá trị nhập vào
		while (true) {
			this.id = input.nextLine();
			//báo lỗi khi người dùng (1) không nhập hoặc (2) gõ space nhiều lần
			if (!id.trim().isEmpty()) {
				break;
			} else {
				System.err.println("Mã nhân viên không được để trống: ");
			}
		}
		
		System.out.print("Nhập tên nhân viên: ");
		//Kiểm tra giá trị nhập vào
		while (true) {
			this.name = input.nextLine();
			//báo lỗi khi người dùng (1) không nhập hoặc (2) gõ space nhiều lần
			if (!name.trim().isEmpty()) {
				break;
			} else {
				System.err.println("Tên không được để trống: ");
			}

		}
		
		System.out.print("Nhập tuổi nhân viên: ");
		//Kiểm tra giá trị nhập vào
		while (true) {
			try {	
				this.age = Integer.parseInt(input.nextLine());
				if (age >= 0 && age <= 100) {
					break;
				} else {
					System.err.println("Tuổi phải nằm trong khoảng 0 - 100: ");
				}
			} catch (Exception e) {
				System.err.println("Giá trị không hợp lệ, làm ơn nhập số: ");
			}
		}

		System.out.print("Nhập hệ số lương của nhân viên: ");
		//Kiểm tra giá trị nhập vào
		while (true) {
			try {
				this.salaryRate = Double.parseDouble(input.nextLine());
				if (salaryRate >= 0 && salaryRate <= 10) {
					break;
				} else {
					System.err.println("Hệ số lương phải nằm trong khoảng 0 - 10: ");
				}
			} catch (Exception e) {
				System.err.println("Giá trị không hợp lệ, làm ơn nhập số: ");
			}
		}
		System.out.print("Nhập ngày vào làm của nhân viên: ");
		this.dayStartWork = input.next();
		input.nextLine();
		
		this.numDayOff = inputNumDayOff(input);
		
		int departmentOption = inputDepartmentNumber(input);
		
		switch (departmentOption) {
		case 1:
			// gan department
			Department itDepartment = departmentList.get(0);
			this.department = itDepartment;
			// tang so nhan vien len 1
			itDepartment.setNumStaff(itDepartment.getNumStaff() + 1);
			break;
		case 2:
			this.department = departmentList.get(1);
			department.setNumStaff(department.getNumStaff() + 1);
			break;
		case 3:
			this.department = departmentList.get(2);
			department.setNumStaff(department.getNumStaff() + 1);
			break;
		}

	}
	
	public int inputDepartmentNumber(Scanner input) {
		int departmentNumber = 0;
		System.out.println("1. HC - Hành chính nhân sự");
		System.out.println("2. IT - Công nghệ thông tin");
		System.out.println("3. MKT - Marketing");
		System.out.print("Bạn chọn bộ phận: ");
		//Kiểm tra giá trị nhập vào
		while (true) {
			try {
				departmentNumber = Integer.parseInt(input.nextLine());
				if (departmentNumber > 0 && departmentNumber < 4) {
					break;
				} else {
					System.err.println("Mời nhập giá trị trong khoảng 1 - 3: ");
				}
			} catch (Exception e) {
				System.err.println("Giá trị không hợp lệ, làm ơn nhập số: ");
			}
		}
		
		return departmentNumber;
	}
	
	public int inputNumDayOff(Scanner input) {
		int numDay = 0;
		System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
		//Kiểm tra giá trị nhập vào
		while (true) {
			try {
				numDay = Integer.parseInt(input.nextLine());
				if (numDay >= 0) {
					break;
				} else {
					System.err.println("Số ngày nghỉ phải >= 0: ");
				}
			} catch (Exception e) {
				System.err.println("Giá trị không hợp lê, làm ơn nhập số: ");
			}
		}
		
		return numDay;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalaryRate() {
		return salaryRate;
	}

	public void setSalaryRate(double salaryRate) {
		this.salaryRate = salaryRate;
	}

	public String getDayStartWork() {
		return dayStartWork;
	}

	public void setDayStartWork(String dayStartWork) {
		this.dayStartWork = dayStartWork;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getNumDayOff() {
		return numDayOff;
	}

	public void setNumDayOff(int numDayOff) {
		this.numDayOff = numDayOff;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", age=" + age + ", salaryRate=" + salaryRate + ", dayStartWork="
				+ dayStartWork + ", department=" + department + ", numDayOff=" + numDayOff + "]";
	}

	public abstract String displayInformation();
}
