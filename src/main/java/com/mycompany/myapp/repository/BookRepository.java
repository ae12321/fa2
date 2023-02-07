package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Book;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Book entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //
    // https://b1san-blog.com/post/spring/spring-jpa/
    List<Book> findByTitle(String title);
    List<Book> findByTitleContaining(String titlePart);

    // pure query
    @Query(value = "select * from book where title like %?1% limit 1", nativeQuery = true)
    List<Book> findByTitleExtra01(String titlePart);

    // カラム欠けはダメ
    // @Query(value = "select id, 'aa' as title, person_id from book where title like %?1%", nativeQuery = true)
    @Query(value = "select 1 as id, 'aa' as title, null as person_id from book where title like %?1%", nativeQuery = true)
    List<Book> findByTitleExtra02(String titlePart);
}
