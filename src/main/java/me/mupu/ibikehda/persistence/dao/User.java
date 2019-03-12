package me.mupu.ibikehda.persistence.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserID")
    private long userID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "isAdmin")
    private boolean isAdmin;

    public User(String username, String password) {
        this(username, password, false);
    }

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

}
