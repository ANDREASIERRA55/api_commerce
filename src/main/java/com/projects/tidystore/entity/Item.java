package com.projects.tidystore.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room", nullable = false)
    private String room;

    @Column(name = "shelving", nullable = false)
    private String shelving;

    @Column(name = "section")
    private String section;

    @Column(name = "position")
    private String position;

    @Column(name = "box", nullable = false)
    private String box;

    @Column(name = "name", nullable = false)
    private String name;
}
