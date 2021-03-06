package org.neustupov.admissionsservice.resources;

import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.neustupov.admissionsservice.model.DiseaseList;
import org.neustupov.admissionsservice.model.EmployeesList;
import org.neustupov.admissionsservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {

  @Autowired
  private RestTemplate restTemplate;

  private List<Patient> patients = Arrays.asList(new Patient("100000", "Ivan", "Ukraine"),
      new Patient("100001", "Peter", "Poland"),
      new Patient("100002", "Mark", "England"));

  @RequestMapping("/physicians")
  public EmployeesList getPhysicians(){
    log.info("/physicians  request to HR Service");
    return restTemplate.getForObject("http://hr-service/hr/employees", EmployeesList.class);
  }

  @RequestMapping("/diseases")
  public DiseaseList getDiseases(){
    log.info("/diseases  request to Pathology Service");
    return restTemplate.getForObject("http://pathology-service/pathology/diseases", DiseaseList.class);
  }

  @RequestMapping("/patients")
  public List<Patient> getPatients() {
    log.info("/patients  request by Admissions service");
    return patients;
  }

  @RequestMapping("/patients/{id}")
  public Patient getPatientById(@PathVariable("id") String id) {
    log.info("/patients/{id}  request by Admissions service");
    return patients.stream()
        .filter(patient -> patient.getId().equals(id))
        .findAny()
        .orElse(null);
  }
}
