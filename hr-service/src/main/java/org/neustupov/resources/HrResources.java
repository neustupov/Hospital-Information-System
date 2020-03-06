package org.neustupov.resources;

import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.neustupov.models.Employee;
import org.neustupov.models.EmployeesList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/hr")
public class HrResources {

  private List<Employee> employees =
      Arrays.asList(new Employee("100100", "Mark", "Zuker", "Dentist"),
          new Employee("100101", "Oliver", "Stoun", "Surgeon"),
          new Employee("100102", "Tris", "Merigold", "Urologist"));

  @RequestMapping("/employees")
  public EmployeesList getEmployees(){
    log.info("/employees request by HR service");
    return new EmployeesList(employees);
  }

  @RequestMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable("id") String id){
    log.info("/employees/{id}  request by HR service");
    return employees.stream()
        .filter(employee -> employee.getId().equals(id))
        .findAny()
        .orElse(null);
  }
}
