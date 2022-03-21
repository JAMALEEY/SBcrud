package ma.youcode.crudSpringB.restControllers;

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
    public Employee readOneEmployee(@PathVariable Long employeeId) {
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
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{idEmployee}")
    // Be aware that the {employeeId} should match the @PathVariable idEmployee name !!!!
    public String deleteEmployee(@PathVariable Long idEmployee) {
        Employee employee = employeeService.readOneEmployee(idEmployee);
        // throw exception if null
        if (employee == null){
            throw new RuntimeException("Employee id not found - " + idEmployee);
        }
        employeeService.deleteEmployee(idEmployee);
        return "Deleted employee with id - " + idEmployee;
    }

}
