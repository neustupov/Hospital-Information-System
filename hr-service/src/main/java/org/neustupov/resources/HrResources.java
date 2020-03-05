package org.neustupov.resources;

import java.util.Arrays;
import java.util.List;
import org.neustupov.models.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResources {

  private List<Employee> employees =
      Arrays.asList(new Employee("100100", "Mark", "Zuker", "Dentist"),
          new Employee("100101", "Oliver", "Stoun", "Surgeon"),
          new Employee("100102", "Tris", "Merigold", "Urologist"));

  @RequestMapping("/employees")
  public List<Employee> getEmployees(){
    return employees;
  }

  @RequestMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable("id") String id){
    return employees.stream()
        .filter(employee -> employee.getId().equals(id))
        .findAny()
        .orElse(null);
  }
}
