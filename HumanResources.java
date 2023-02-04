package quanlynhansu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class HumanResources {
    public static void main(String[] args) {

        List<Staff> staffList = new ArrayList<Staff>();
        //Tạo mẫu 1 số phòng ban
        List<Department> departmentList = new ArrayList<Department>();
        Department itDepartment = new Department("HC", "Hành chính nhân sự", 0);
        Department hrDepartment = new Department("IT", "Công nghệ thông tin", 0);
        Department marketingDepartment = new Department("MKT", "Marketing", 0);
        departmentList.add(itDepartment);
        departmentList.add(hrDepartment);
        departmentList.add(marketingDepartment);


        int choose = 0;
        Scanner input = new Scanner(System.in);
        do {
            showMenu();
            System.out.print("Lựa chọn của bạn: ");
            //Kiểm tra điều kiện giá trị nhập vào
            while(true) {
            	try {
                    choose = Integer.parseInt(input.nextLine());
                    break;
    			} catch (Exception e) {
    				System.err.println("Giá trị nhập không hợp lệ, mời nhập số: ");
    			}
            }
    
            switch (choose) {
                case 1:
                    showStaff(staffList);
                    break;
                case 2:
                    showDepartment(departmentList);
                    break;
                case 3:
                    showStaffByDepartment(staffList, itDepartment, hrDepartment, marketingDepartment);
                    break;
                case 4:
                    addStaff(input, departmentList, staffList);
                    break;
                case 5:
                    searchStaff(input, staffList);
                    break;
                case 6:
                	showStaffSalary(staffList);
                    break;
                case 7:
                    showStaffSalaryInc(staffList);
                    break;
                case 8:
                    showStaffSalaryDec(staffList);
                    break;
                case 0:
                    System.out.println("Cám ơn, hẹn gặp lại !");
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
                    break;
            }
        } while (choose != 0);

    }


    public static void showMenu() {
        System.out.println("*****************************************************");
        System.out.println("=============PHAN MEM QUAN LY NHAN VIEN==============");
        System.out.println("1. Hien thi danh sach nhan vien");
        System.out.println("2. Hien thi cac bo phan trong cong ty");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan");
        System.out.println("4. Them nhan vien moi vao cong ty");
        System.out.println("5. Tim kiem nhan vien theo ten, ma nhan vien");
        System.out.println("6. Hien thi bang luong nhan vien");
        System.out.println("7. Hien thi bang luong nhan vien theo thu tu tang dan");
        System.out.println("8. Hien thi bang luong nhan vien theo thu tu giam dan");
        System.out.println("0. Thoat chuong trinh");
        System.out.println("*****************************************************");
    }
    
    public static void addStaff(Scanner input, List<Department> departmentList, List<Staff> staffList) {
    	System.out.println("1. Thêm nhân viên thông thường");
    	System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ)");
    	int elect1 = 0;
    	System.out.print("Bạn chọn: ");
    	//Kiểm tra điều kiện giá trị nhập vào
    	while(true) {
    		try {	
		        elect1 = Integer.parseInt(input.nextLine());
		        if(elect1 == 1 || elect1 == 2) {
		        	break;
		        }else {
		        	System.out.println("Mời nhập lựa chọn 1 hoặc 2: ");
		        }
			} catch (Exception e) {
				System.err.println("Giá trị nhập không hợp lệ, mời nhập số: ");
			}
    	}
    	
        switch (elect1) {
            case 1:
                Staff epl = new Employee();
                epl.inputInfo(departmentList, input);
                staffList.add(epl);
                System.out.println("Thêm nhân viên thành công");
                break;
            case 2:
                Staff mng = new Manager();
                mng.inputInfo(departmentList, input);
                staffList.add(mng);
                System.out.println("Thêm nhân viên thành công");
                break;
        }
    }

    public static void showStaffSalary(List<Staff> staffList) {
    	System.out.println();
    	if (staffList.size() == 0) {
    		System.err.println("Hiện chưa có nhân viên nào");
        } else {
        	//Hiển thị bảng lương nhân viên
            System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
        			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
            System.out.println();
            for (Staff stf : staffList) {
            	System.out.printf("%s%n", stf.displayInformation());
            }
        }
    	System.out.println();
    }
    
    public static void showStaffSalaryInc(List<Staff> staffList) {
    	System.out.println();
    	if (staffList.size() == 0) {
    		System.err.println("Hiện chưa có nhân viên nào");
        } else {
            //Săp xếp thứ tự nhân viên tăng dần theo lương
            Collections.sort(staffList, new Comparator<Staff>() {
                //@Override
                public int compare(Staff stf1, Staff stf2) {
                    if (stf1.calculateSalary() > stf2.calculateSalary()) {
                        return 1;
                    } else if (stf1.calculateSalary() < stf2.calculateSalary()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            
            //Hiển thị bảng lương nhân viên
            System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
        			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
            System.out.println();
            for (Staff stf : staffList) {
            	System.out.printf("%s%n", stf.displayInformation());
            }
        }
    	System.out.println();
    }
    
    public static void showStaffSalaryDec(List<Staff> staffList) {
    	System.out.println();
    	if (staffList.size() == 0) {
            System.err.println("Hiện chưa có nhân viên nào");
        } else {
        	//Săp xếp thứ tự nhân viên giảm dần theo lương
            Collections.sort(staffList, new Comparator<Staff>() {
                //@Override
                public int compare(Staff stf1, Staff stf2) {
                    if (stf1.calculateSalary() < stf2.calculateSalary()) {
                        return 1;
                    } else if (stf1.calculateSalary() > stf2.calculateSalary()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            
            //Hiển thị bảng lương nhân viên
            System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
        			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
            System.out.println();
            for (Staff stf : staffList) {
            	System.out.printf("%s%n", stf.displayInformation());
            }
        }
    	System.out.println();
    }
    
    public static void searchStaff(Scanner input, List<Staff> staffList) {
    	System.out.println("1. Tìm nhân viên bằng tên");
    	System.out.println("2. Tìm nhân viên bằng mã nhân viên");
    	int elect2 = 0;
    	System.out.print("Bạn chọn: ");
    	//Kiểm tra điều kiện giá trị nhập vào
    	while(true) {
    		try {
		        elect2 = Integer.parseInt(input.nextLine());
		        if(elect2 == 1 || elect2 == 2) {
		        	break;
		        }else {
		        	System.out.println("Mời nhập lựa chọn 1 hoặc 2: ");
		        }
			} catch (Exception e) {
				System.err.println("Giá trị nhập không hợp lệ, mời nhập số: ");
			}
    	}
    	
        boolean match2 = false;
        switch (elect2) {
            case 1:
                System.out.println("Nhập tên nhân viên cần tìm: ");
                String nameSearch = input.nextLine();
                for (Staff stf : staffList) {
                    if (stf.getName().contains(nameSearch)) {
                    	//Hiển thị kết quả nhân viên tìm thấy
                    	System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
                    			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
                    	System.out.println();
                    	System.out.printf("%s%n", stf.displayInformation());
                    	System.out.println();
                        match2 = true;
                    }
                }
                if (match2 == false) {
                    System.out.println("Không tìm thấy nhân viên có tên: " + nameSearch);
                }
                break;
            case 2:
                System.out.println("Nhập mã nhân viên cần tìm: ");
                String idSearch = input.nextLine();
                for (Staff stf : staffList) {
                    if (stf.getId().equalsIgnoreCase(idSearch)) {
                    	//Hiển thị kết quả nhân viên tìm thấy
                    	System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
                    			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
                    	System.out.println();
                    	System.out.printf("%s%n", stf.displayInformation());
                    	System.out.println();
                        match2 = true;
                    }
                }
                if (match2 == false) {
                    System.out.println("Không tìm thấy nhân viên có id: " + idSearch);
                }
                break;
        }
    }
    
    public static void showStaffByDepartment(List<Staff> staffList, Department itDepartment, Department hrDepartment, Department marketingDepartment  ) {
    	
    	//Tạo các phòng ban tương ứng, đưa staff vào từng phòng thích hợp
    	List<Staff> itStaffs = new ArrayList<>();
        List<Staff> hrStaffs = new ArrayList<>();
        List<Staff> marketingStaffs = new ArrayList<>();
        for (Staff staff : staffList) {
            if (staff.getDepartment().getDepartmentId().equals(itDepartment.getDepartmentId())) {
                itStaffs.add(staff);
            } else if (staff.getDepartment().getDepartmentId().equals(hrDepartment.getDepartmentId())) {
                hrStaffs.add(staff);
            } else if (staff.getDepartment().getDepartmentId().equals(marketingDepartment.getDepartmentId())) {
                marketingStaffs.add(staff);
            }
        }
        //Hiển thi Danh sách nhân viên theo phòng ban
        System.out.println("Hành chính nhân sự");
        System.out.println("------------------------------------------");
        System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
    			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
        System.out.println();
        for (Staff stf : hrStaffs) {
            System.out.printf("%s%n", stf.displayInformation());
        }
        System.out.println();
        System.out.println();
        System.out.println("Công nghệ thông tin");
        System.out.println("------------------------------------------");
        System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
    			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
        System.out.println();
        for (Staff stf : itStaffs) {
        	System.out.printf("%s%n", stf.displayInformation());
        }
        System.out.println();
        System.out.println();
        System.out.println("Marketing");
        System.out.println("------------------------------------------");
        System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
    			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
        System.out.println();
        for (Staff stf : marketingStaffs) {
        	System.out.printf("%s%n", stf.displayInformation());
        }
        System.out.println();
    }
    
    public static void showDepartment(List<Department> departmentList) {
    	System.out.println();
    	if (departmentList.size() == 0) {
            System.err.println("Hiện chưa có phòng ban nào");
        } else {
        	//Hiển thị tên bộ phận
        	System.out.printf("%-12s| %-25s| %-30s", "Mã bộ phận", "Tên bộ phận", "Số lượng nhân viên hiện tại");
        	System.out.println();
            for (Department d : departmentList) {
                System.out.printf("%s%n", d);
            }
        }
    	System.out.println();
    }
    
    public static void showStaff(List<Staff> staffList) {
    	System.out.println();
    	if (staffList.size() == 0) {
            System.err.println("Hiện chưa có nhân viên nào");
        } else {
        	//Hiển thị danh sách nhân viên
        	System.out.printf("%-15s| %-20s| %-8s| %-15s| %-15s| %-15s| %-20s| %-25s| %-15s", 
        			"Mã nhân viên", "Tên nhân viên", "Tuổi", "HS lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
        	System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	for (Staff stf : staffList) {
                System.out.printf("%s%n", stf.displayInformation());
            }
        }
    	System.out.println();
    }
}








