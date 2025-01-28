package com.example.demo2.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo2.domain.Questionnaire;
import com.example.demo2.form.Ex17QuestionnnarireForm;
import com.example.demo2.service.Ex17QuestionnaireService;

@Controller
@RequestMapping("/questionnaire")
public class Ex17QuestionnaireController {

    @ModelAttribute
    public Ex17QuestionnnarireForm setUpForm(){
        return new Ex17QuestionnnarireForm();
    }

    @RequestMapping("")
    public String index(Model model){

        Map<Integer,String> hobbyMap = new LinkedHashMap<>();
        hobbyMap.put(1, "野球");
        hobbyMap.put(2, "サッカー");
        hobbyMap.put(3, "テニス");
        model.addAttribute("hobbyMap", hobbyMap);

        Map<Integer, String> languageMap = new LinkedHashMap<>();
        languageMap.put(1,"Java");
        languageMap.put(2,"C++");
        languageMap.put(3,"Python");
        model.addAttribute("languageMap", languageMap);

        return "questionnaire/ex-17-input";
    }

    @RequestMapping("/create")
    public String create(
        @Validated Ex17QuestionnnarireForm  form
        , BindingResult result
        , RedirectAttributes redirectAttributes
        , Model model){

            if(result.hasErrors()){
                return index(model);
            }

       Questionnaire questionnaire =new Questionnaire();
       BeanUtils.copyProperties(form, questionnaire);

       List<String> hobbyList= new ArrayList<>();
       for (Integer hobbyCode : form.getHobbyList()){
        switch (hobbyCode) {
        case 1:
            hobbyList.add("野球")  ; 
            break;
        case 2:
            hobbyList.add("サッカー")  ; 
            break;
        case 3:
            hobbyList.add("テニス")  ; 
            break;
        }
       }
       questionnaire.setHobbyList(hobbyList);

       List<String> languageList= new ArrayList<>();
       for (Integer languageCode : form.getLanguageList()){
        switch (languageCode) {
        case 1:
            languageList.add("Java")  ; 
            break;
        case 2:
            languageList.add("C++")  ; 
            break;
        case 3:
            languageList.add("Python")  ; 
            break;
        }
       }
       questionnaire.setLanguageList(languageList);

       Ex17QuestionnaireService ex17QuestionnaireService = new Ex17QuestionnaireService();
       questionnaire = ex17QuestionnaireService.save(questionnaire);

       redirectAttributes.addFlashAttribute("questionnaire", questionnaire);

       return "redirect:/questionnaire/ex-17-toresult";

    }

    @RequestMapping("/ex-17-toresult")
    public String ex17Toresult(){
        return "questionnaire/ex-17-result";

    }

}
