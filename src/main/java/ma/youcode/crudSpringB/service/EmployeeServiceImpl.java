package ma.youcode.crudSpringB.service;

import ma.youcode.crudSpringB.dao.EmployeeDao;
import ma.youcode.crudSpringB.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// we add the @service annotation
@Service
public class EmployeeServiceImpl implements EmployeeService {

    // set up constructor injection using the employeeDao
    private EmployeeDao employeeDao;
    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }



    // and we add the transactional annotation ( refactor it was in the dao before)
    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Transactional
    @Override
    public Employee readOneEmployee(double idEmployee) {
        return employeeDao.readOneEmployee(idEmployee);
    }


    @Transactional
    @Override
    public void deleteEmployee(double idEmployee) {
        employeeDao.deleteEmployee(idEmployee);
    }
}
