/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.PaladiumUtil;
import pojo.Tbluser;

/**
 *
 * @author setephen
 */
public class DAOLogin {
    public List<Tbluser> getBy(String uName, String uPass)
    {
        Transaction trans = null;
        Tbluser us = new Tbluser();
        List<Tbluser> user = new ArrayList();
        Session session = pojo.PaladiumUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Tbluser where username=:uName AND password=:uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            us = (Tbluser) query.uniqueResult();
            user = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
       return user;
    }
    


    public String add_user(Tbluser user){
    
        Transaction trans = null;
        Session session = PaladiumUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(user);
            trans.commit();
            return "admin";
        } catch (Exception e) {
            System.out.println(e);
        } return "logingagal";
    }
}
