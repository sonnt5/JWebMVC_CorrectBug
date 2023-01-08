/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fpt.mvc.dao.SQLServerDBContext;
import com.fpt.mvc.model.ModelEntityTable;
import java.util.ArrayList;

/**
 *
 * @author sonnt
 */
public class StudentList implements ModelEntityTable<model.Student> {
    
    //apply some designs here, so you can init the DBContex once.
    SQLServerDBContext db = new SQLServerDBContext("localhost",
                "SQLEXPRESS", "1433", "JWebMVCDemo", "sonnt", "12345678");

    private ArrayList<Student> list;
    

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }
    
    @Override
    public ArrayList<Student> getAll() {
       return db.getAll(Student.class);
    }

    @Override
    public int Count() {
        //this is a stupid to do counting, but iam too lazy for now 
        //write some more code for JORMLight to make it be smarter
        return getAll().size();
    }
    
    
    
}
