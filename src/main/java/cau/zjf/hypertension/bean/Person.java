package cau.zjf.hypertension.bean;

import java.util.Date;

public class Person {
    private long id;//用户id
    private String sex;//性别
    private int age;//年龄
    private double times;//得高血压的倍率
    private double rate;//得高血压的概率
    private Date date;//用户测试的时间
    private String parents;
    private String grandparents;
    private String brothers;

    public Person(String sex, int age, double times, double rate, String parents, String grandparents, String brothers) {
        this.sex = sex;
        this.age = age;
        this.times = times;
        this.rate = rate;
        this.parents = parents;
        this.grandparents = grandparents;
        this.brothers = brothers;
    }

    public Person(long id, String sex, int age, double times, double rate, Date date, String parents, String grandparents, String brothers) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.times = times;
        this.rate = rate;
        this.date = date;
        this.parents = parents;
        this.grandparents = grandparents;
        this.brothers = brothers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTimes() {
        return times;
    }

    public void setTimes(double times) {
        this.times = times;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getGrandparents() {
        return grandparents;
    }

    public void setGrandparents(String grandparents) {
        this.grandparents = grandparents;
    }

    public String getBrothers() {
        return brothers;
    }

    public void setBrothers(String brothers) {
        this.brothers = brothers;
    }
}
