/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appsdeveloperblog.ws.io.dao.impl;

import com.appsdeveloeperblog.ws.utils.HibernateUtils;
import com.appsdeveloperblog.ws.io.dao.Database;
import com.appsdeveloperblog.ws.io.entity.UserProfileEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author skargopolov
 */
public class MySQLDAO implements Database {

    Session session;

    public void openConnection() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        this.session = sessionFactory.openSession();
    }

    public UserProfileEntity saveUserProfile(UserProfileEntity userProfile) {

        this.session.beginTransaction();
        this.session.save(userProfile);
        this.session.getTransaction().commit();

        return userProfile;
    }

    public void closeConnection() {
        this.session.close();
    }
}
