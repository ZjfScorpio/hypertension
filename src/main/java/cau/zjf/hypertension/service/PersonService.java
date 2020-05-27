package cau.zjf.hypertension.service;

import cau.zjf.hypertension.bean.Person;
import cau.zjf.hypertension.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public int addPerson(Person person){
        return personDao.addPerson(person);
    }

    public List<Person> selectPersons(){
        return personDao.selectPersons();
    }

    public Person selectById(long id){
        return personDao.selectById(id);
    }

    public int deleteById(long id){
        return personDao.deleteById(id);
    }
}
