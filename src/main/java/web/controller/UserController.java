package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
	public String readUsers(ModelMap model,
                            @ModelAttribute("user") User user) {
		model.addAttribute("users", userService.getAll());
		return "index";
	}

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUser(ModelMap model,
                             @PathVariable ("id") Long id) {
        model.addAttribute("user", userService.get(id));
        model.addAttribute("users",userService.getAll());
        return "index";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}