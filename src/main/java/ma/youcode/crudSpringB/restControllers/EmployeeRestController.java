package ma.youcode.crudSpringB.restControllers;

import ma.youcode.crudSpringB.dao.EmployeeDao;
import ma.youcode.crudSpringB.entity.Employee;
import ma.youcode.crudSpringB.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }


    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee readOneEmployee(@PathVariable double employeeId) {
        // alt + enter
        Employee employee = employeeService.readOneEmployee(employeeId);
        if (employee == null) {
            throw new RuntimeException("the employee id " + employeeId + "is not found");
        }
        return employee;
    }


    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        // what to do if we pass an id in the body ? we hard code the id to be null so that it dosent update an already existant id
        employee.setId_employee(null);
        employeeService.createEmployee(employee);
        return employee;
    }
}
