package ma.youcode.crudSpringB.service;

import ma.youcode.crudSpringB.entity.Employee;
import ma.youcode.crudSpringB.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// we add the @service annotation
@Service
public class EmployeeServiceImpl implements EmployeeService {

    // set up constructor injection using the employeeRepository
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    /* introduced in java8 optional is here to check if the data is present ... if it's not null it's providing the result will allow us to retrieve the data and store it to a variable named employee*/
    @Override
    public Employee readOneEmployee(Long idEmployee) {
        Optional<Employee> result = employeeRepository.findById(idEmployee);
        Employee employee = null;
        if(result.isPresent()) {
            employee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + idEmployee);
        }
        return employee;
        }



    @Override
    public void deleteEmployee(Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
    }
}
