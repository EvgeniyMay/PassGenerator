package com.learning.passGenerator.controller;

import com.learning.passGenerator.dto.PasswordConfigDTO;
import com.learning.passGenerator.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PasswordController {

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/")
    public String getPasswordPage(Model model) {
        model.addAttribute("passwordConfigForm", new PasswordConfigDTO());

        return "index";
    }

    @PostMapping("/")
    public String generatePassword(Model model,
                                   @ModelAttribute("passwordConfigForm")
                                   PasswordConfigDTO passConfig) {
        model.addAttribute("passwordConfigForm", passConfig);

        if(passwordService.isConfigValid(passConfig)) {
            model.addAttribute("password", passwordService.generateByConfig(passConfig));
        } else {
            model.addAttribute("errors", passwordService.getConfigErrors(passConfig));
        }

        return "index";
    }
}
