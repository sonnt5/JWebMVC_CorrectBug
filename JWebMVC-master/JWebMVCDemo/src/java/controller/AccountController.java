/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fpt.mvc.controller.BaseController;
import com.fpt.mvc.controller.GET;
import com.fpt.mvc.controller.POST;
import com.fpt.mvc.controller.RequestParam;
import com.fpt.mvc.helper.MVCHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Account;
import org.w3c.dom.Attr;

/**
 *
 * @author sonnt
 */
public class AccountController extends BaseController{

   
    @GET(action = "login")
    public void login() throws ServletException, IOException {
        forwardToView(null);
    }
    @POST(action = "login")
    public void processLogin(
            @RequestParam(attr= "username") String username,
            @RequestParam(attr= "password") String password,
            @RequestParam(attr= "url") String url) 
            throws ServletException, IOException {
        
        Account account = new Account(username, password);
        account = account.login();
        if(account!=null)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute(MVCHelper.SESSION_ACCOUNT_LOGIN, account);
            if(url!=null && !url.trim().equals(""))
                response.sendRedirect(url);
            else
                response.getWriter().write("Login successful!");
        }
        else
        {
            forwardToView("account","login",null);
        }
    }
}
