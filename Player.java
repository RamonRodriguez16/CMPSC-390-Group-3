/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.player;

public class Player {
    String name;
    int power;
    int defense;
    int energy;
    String type;
    
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    public void setPower(int p) {
        power = p;
    }
    public int getPower() {
        return power;
    }
    public void setDefense(int d) {
        defense = d;
    }
    public int getDefense() {
        return defense;
    }
    public void setEnergy(int e) {
        energy = e;
    }
    public int getEnergy() {
        return energy;
    }
    public void setType(String t) {
        type = t;
    }
    public String getType() {
        return type;
    }
}
