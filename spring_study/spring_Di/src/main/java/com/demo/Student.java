package com.demo;

import java.util.*;

public class Student {
    private String name;
    private Address address;
    private String[] bookname;
    private List<String> hobbys;
    private Map<String,String> map;
    private Set<String> set;
    private Properties info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getBookname() {
        return bookname;
    }

    public void setBookname(String[] bookname) {
        this.bookname = bookname;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", bookname=" + Arrays.toString(bookname) +
                ", hobbys=" + hobbys +
                ", map=" + map +
                ", set=" + set +
                ", info=" + info +
                '}';
    }

}
