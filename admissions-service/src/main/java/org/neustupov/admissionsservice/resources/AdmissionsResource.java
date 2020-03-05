package org.neustupov.admissionsservice.resources;

import java.util.Arrays;
import java.util.List;
import org.neustupov.admissionsservice.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {

  private List<Patient> patients = Arrays.asList(new Patient("100000", "Ivan", "Ukraine"),
      new Patient("100001", "Peter", "Poland"),
      new Patient("100002", "Mark", "England"));

  @RequestMapping("/patients")
  public List<Patient> getPatients() {
    return patients;
  }

  @RequestMapping("/patients/{id}")
  public Patient getPatientById(@PathVariable("id") String id) {
    return patients.stream()
        .filter(patient -> patient.getId().equals(id))
        .findAny()
        .orElse(null);
  }
}
