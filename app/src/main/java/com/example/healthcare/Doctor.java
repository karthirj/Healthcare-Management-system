package com.example.healthcare;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Doctor implements Serializable {

    String name;
    String email;
    String specilization;
    String yrs_of_experience;
    String contact_no;
    String availability;
    String password;
    String cpassword;

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", specilization='" + specilization + '\'' +
                ", yrs_of_experience='" + yrs_of_experience + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", availability='" + availability + '\'' +
                ", password='" + password + '\'' +
                ", cpassword='" + cpassword + '\'' +
                '}';
    }

    public Doctor(String name, String email, String specilization, String yrs_of_experience, String contact_no, String availability, String password, String cpassword) {
        this.name = name;
        this.email = email;
        this.specilization = specilization;
        this.yrs_of_experience = yrs_of_experience;
        this.contact_no = contact_no;
        this.availability = availability;
        this.password = password;
        this.cpassword = cpassword;
    }

    public Doctor(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public String getYrs_of_experience() {
        return yrs_of_experience;
    }

    public void setYrs_of_experience(String yrs_of_experience) {
        this.yrs_of_experience = yrs_of_experience;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public Map toHashMap(){
        Map<String, Object> userMap = new HashMap<>();

        userMap.put("name", this.name);
        userMap.put("email", this.email);
        userMap.put("specilization", this.specilization);
        userMap.put("yrs_of_experience", this.yrs_of_experience);
        userMap.put("contact_no", this.contact_no);
        userMap.put("availability", this.availability);
        userMap.put("password", this.password);
        userMap.put("cpassword", this.cpassword);

        return userMap;
    }

    public void toDoctor(HashMap<String,Object> userMap){

        this.name = (String) userMap.get("name");
        this.email = (String) userMap.get("email");
        this.specilization = (String) userMap.get("specilization");
        this.yrs_of_experience = (String) userMap.get("yrs_of_experience");
        this.contact_no = (String)userMap.get("contact_no");
        this.availability = (String) userMap.get("availability");
        this.password = (String) userMap.get("password");
        this.cpassword = (String) userMap.get("cpassword");

    }





}
