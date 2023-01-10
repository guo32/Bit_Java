package day0110;

import util.ScannerUtil;

import java.util.Scanner;

public class Ex03Emp_S {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee emp = new Employee();

        insertInfo(emp, scanner);
        printInfo(emp);
    }

    public static void insertInfo(Employee employee, Scanner scanner) {
        // 각종 출력에서 사용할 메시지를 저장할 String 변수 message
        String message;

        // 사원 번호 입력
        message = "사원의 번호를 입력해주세요.";
        employee.id = ScannerUtil.nextInt(scanner, message);

        // 사원 이름 입력
        message = "사원의 이름을 입력해주세요.";
        employee.name = ScannerUtil.nextLine(scanner, message);

        // 사원 직급 입력
        message = "사원의 직급을 입력해주세요.";
        employee.position = ScannerUtil.nextLine(scanner, message);

        // 사원 부서 입력
        message = "사원의 부서을 입력해주세요.";
        employee.department = ScannerUtil.nextLine(scanner, message);

        // 사원 연봉 입력
        message = "사원의 연봉을 입력해주세요.";
        employee.income = ScannerUtil.nextInt(scanner, message);
    }

    public static void printInfo(Employee employee) {
        System.out.println("--------------------------------");
        System.out.println("사원 번호: " + employee.id);
        System.out.println("사원 이름: " + employee.name);
        System.out.println("사원 부서: " + employee.department);
        System.out.println("사원 직급: " + employee.position);
        System.out.println("사원 연봉: " + employee.income);
        System.out.println("--------------------------------");
    }
}
