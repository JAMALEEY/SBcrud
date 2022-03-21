package ma.youcode.crudSpringB.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class    Employee {
    // defining fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long id_employee;
    @Column(name = "fname_employee")
    private String fname_employee;

    @Column(name = "lname_employee")
    private String lname_employee;

    @Column(name = "email_employee")
    private String email_employee;
    // defining constructors

    public Employee(Long id_employee, String fname_employee, String lname_employee, String email_employee) {
        this.id_employee = id_employee;
        this.fname_employee = fname_employee;
        this.lname_employee = lname_employee;
        this.email_employee = email_employee;
    }

    public Employee() {
    }

//getters setters

    public String getFname_employee() {
        return fname_employee;
    }

    public void setFname_employee(String fname_employee) {
        this.fname_employee = fname_employee;
    }

    public String getLname_employee() {
        return lname_employee;
    }

    public void setLname_employee(String lname_employee) {
        this.lname_employee = lname_employee;
    }

    public String getEmail_employee() {
        return email_employee;
    }

    public void setEmail_employee(String email_employee) {
        this.email_employee = email_employee;
    }

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }


    //tostring


    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", fname_employee='" + fname_employee + '\'' +
                ", lname_employee='" + lname_employee + '\'' +
                ", email_employee='" + email_employee + '\'' +
                '}';
    }
}
