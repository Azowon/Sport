/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author 00010130
 */
public class UI {
    
    Player player1, player2;
    Field[] fields = new Field[9];
    Scanner scan;
    
    public static void main(String[] args)
    {
        UI main = new UI();
        main.start();
    }
    
    public void start()
    {
        
        createGame();
        StartGame();
        
    }
    
    public void StartGame()
    {
        System.out.println("Wilkommen bei TicTacToe!");
        System.out.println("Die Felder sind von Links oben ausgehend als Koordinaten gekennzeichnet!");
        System.out.println("11 Ist das erste Feld, 12 das 2te usw. bis 33");
        
        int round =1;
        printBoard();
        while(true)
        {
            int playerturn = round % 2 +1;
            System.out.println("Player " + playerturn + " ist am Zug. Bitte eine Koordinate eingeben!");
            int cord = scan.nextInt();
            if(!checkCords(cord))
                {System.out.println("Bitte geben Sie gültige Koordinaten ein!"); continue;}        
            if(playerturn == 1 && !getFields(cord).isMarked())
                {getFields(cord).mark(player1);}
            else if(!getFields(cord).isMarked()) 
                {getFields(cord).mark(player2);}
            else
            {System.out.println("Hier wurde bereits gesetzt!"); continue;}
            
            
            round++;
            printBoard();
            if(win() || round == 10)
            {break;}
        }
        
        if(player1.getWin())
            System.out.println("Player 1 hat gewonnen! Das spiel ging " + --round + " Runden" );
        else if(player2.getWin())
            System.out.println("Player 2 hat gewonnen! Das spiel ging " + --round + " Runden" );
        else
            System.out.println("Untenschieden!");
        
        
        
    }
    
    public boolean checkCords(int cords)
    {
        if(getFields(cords).equals(fields[0]) && cords == 11)
        return true;
        
        else return !getFields(cords).equals(fields[0]);
    }
       
    
    public void createGame()
    {
        player1 = new Player(1); player2 = new Player(2);
        scan = new Scanner(System.in);
        int fieldNumber = 0;
        
        for(int zeilen = 1; zeilen <=3; zeilen++)
        { 
            int cords= zeilen * 10;
            for(int spalten =1; spalten <=3; spalten++)
            {
                cords++;
                fields[fieldNumber] = new Field(cords);
                fieldNumber++;
            }
        }
    }
    
    public void printBoard()
    {
        
        
        
        String board = "_ _ _ _ _ _ _" + "\n" +  "|_"+getMark(fields[0]) + "_|_" + getMark(fields[1])+ "_|_" + getMark(fields[2]) + "_| \n" +
                "|_" +getMark(fields[3]) + "_|_" + getMark(fields[4])+ "_|_" + getMark(fields[5]) + "_| \n" + "|_"+getMark(fields[6]) + 
                "_|_" + getMark(fields[7])+ "_|_" + getMark(fields[8]) + "_|";
        System.out.println(board);
        
      
    }
    
    public String getMark(Field field)
    {
        if(!field.isMarked())
        return " ";
        
        else if(field.isMarked() && field.getPlayer().getNumber() == 1)
        {
            return "x";
        }
        else
            return "o";
    }
    
    public Field getFields(int cord)
    {
        for(Field f : fields)
        {
            if(f.getCords() == cord)
            {
                return f;
            }
        }
        return fields[0];
    }
    
    public boolean win()
    {
        int feld1 =0, feld2 = 1, feld3= 2;
        
        for(int i = 0; i <8; i++)
        {
            
            if(i == 3){
                feld1 = 0;
                feld2 = 3;
                feld3 = 6;        
            }
            if (i == 6){
                feld1 = 0; feld2 = 4; feld3 = 8;
            }
            
            if(i == 7)
            {
                feld1 = 2; 
                feld2 = 4;
                feld3 = 6;
            }
            
            if(fields[feld1].isMarked() && fields[feld2].isMarked() && fields[feld3].isMarked()
                && fields[feld1].getPlayer().equals(fields[feld2].getPlayer())&& fields[feld1].getPlayer().equals(fields[feld3].getPlayer()))
            {fields[feld1].getPlayer().setWin(true); return true; }
            
            if( i < 3){
                feld1 += 3; feld2 +=3; feld3 +=3;    
            }
            if ( i >= 3 && i < 6){
                 feld1 += 1; feld2 +=1; feld3 +=1; 
            }
        }
        return false;
    }     
}
