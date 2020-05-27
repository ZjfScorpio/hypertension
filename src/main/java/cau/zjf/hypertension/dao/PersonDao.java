package cau.zjf.hypertension.dao;

import cau.zjf.hypertension.bean.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonDao {

    String TABLE_NAME = " person ";
    String INSERT_FIELDS = " sex,age,times, rate,parents,grandparents,brothers";
    String SELECT_FIELDS = "id,sex,age,times, rate,date,parents,grandparents,brothers";

    @Insert({"insert into ", TABLE_NAME, " ( ", INSERT_FIELDS,
            ") values ( #{sex},#{age},#{times},#{rate},#{parents},#{grandparents},#{brothers})"})
    int addPerson(Person person);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME})
    List<Person> selectPersons();

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id} "})
    Person selectById(long id);

    @Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
    int deleteById(long id);
}
