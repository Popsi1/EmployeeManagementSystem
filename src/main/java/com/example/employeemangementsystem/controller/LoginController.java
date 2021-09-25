package com.example.employeemangementsystem.controller;


import com.example.employeemangementsystem.Model.Employee;
import com.example.employeemangementsystem.dto.LoginDto;
import com.example.employeemangementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/")
    public String employeeLogin(Model model){
        model.addAttribute("employeeLogin", new LoginDto());
        return "index";
    }

    @PostMapping(value = "/login")
    public String employeeLogin(@ModelAttribute("employeeLogin") LoginDto loginDto, HttpSession session, Model model){
        System.out.println("I'm here right now");
        System.out.println(loginDto);
        String view="";
        Employee user=employeeService.getEmployeeByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        System.out.println(user);
        if(user!=null){


            if(user.getRole().equalsIgnoreCase("admin")){
                session.setAttribute("user",user);
                view= "redirect:viewList";
            }
            else if(user.getRole().equalsIgnoreCase("staff")){
                session.setAttribute("user",user);
                model.addAttribute("staff",user);
                view= "staffView";
            }
        }

        return view;
    }

    @GetMapping(value = "/logOut")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
