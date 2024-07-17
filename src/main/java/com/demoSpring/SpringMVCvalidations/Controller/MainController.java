package com.demoSpring.SpringMVCvalidations.Controller;

import com.demoSpring.SpringMVCvalidations.Entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class MainController {

    //InitBinder will preprocess all the requested coming into our controller
    //The below method will preprocess the string entities coming into our controller by trimming the whitespaces
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/home")
    public String home(Model model){
        String name="Ashish Here ..!";
        model.addAttribute("name",name);
        return "home";
    }

    @GetMapping("/Customer")
    public String customerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "CustomerInfo";
    }

    @PostMapping("/submitform")
    public String submitForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        System.out.println("|"+customer.getLastname()+"|");
        System.out.println("Binding Result: "+bindingResult.toString());
        if(bindingResult.hasErrors()){
            return "CustomerInfo";
        }else {
            return "CustomerHome";
        }
    }
}
