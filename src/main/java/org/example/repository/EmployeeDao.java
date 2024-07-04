package org.example.repository;
import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao   extends JpaRepository<Employee,Integer> {

}
