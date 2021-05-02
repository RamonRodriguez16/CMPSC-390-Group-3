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
public class EnemyHealthBar {
    private int HP;// To keep track of the HP Bar
    private String EnemyHPBar;
    private Button button; 
    
    
    public EnemyHealthBar(int HP){
        this.HP = HP;
        EnemyHPBar = "Enemy HP: " + HP;
        button = new Button(getEnemyHPBar());
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

    /**
     * @return the EnemyHPBar
     */
    public String getEnemyHPBar() {
        return EnemyHPBar;
    }

    /**
     * @param EnemyHPBar the EnemyHPBar to set
     */
    public void setEnemyHPBar(String EnemyHPBar) {
        this.EnemyHPBar = EnemyHPBar;
    }
    
    
}