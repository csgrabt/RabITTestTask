package com.example.rabittesttask.advertisement;

import com.example.rabittesttask.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advertisements")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany
    private List<User> users;

    public Advertisement(String title) {
        this.title = title;
        this.users = new ArrayList<>();
    }

    public void setUser(User user) {
        users.add(user);
        user.getAdvertisements().add(this);
    }
}
