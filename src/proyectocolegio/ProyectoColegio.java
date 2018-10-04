/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocolegio;

import controller.loginController;
import model.dao.userDAO;
import view.LoginView;

/**
 *
 * @author Markensi
 */
public class ProyectoColegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /**
         * Tan fácil como crear un objeto de la vista, otro objeto del modelo de datos
         * y un objeto del controlador que se hace responsable del mismo, se le pasan
         * los objetso creados anteriormente y se llama a su metodo asignado a arrancar
         * la vista
         */
        LoginView mainView = new LoginView();
        userDAO userDao = new userDAO();
        
        loginController loginController = new loginController(mainView, userDao);
        
        loginController.startView();
    }
    
}
