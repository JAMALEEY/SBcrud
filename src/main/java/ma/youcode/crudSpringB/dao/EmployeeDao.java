package ma.youcode.crudSpringB.dao;

import ma.youcode.crudSpringB.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public void saveEmployee(Employee employee);
    public Employee readOneEmployee(Long idEmployee);
    public void deleteEmployee(Long idEmployee);


}
