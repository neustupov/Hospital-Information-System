package org.neustupov.resources;

import java.util.Arrays;
import java.util.List;
import org.neustupov.models.Disease;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResources {

  private List<Disease> diseases = Arrays.asList(new Disease("1", "Ashma", "Warm water bath"),
      new Disease("2", "Thyphoid", "Ampicilin capsule"));

  @RequestMapping("/diseases")
  public List<Disease> getDisease(){
    return diseases;
  }

  @RequestMapping("/disease/{id}")
  public Disease getDiseaseById(@PathVariable("id") String id){
    return diseases.stream()
        .filter(disease -> disease.getId().equals(id))
        .findAny()
        .orElse(null);
  }
}
