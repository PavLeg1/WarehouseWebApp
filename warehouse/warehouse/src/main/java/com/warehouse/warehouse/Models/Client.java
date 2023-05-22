package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="clients")
@Data
public class Client { //implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mail")
    private String mail;
    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

//    @Column(name = "roles")
//    @ElementCollection(fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private List<Roles> roles;

//    /**
//     * @UserDetails Methods implementation
//     */
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }

//    public String getPassword() {
//        return password;
//    }

//    public String getUsername() {
//        return username;
//    }

//    /**
//     * @return
//     */
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    /**
//     * @return
//     */
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    /**
//     * @return
//     */
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    /**
//     * @return
//     */
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }


    public void updateClient(Client client) {
        if (client.firstName != null) {
            this.firstName = client.firstName;
        }

        if (client.lastName != null) {
            this.lastName = client.lastName;
        }

        if (client.address != null) {
            this.address = client.address;
        }

        if (client.phone != null) {
            this.phone = client.phone;
        }

        if (client.mail != null) {
            this.mail = client.mail;
        }

        if (client.birthDate != null) {
            this.birthDate = client.birthDate;
        }

        if (client.orders != null) {
            this.orders = client.orders;
        }

        if (client.password != null) {
            this.password = client.password;
        }

        if (client.username != null) {
            this.username = client.username;
        }

//        if (client.roles != null) {
//            this.roles = client.roles;
//        }

    }

    // Connection with ORDER table
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders;
}
