package com.example.rabittesttask.advertisement;

import com.example.rabittesttask.user.User;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advertisements")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private User user;


    public Advertisement(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
        user.getAdvertisements().add(this);
    }
}
