package com.mycompany.myapp.custom;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;

@RestController
@RequestMapping("/api")
@Transactional
public class CustomResource {

    private final Logger log = LoggerFactory.getLogger(CustomResource.class);

    private static final String ENTITY_NAME = "person";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CustomRepository customRepository;

    public CustomResource(CustomRepository customRepository) {
        this.customRepository = customRepository;
    }

    @GetMapping("/custom_01")
    public ResponseEntity<List<CustomDTO>> deletePerson() {
        log.debug("REST request to delete Person : {}", "id");

        System.out.println("");
        System.out.println("");
        List<CustomDTO> lists = customRepository.findCustom();
        lists.stream().forEach(obj -> System.out.println(obj));
        System.out.println("");
        System.out.println("");

        System.out.println(lists);

        return ResponseEntity.ok().body(lists);
        // return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, "")).build();
    }

    @PostMapping("/custom_02")
    public ResponseEntity<List<CustomDTO>> asdfasdfasdf(@RequestBody CustomDTO customDTO) {
        log.debug("REST request to delete Person : {}", "id");

        System.out.println("");
        System.out.println("");
        System.out.println(customDTO);
        System.out.println("");
        System.out.println("");

        List<CustomDTO> lists = customRepository.findCustom();

        return ResponseEntity.ok().body(lists);
        // return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, "")).build();
    }
}
