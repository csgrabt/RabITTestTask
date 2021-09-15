package com.example.rabittesttask.user;

import com.example.rabittesttask.advertisement.Advertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @ManyToMany(mappedBy = "users")
    private List<Advertisement> advertisements;

    public User(String fullName) {
        this.fullName = fullName;
        this.advertisements = new ArrayList<>();
    }
}

