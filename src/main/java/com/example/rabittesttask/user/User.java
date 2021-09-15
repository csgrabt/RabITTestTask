package com.example.rabittesttask.user;

import com.example.rabittesttask.advertisement.Advertisement;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String fullName;
    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Advertisement> advertisements;

    public User(String fullName) {
        this.fullName = fullName;
        this.advertisements = new ArrayList<>();
    }
}

