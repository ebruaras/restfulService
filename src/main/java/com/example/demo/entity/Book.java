package com.example.demo.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private int page;

}
