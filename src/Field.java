/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 00010130
 */
public class Field {
     
    int cords;
    boolean marked = false;
    Player player;
    
    Field(int cords)
    {
        this.cords = cords;
    }
    
    public void setCords ( int cord)
    {
        cords = cord;
    }
    
    public int getCords()
    {
        return cords;
    }
    
      public void mark (Player player)
    {
        marked = true;
        this.player = player;
        
    }
      
      public boolean isMarked()
      {
          return marked;
      }
      
      public Player getPlayer()
      {
          return player;
      }
      
    
}
