/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author eint
 */
public class UserController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
       ModelAndView mv = new ModelAndView("user");
        String out = "all user details";
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
        List result = session.createQuery("from Users").list();
        mv.addObject("users",result);
        session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        
        }
        mv.addObject("message",out);
        return mv;  
    }
    
}
