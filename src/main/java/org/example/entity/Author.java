package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Author implements Serializable {
    @Id
    private long id;
    private String name;



}
