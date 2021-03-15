package moving.player;

import java.util.Scanner;

public class MovingPlayer {

    public static void main(String[] args) {
        playerClass();
    }
    
    static void playerClass() {
        Scanner scnr = new Scanner(System.in);
        
        Player p1 = new Player();
        
        System.out.println("Player, What Is Your Name?");
        String playerName = scnr.nextLine();
        p1.setName(playerName);
        System.out.println();
        
        System.out.println(p1.getName() + ", Choose Your Class:");
        System.out.println("Bruiser\nTank\nPaladin");
        String playerType = scnr.nextLine();
        p1.setType(playerType);
        System.out.println();
        
        if (playerType.equals("Bruiser") || playerType.equals("bruiser")) {
            p1.power = 75;
            p1.defense = 25;
            p1.energy = 50;
            System.out.println(playerName + ", the " + playerType.toUpperCase());
            System.out.println("Stats:\nPower: " + p1.power + "\nDefense: " 
                    + p1.defense + "\nEnergy: " + p1.energy);
        }
                
        else if (playerType.equals("Tank") || playerType.equals("tank")) {
            p1.power = 50;
            p1.defense = 75;
            p1.energy = 25;
            System.out.println(playerName + ", the " + playerType.toUpperCase());
            System.out.println("Stats:\nPower: " + p1.power + "\nDefense: " 
                    + p1.defense + "\nEnergy: " + p1.energy);
        }
        
        else if (playerType.equals("Paladin") || playerType.equals("paladin")) {
            p1.power = 25;
            p1.defense = 50;
            p1.energy = 75;
            System.out.println(playerName + ", the " + playerType.toUpperCase());
            System.out.println("Stats:\nPower: " + p1.power + "\nDefense: " 
                    + p1.defense + "\nEnergy: " + p1.energy);
        }
        
        else {
            System.out.println("Class Not Found.");
        }
    }
    
}

