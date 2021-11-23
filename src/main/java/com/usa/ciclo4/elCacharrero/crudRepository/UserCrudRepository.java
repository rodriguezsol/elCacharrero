/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.crudRepository;

import com.usa.ciclo4.elCacharrero.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author solecito
 */

public interface UserCrudRepository extends CrudRepository<User,Integer> {
    /**
     * 
     * @Es como en Sql select * from user where user_name=""
     * @return 
     */
   public Optional<User> findByName(String name);
   /**
    * 
    * @select * from user where user_email=""
    *  
    */
   public Optional<User> findByEmail(String Email);
    /**
     * select *FROM user WHERE user_name="" or user_email=""
     */
   public List<User> findByNameOrEmail(String name,String email);
   /**
    * 
    * @param email
    * @param password
    * @return 
    */
   
   public Optional<User> findByEmailAndPassword(String email, String password);
}
