package com.kgisl.jndicrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kgisl.jndicrud.dao.EmployeeDAO;
import com.kgisl.jndicrud.model.Employee;

@Controller
@RequestMapping("/")
public class HomeController {
    
    private final EmployeeDAO employeeDAO;

    public HomeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    @GetMapping
    public String index(Model model) {
        model.addAttribute("employees", employeeDAO.getAllEmployees());
        System.out.println(employeeDAO.getAllEmployees());
        return "index";
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable int id, Model model) {
        Employee employee = employeeDAO.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee";
    }

    @GetMapping("/employee/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeDAO.saveEmployee(employee);
        model.addAttribute("message", "Employee saved successfully!");
        return "redirect:/";
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployeeForm(@PathVariable int id, Model model) {
        Employee employee = employeeDAO.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/employee/edit/{id}")
    public String editEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {
        employee.setId(id);
        employeeDAO.updateEmployee(employee);
        model.addAttribute("message", "Employee updated successfully!");
        return "redirect:/";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id, Model model) {
        employeeDAO.deleteEmployee(id);
        model.addAttribute("message", "Employee deleted successfully!");
        return "redirect:/";
    }
}
