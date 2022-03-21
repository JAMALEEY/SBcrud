package ma.youcode.crudSpringB.service;

import ma.youcode.crudSpringB.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public void saveEmployee(Employee employee);
    public Employee readOneEmployee(double idEmployee);
    public void deleteEmployee(double idEmployee);

}
