package com.cds.org.dao;


import com.cds.org.model.Address;
import com.cds.org.model.Student;
import com.cds.org.model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class Studentdao {


    @Autowired
    private SessionFactory factory;
    public Session getSession(){
        Session session = factory.getCurrentSession();

        if(session==null){
            session = factory.openSession();
        }
        return session;
    }


    public void  saveStudent(Student student){
        Collection<Vehicle> vehicle = student.getVehicle();
        List<Vehicle> vehicles = vehicle.stream().toList();

        for (Vehicle vehicle1 : vehicles) {
            vehicle1.setStudent(student);
        }

        for (Vehicle vehicle1 : vehicles) {
            getSession().save(vehicle1);
        }
        getSession().save(student);


    }

    public List<Student> getStudents(){

        return getSession().createCriteria(Student.class).list();
    }


    public Student getStudentById(Long id){
        Session session = getSession();
        Student student = session.get(Student.class, id);

        // System.out.println(student.getName());

      return student;

    }


}
