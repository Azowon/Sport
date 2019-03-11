/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 00010130
 */
public class Player {
    
    int number;
    boolean win = false;
    
    Player(int number)
    {
        this.number = number;
    }
    
    public void setNumber(int number)    {
        this.number = number;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public void setWin(boolean win)
    {
        this.win = win;
    }
    
    public boolean getWin()
    {
        return win;
    }

}
