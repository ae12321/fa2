package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;

// need
@Entity
public class CustomDTO implements Serializable {

    // https://blog.ksoichiro.com/ja/post/2016/12/spring-data-jpa/
    // 解決策2

    private static final long serialVersionUID = 1L;

    // need
    public CustomDTO(Long id, String name, Integer age, String title) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.title = title;
    }

    // need
    @Id
    // リクエストボディにidをいれなくていい、id=nullで連携される、{ "name": string; "age": number; "title": string; }を渡せばいい
    @JsonIgnore
    private Long id;

    private String name;
    private Integer age;
    private String title;

    // need
    public CustomDTO() {}

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomDTO [id=" + id + ", name=" + name + ", age=" + age + ", title=" + title + "]";
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
