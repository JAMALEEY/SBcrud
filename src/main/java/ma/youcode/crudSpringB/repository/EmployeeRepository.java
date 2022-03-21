package ma.youcode.crudSpringB.repository;

import ma.youcode.crudSpringB.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /* it's a reposotry provided by SPRNG DATA JPA  which allows us to minimise the boiler code
    * NO MoRE DAO AND DAO IMPLEMENTATION
    * */
}
