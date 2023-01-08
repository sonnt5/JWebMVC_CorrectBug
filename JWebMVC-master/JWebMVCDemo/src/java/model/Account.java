/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fpt.mvc.dao.DBEntity;
import com.fpt.mvc.dao.DBField;
import com.fpt.mvc.dao.DBTable;
import com.fpt.mvc.dao.SQLServerDBContext;
import com.fpt.mvc.model.ModelEntityInstance;

/**
 *
 * @author sonnt
 */
@DBTable(name = "AccountTBL", schema = "")
public class Account implements ModelEntityInstance, DBEntity {
    
    @DBField(autoGenerate = false, id = true, name = "username",
             length = "150", type = DBField.STRING)
    private String username;

    @DBField(autoGenerate = false, id = false, name = "password",
             length = "150", type = DBField.STRING)
    private String password;
    
    //Create DBContext, it is possible to create DAO here
    SQLServerDBContext db = new SQLServerDBContext("localhost",
                "SQLEXPRESS", "1433", "JWebMVCDemo", "sonnt", "12345678");

    public Account login() {
        Account getone = new Account(username, null);
        db.getOne(getone);
        if (getone.getPassword().equals(this.getPassword())) {
            return getone;
        } else {
            return null;
        }
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void insert() {
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {
    }

}
