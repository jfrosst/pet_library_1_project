package org.jfr0st.model;

public class Person {
    private int person_id;
    private String person_fio;
    private int age;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_fio() {
        return person_fio;
    }

    public void setPerson_fio(String person_fio) {
        this.person_fio = person_fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
