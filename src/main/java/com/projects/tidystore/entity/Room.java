package com.projects.tidystore.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Item> items;
}
