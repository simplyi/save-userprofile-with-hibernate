/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.ws.service;

import com.appsdeveloperblog.ws.shared.dto.UserProfileDto;

/**
 *
 * @author skargopolov
 */
public interface UsersService {
    public UserProfileDto saveUser(UserProfileDto user);
}
