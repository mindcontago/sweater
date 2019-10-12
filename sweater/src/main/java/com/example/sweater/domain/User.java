package com.example.sweater.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usr") //Ссылка на табличку
public class User {
    @Id //Пусть база создаст ID и сама генерирует
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;
    //У пльзователей будет ролевая система - Админ, пользователь и привелег пользователь (модератор)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)//автоматическая Доп таблица для хранения ЕНАМов//КОгда мы заружаем пользователя, его роли хран-ся в отедльной таблице.
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name="user_id"))//Будет хранится в отдельной таблице, для котор мы не // опис mapping
    @Enumerated(EnumType.STRING)
    private Set<Role> roles; //roles - its ENUM we created earlier

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
