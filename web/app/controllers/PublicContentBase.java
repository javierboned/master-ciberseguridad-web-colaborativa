package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
        User u_final = User.loadUser(username);
        if(u_final == null){
            User u = new User(username, HashUtils.getMd5(password), type, -1);
            u.save();
        }else{
            System.out.println("Usuario ya registrado");
        }
        registerComplete();
    }
    public static void registerComplete(){
        render();
    }
}
