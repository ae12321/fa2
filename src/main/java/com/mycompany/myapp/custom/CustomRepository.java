package com.mycompany.myapp.custom;

import com.mycompany.myapp.domain.Person;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Person entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomRepository extends JpaRepository<CustomDTO, Long> {
    // need
    @Query(
        value = "select p.id id, p.person_name name, p.age as age, b.title title from person as p left outer join book as b on p.id = b.person_id",
        nativeQuery = true
    )
    List<CustomDTO> findCustom();
}
