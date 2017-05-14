/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.ws.io.dao;

import com.appsdeveloperblog.ws.io.entity.UserProfileEntity;

/**
 *
 * @author skargopolov
 */
public interface Database {
    public void openConnection();
    public UserProfileEntity saveUserProfile(UserProfileEntity userProfile);
    public void closeConnection();
}
