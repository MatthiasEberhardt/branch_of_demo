package com.example.demo.entity.customer;

import com.example.demo.DTO.internDTO.RegistrationDTO;
import com.example.demo.entity.misc.Address;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="CUSTOMER")
public abstract class Customer implements Serializable, UserDetails {

    @Id
    @Column(name="USERNAME")
    private String username;
    //@Column(name="CUSTOMER_ID")
    //private int id;
    @Column(name="ADDRESS")
    private Address address;
    @Column(name="PASSWORD")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Customer() {

    }

    public Customer(RegistrationDTO registrationDTO){
        this.username = registrationDTO.getUsername();
        this.password = registrationDTO.getPassword();
        Address address = new Address();
        address.setCity(registrationDTO.getCity());
        address.setPostalCode(registrationDTO.getPostalCode());
        address.setStreet(registrationDTO.getStreet());
        address.setHouseNr(registrationDTO.getHouseNr());
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*return List.of(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return Customer.this.role.name();
            }
        });*/
        return List.of(()-> Customer.this.role.name());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
