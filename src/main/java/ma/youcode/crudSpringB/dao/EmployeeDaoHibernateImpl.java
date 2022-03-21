package ma.youcode.crudSpringB.dao;

import ma.youcode.crudSpringB.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    // 1) Define a field for entityManager
    private EntityManager entityManager;

    // 2) Add constructor injection


    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query for create (using native hiverbate API)
        Query<Employee> queryCreate = currentSession.createQuery("from Employee", Employee.class);

        // execute the query and get result list
        List<Employee> employees = queryCreate.getResultList();

        //return the results
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println(employee);
        //get the current hibernate session :
        Session currentSession = entityManager.unwrap(Session.class);
        // SAve or update the employee :
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public Employee readOneEmployee(double idEmployee) {
        // get the current hibernate session :
        Session currentSession = entityManager.unwrap(Session.class);
        // get the employee
        Employee oneEmployee = currentSession.get(Employee.class, idEmployee);
        // Return that one employee :
        return oneEmployee;
    }



    @Override
    public void deleteEmployee(double idEmployee) {
    // get the current hibernate session :
        Session currenSession = entityManager.unwrap(Session.class);
        // delete object with the given primary key :
        Query query = currenSession.createQuery(
                "delete from Employee where id=:id_employee"
        );
        query.setParameter(
                "id_employee",
                idEmployee
        );
        query.executeUpdate();
    }
}
