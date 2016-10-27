/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordladder;
import java.util.*;
import wordladder.queue.*;

public class ladder 
{
     private List<String> path;  //For storing path
     private String lastWord;  //For storing last word of path
     private int length;   //Length of the path.

     public ladder(List<String> path) {
      this.path=path;
     }

     public ladder(List<String> path, int length, String lastWord) {
      this.path=path;
      this.length=length;
      this.lastWord=lastWord;
     }
     public List<String> getPath() {
      return path;
     }
     public int getLength() {
      return length;
     }
     public String getLastWord() {
      return lastWord;
     }

     public void setPath(List<String> path) {
      this.path = path;
     }

     public void setLength(int length) {
      this.length = length;
     }

}
