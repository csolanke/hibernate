package com.cds.org.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name ="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String name;

    private String lastname;

    @ElementCollection(fetch = FetchType.EAGER)
            @JoinTable(name="student_address",
                    joinColumns = @JoinColumn(name="student_Id")
            )
//            @CollectionId(columns = {@Column(name="address_Id")},generator = "hilo-gen",
//            type = @Type(type="long"))

    Collection<Address> addressList = new ArrayList<>();





    public Student() {
    }

    public Student(Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }
}
