/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.scene.control.Button; 
/**
 *
 * @author Alexl
 */
public class HealthBar {
    
    private int HP;// To keep track of the HP Bar
    private String HPBar; //To display the HP Bar
    private String EnemyHPBar;
    private Button button; 
    
    
    public HealthBar(int HP){
        this.HP = HP;
        HPBar = "HP: " + HP;
        button = new Button(getHPBar());
    }

    /**
     * @return the HP
     */
    public int getHP() {
        return HP;
    }

    /**
     * @param HP the HP to set
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * @return the HPBar
     */
    public String getHPBar() {
        return HPBar;
    }

    /**
     * @param HPBar the HPBar to set
     */
    public void setHPBar(String HPBar) {
        this.HPBar = HPBar;
    }

    /**
     * @return the button
     */
    public Button getButton() {
        return button;
    }

    /**
     * @param button the button to set
     */
    public void setButton(Button button) {
        this.button = button;
    }
    
}
