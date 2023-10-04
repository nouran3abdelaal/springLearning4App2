package com.example.apps2.Employees;

import com.example.apps2.models.Employee;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service
public class EmployeeService {
    @Setter
    List<Employee> employeeList = new ArrayList<>(
            List.of(
                    new Employee("1","Ahmed",26, 'M'),
                    new Employee("2","Nouran",23, 'F')

            )
    );
    @Autowired
    @Qualifier("List1")
    List<Employee> myList1;
    @Autowired
    @Qualifier("List2")
    List<Employee> myList2;
    public List<Employee> getAllEmployees() {
        System.out.println(myList1);
        System.out.println(myList2);

        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> editEmployee(Employee employee) {
       employeeList= employeeList.stream()
                .map(existingEmployee -> {
                    if (existingEmployee.getId().equals(employee.getId())) {

                        return employee;
                    } else {
                        return existingEmployee;
                    }
                }).collect(Collectors.toList());
        return employeeList;

    }

    public void deleteEmployee(String id) {
        employeeList.removeIf(existingEmployee->existingEmployee.getId().equals(id));
    }
}
