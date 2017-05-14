/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.ws.entrypoints;

import com.appsdeveloperblog.ws.service.UsersService;
import com.appsdeveloperblog.ws.service.impl.UsersServiceImpl;
import com.appsdeveloperblog.ws.shared.dto.UserProfileDto;
import com.appsdeveloperblog.ws.ui.rest.UserProfile;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author skargopolov
 */
@Path("/users")
public class Users {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserProfile createUserProfile(UserProfile userProfile) {

        UserProfile returnValue = null;
        
        UserProfileDto userProfileDto = new UserProfileDto();
        BeanUtils.copyProperties(userProfile, userProfileDto);
        
        UsersService usersService = new UsersServiceImpl();
        UserProfileDto storedUserDetails = usersService.saveUser(userProfileDto);
         
        if(storedUserDetails != null && !storedUserDetails.getFirstName().isEmpty())
        {
            returnValue = new UserProfile();
            BeanUtils.copyProperties(storedUserDetails, returnValue);
        }

       // And when we are done, we can return user profile back
        return userProfile;
    }
    
}
