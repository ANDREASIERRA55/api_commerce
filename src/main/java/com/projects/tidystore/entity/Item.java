package com.projects.tidystore.entity;

import java.util.Optional;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Room room;

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
