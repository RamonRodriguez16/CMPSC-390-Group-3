/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import java.util.Random;
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
    
    //Battle System Beta 
    
    //enemy attacks with different intensity depending on health, gets stronger 
    //the weaker it gets. The player will not do that, but for testing sake 
    //they both will have their attacks be based on health.
    public void attack() {
        int hit = 0;
        Random rand = new Random();
        if(HP == 100) {
            hit = 10;
        }
        else if(HP >= 80 || HP <= 99) {
            hit = 15;
        }
        else if(HP >= 50 || HP <= 79) {
            hit = 20;
        }
        else if(HP <= 49) {
           hit = rand.nextInt(30) + 5;
        }
        //setMessage(name + " attacks with a hit worth " + hit + " hp");
    }
    //this system of defense is not final, just testing whether it works
    public void defend(int hit) {
        int damage = hit;
        if(damage > 0) {
            HP -= damage;
            //message = name + " defended against the attack but still lost " + damage + " hp";
            if (HP <= 0) {
                HP = 0;
                //message += " and died";
            }
        } //else
            //message = name + " blocked the hit";
        //setMessage(message);
    }
}