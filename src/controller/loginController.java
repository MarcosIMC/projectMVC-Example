/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.dao.userDAO;
import view.LoginView;
import model.vo.user;

/**
 *
 * @author Markensi
 */
public class loginController implements ActionListener{
    private LoginView view = null;
    private userDAO userDao = null;
    private user userVo = null;
    
    /**
     * Constructor el cual obtiene el objeto de la vista y modelo
     * tambien asociamos los metodos get de cada boton de nuestra UI
     * al evento 
     */ 
    public loginController(LoginView view, userDAO userDao){
        this.view = view;
        this.view.getBtnLogin().addActionListener(this);
        this.view.getBtnCloseLogin().addActionListener(this);
        this.userDao = userDao;
    }
   
    //Metodo para arrancar la vista
    public void startView(){
        view.setTitle("Iniciar Sesión");
        view.setVisible(true);
    }

    //Metodo encargado para las acciones de los botones de la vista
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == view.getBtnLogin()){
            String cmpoUser =  view.getCmpoUserLogin().getText();
            String cmpoPass = view.getCmpoPassLogin().getText();
            
            userVo = new user(cmpoUser, cmpoPass);
            
            doLogin(userVo);
            
        }else{
         JOptionPane.showMessageDialog(view, "Hasta pronto");
         System.exit(0);
        }                     
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doLogin(user userVo) {
        
        if(userDao.checkUserLogin(userVo)){
            //logueamos
            System.out.println("LOGUEADO");
        }else{
            JOptionPane.showMessageDialog(view, "Usuario o contraseña erroneas");
            cleanLabels();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void cleanLabels(){
        view.getCmpoPassLogin().setText("");
    }
}
