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
import java.util.ArrayList;


/**
 *
 * @author sonnt
 */

@DBTable(name = "StudentTBL", schema = "")
public class Student implements DBEntity, com.fpt.mvc.model.ModelEntityInstance{
    @DBField(autoGenerate = true, id = true, name = "studentID",
             type = DBField.INT)
    private int studentID;
    
    @DBField(name = "name",
             length = "150", type = DBField.STRING)
    private String name;
    
    @DBField(name = "displayName",
             length = "150", type = DBField.STRING)
    private String displayName;
    
    //apply some designs here, so you can init the DBContex once.
    SQLServerDBContext db = new SQLServerDBContext("localhost",
                "SQLEXPRESS", "1433", "JWebMVCDemo", "sonnt", "12345678");
    
    public Student()
    {
        
    }
    
    public Student(int studentID, boolean isLoaded)
    {
        this.studentID = studentID;
        if(isLoaded)
        {
            db.getOne(this); //i don think this is a good way, but if you want 
                             //to try better design, let do it.
        }
    }
    
    public Student(String name,String displayName) {
        this.name = name;
        this.displayName = displayName;
    }
    
    public Student(int studentID, String name,String displayName) {
        this.studentID = studentID;
        this.name = name;
        this.displayName = displayName;
    }
    
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }



    @Override
    public void insert() {
        db.insert(this);
    }

    @Override
    public void update() {
        db.update(this);
    }

    @Override
    public void delete() {
        db.delete(this);
    }

   
    
    
}
