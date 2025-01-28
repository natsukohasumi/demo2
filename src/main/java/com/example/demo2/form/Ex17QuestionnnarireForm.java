package com.example.demo2.form;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Ex17QuestionnnarireForm {

    @NotBlank(message = "値を入力してください")
    @Size(min = 1, max = 127, message = "1桁以上127桁以下で入力してください")
    private String name;

    @Size(min = 1, max = 127, message = "1桁以上127桁以下で入力してください")
    private String email;

    @NotNull(message = "1つ選択してください")
    private String gender;

    @NotEmpty(message = "1つ以上選択してください")
    private List<Integer> hobbyList;

    private List<Integer> languageList;

    @NotBlank(message = "1桁以上2000桁以下で入力してください")
    private String other;
    
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public List<Integer> getHobbyList() {
        return hobbyList;
    }
    public void setHobbyList(List<Integer> hobbyList) {
        this.hobbyList = hobbyList;
    }
    
    public String getOther() {
        return other;
    }
    public void setOther(String other) {
        this.other = other;
    }
    public List<Integer> getLanguageList() {
        return languageList;
    }
    public void setLanguageList(List<Integer> languageList) {
        this.languageList = languageList;
    }
    

    
}
