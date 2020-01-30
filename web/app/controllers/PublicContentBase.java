package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
        if (type != null && (type.equals("teacher") || type.equals("student"))) {
            User u = new User(username, HashUtils.getMd5(password), type, -1);
            u.save();
            registerComplete();
        } else {
            flash("error", "Invalid role");
            register();
        }
    }

    public static void registerComplete(){
        render();
    }
}
