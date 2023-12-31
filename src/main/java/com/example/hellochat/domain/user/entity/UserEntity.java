package com.example.hellochat.domain.user.entity;

import com.example.hellochat.domain.board.entity.Board;
import com.example.hellochat.domain.follow.entity.Follow;
import com.example.hellochat.global.util.UserRoleEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long usersId;

    @Column(name = "name")
    private String name;

    @Column(name = "explain")
    private String explain;

    @Column(name = "birth")
    private Integer birth;

    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "authorId")
    private List<Board> posts;

    @OneToMany(mappedBy = "toUser", fetch = FetchType.EAGER)
    private List<Follow> following = new ArrayList<>();

    @OneToMany(mappedBy = "fromUser", fetch = FetchType.EAGER)
    private List<Follow> followers = new ArrayList<>();
}
