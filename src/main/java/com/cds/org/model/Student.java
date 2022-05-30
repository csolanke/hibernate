package com.cds.org.model;

import javax.persistence.*;

@Entity
@Table(name ="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String name;

    private String lastname;

    @Embedded
   @AttributeOverrides({@AttributeOverride(
           name = "street",
           column = @Column(name = "home_street_name")
   ),
           @AttributeOverride(
                   name = "state",
                   column = @Column(name = "home_state_name")
           ),
           @AttributeOverride(
                   name = "city",
                   column = @Column(name = "home_city_name")
           ),
           @AttributeOverride(
                   name = "pincode",
                   column = @Column(name = "home_zipcode")
           )
   } )
    private Address homeAddress;

    @Embedded
    private Address officeAddress;




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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }
}
