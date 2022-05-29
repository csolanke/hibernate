package com.cds.org.dao;


import com.cds.org.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

        getSession().save(student);


    }

    public List<Student> getStudents(){

        return getSession().createCriteria(Student.class).list();
    }


}