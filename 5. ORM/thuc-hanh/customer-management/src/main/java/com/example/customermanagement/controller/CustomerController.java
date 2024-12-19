package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView viewAllCustomers() {
        return new ModelAndView("list", "customers", customerService.findAll());
    }
    @GetMapping("/create")
    public String viewAddStudent(Model model) {
        model.addAttribute("customer", new Customer());
        return "add";
    }

    @PostMapping("/create")
    public String addCustomer(@ModelAttribute("student")Customer customer,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "add";
        }
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create student successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public String deleteCustomer(@PathVariable(name = "id") int id,
                                RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete student successfully");
        return "redirect:/customer";
    }
}
