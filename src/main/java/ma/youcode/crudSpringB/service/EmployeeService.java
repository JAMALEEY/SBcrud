package ma.youcode.crudSpringB.service;

import ma.youcode.crudSpringB.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public void saveEmployee(Employee employee);
    public Employee readOneEmployee(Long idEmployee);
    public void deleteEmployee(Long idEmployee);

}
