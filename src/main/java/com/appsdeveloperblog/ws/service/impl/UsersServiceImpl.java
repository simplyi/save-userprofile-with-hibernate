/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.ws.service.impl;

import com.appsdeveloperblog.ws.io.dao.Database;
import com.appsdeveloperblog.ws.io.entity.UserProfileEntity;
import com.appsdeveloperblog.ws.service.UsersService;
import com.appsdeveloperblog.ws.shared.dto.UserProfileDto;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author skargopolov
 */
public class UsersServiceImpl implements UsersService {

    Database database;

    public UserProfileDto saveUser(UserProfileDto userDto) {
        
        UserProfileDto returnValue = null;
        
        UserProfileEntity userEntity = new UserProfileEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        
        // Connect to database 
        try {
            this.database.openConnection();
            UserProfileEntity storedUserEntity = this.database.saveUserProfile(userEntity);
            if(storedUserEntity != null && storedUserEntity.getId()>0)
            {
                returnValue = new UserProfileDto();
                BeanUtils.copyProperties(storedUserEntity, returnValue);
            }
        }  finally {
            this.database.closeConnection();
        }
        
        return returnValue;
    }

}
