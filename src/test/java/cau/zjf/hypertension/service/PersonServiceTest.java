package cau.zjf.hypertension.service;

import cau.zjf.hypertension.bean.Person;
import cau.zjf.hypertension.dao.PersonDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    PersonDao personDao;

    @org.junit.Test
    public void selectPersons() {
        List<Person> personList = personDao.selectPersons();
        System.out.println(personList);
    }
}