/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fpt.mvc.controller.BaseController;
import com.fpt.mvc.helper.MVCHelper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sonnt
 */
public abstract class BaseRequiredLoginController extends BaseController {

    public void checkLogin()
    {
        HttpSession session = request.getSession(true);
        Object obj = session.getAttribute(MVCHelper.SESSION_ACCOUNT_LOGIN);
        if(obj == null){
            try {
                endPreProcess(PROCESS_END); //this method notify the BaseController that
                //the current process will be ended immediately
                response.getWriter().println("access denied!");
            } catch (IOException ex) {
                Logger.getLogger(BaseRequiredLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            endPreProcess(PROCESS_CONTINUE); //process will continue
        }
        
    }
    
 
    
    
}
