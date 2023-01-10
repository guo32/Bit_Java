package day0110;

import java.util.Scanner;

/*
사원 관리 프로그램을 작성하시오.
단, 사원 정보(사원 번호, 이름, 직급, 소속 부서, 연봉)은 하나의 구조체로 통제하고
사원 정보 입력, 출력은 별개의 메소드를 통하여 관리합니다.
 */
public class Ex03Emp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. 사원 정보 입력
        Employee employee = inputEmployee(scanner);

        // 2. 사원 정보 출력
        printEmployee(employee);
    }

    public static Employee inputEmployee(Scanner scanner) {
        Employee employee = new Employee();

        System.out.print("사원 번호 입력: ");
        employee.id = scanner.nextInt();
        System.out.print("사원 이름 입력: ");
        employee.name = scanner.next();
        System.out.print("직급 입력: ");
        employee.position = scanner.next();
        System.out.print("소속 부서 입력: ");
        employee.department = scanner.next();
        System.out.print("연봉 입력: ");
        employee.income = scanner.nextInt();

        return employee;
    }

    public static void printEmployee(Employee employee) {
        System.out.printf("사원 번호: %d 이름: %s\n", employee.id, employee.name);
        System.out.printf("직급: %s 소속 부서: %s\n", employee.position, employee.department);
        System.out.printf("연봉: %d만원\n", employee.income);
    }
}
