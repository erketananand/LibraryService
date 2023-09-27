package com.ketan.hibernateinheritanceandcascadetypes.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Author extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @Fetch(value= FetchMode.SUBSELECT)
    private Set<Book> books = new HashSet<>();
}
