/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.controller;

import com.usa.ciclo4.elCacharrero.model.User;
import com.usa.ciclo4.elCacharrero.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author solecito
 * 
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")

public class UserController {
@Autowired
private UserService userService;

@GetMapping("/all")
    public List<User> getAll(){return userService.getAll();}


@PostMapping("/new")
@ResponseStatus(HttpStatus.CREATED)
public User save(@RequestBody User user){ return userService.save(user);}  

@GetMapping("/{email}")
public boolean existEmail(@PathVariable("email")String email){
        return userService.getUserByEmail(email);
        }
@GetMapping("/{email}/{password}")
public User existUser(@PathVariable("email")String email,@PathVariable("password")String password){
        return userService.getByEmailPass(email, password);
        }
}    