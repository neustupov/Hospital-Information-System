package org.neustupov.resources;

import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.neustupov.models.Disease;
import org.neustupov.models.DiseaseList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/pathology")
public class PathologyResources {

  private List<Disease> diseases = Arrays.asList(new Disease("1", "Ashma", "Warm water bath"),
      new Disease("2", "Thyphoid", "Ampicilin capsule"));

  @RequestMapping("/diseases")
  public DiseaseList getDisease(){
    log.info("/diseases  request by Pathology service");
    return new DiseaseList(diseases);
  }

  @RequestMapping("/disease/{id}")
  public Disease getDiseaseById(@PathVariable("id") String id){
    log.info("/disease/{id}  request by Pathology service");
    return diseases.stream()
        .filter(disease -> disease.getId().equals(id))
        .findAny()
        .orElse(null);
  }
}
