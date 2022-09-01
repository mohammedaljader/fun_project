package com.example.backend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Card {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false,length = 36)
    private String cardId;
    private String cardName;
    @OneToMany(mappedBy = "card",
            cascade= {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST })
    @JsonIgnore
    private List<Task> tasks;

}
