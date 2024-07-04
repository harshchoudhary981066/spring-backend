package org.example.service;

import org.example.exception.EmployeeException;
import org.example.model.Employee;
import org.example.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public Employee addEmployee(@RequestBody Employee employee) throws EmployeeException {
        Optional<Employee> byId = dao.findById(employee.getId());
        if (byId.isPresent())
            throw new EmployeeException("employee object already present with id " + employee.getId());
        else
            return dao.save(employee);
    }

    public List<Employee> getAllEmployee() throws EmployeeException {
        if (dao.findAll().isEmpty())
            throw new EmployeeException("employee list is empty");
        else
            return dao.findAll();
    }
}
