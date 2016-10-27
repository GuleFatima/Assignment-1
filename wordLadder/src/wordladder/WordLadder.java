
package wordladder;
import java.lang.*;
import wordladder.ladder.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;  
import java.util.ArrayList;
import java.util.Scanner;

public class WordLadder {

    public static List<String> words = new ArrayList<String>();
    public static List<List<String>> dictionary = new ArrayList<>();
    
  
    public String[] arr;
    public static split_words myobj;
    public static ladder obj_lad;

 public static ladder getShortestTransformationIterative(String startWord, String endWord, Set<String> dictionary){
if(dictionary.contains(startWord) && dictionary.contains(endWord)){

List<String> path = new LinkedList<String>();
path.add(startWord);

//All intermediate paths are stored in queue.
Queue<ladder> queue = new LinkedList<ladder>(); 
queue.add(new ladder(path, 1, startWord));

//We took the startWord in consideration, So remove it from dictionary, otherwise we might pick it again.
dictionary.remove(startWord);

//Iterate till queue is not empty or endWord is found in Path.
while(!queue.isEmpty() && !queue.peek().equals(endWord))
{
ladder ladder = queue.remove();

if(endWord.equals(ladder.getLastWord())){
 return ladder;
}

Iterator<String> i = dictionary.iterator();
while (i.hasNext()) {
 String string = i.next(); 

 if(differByOne(string, ladder.getLastWord())){

  List<String> list = new LinkedList<String>(ladder.getPath());
  list.add(string);

  //If the words differ by one then dump it in Queue for later processsing.
  queue.add(new ladder(list, ladder.getLength()+1, string));

  //Once the word is picked in path, we don't need that word again, So remove it from dictionary.
  i.remove();
 }
}
}

//Check is done to see, on what condition above loop break, 
//if break because of Queue is empty then we didn't got any path till endWord.
//If break because of endWord matched, then we got the Path and return the path from head of Queue.
if(!queue.isEmpty()){
return queue.peek();
}
}
return null;
}

 public static ladder getShortestTransformationRecursive(String startWord, String endWord, Set<String> dictionary){

  //All Paths from startWord to endWord will be stored in "allPath"
  LinkedList<ladder> allPath = new LinkedList<ladder>();

  // Shortest path will be stored in "shortestPath"
  ladder shortestPath = new ladder(null);  

  List<String> path = new LinkedList<String>();
  path.add(startWord);

  recursiveHelperShortest(startWord, endWord, dictionary, new ladder(path, 1, startWord), allPath, shortestPath);

  return shortestPath;
 }

 public static void recursiveHelperShortest(String startWord, String endWord, Set<String> dictionary, ladder ladder, LinkedList<ladder> allPath, ladder shortestPath){
  if(ladder.getLastWord().equals(endWord)){

   // For storing all paths
   allPath.add(new ladder(new LinkedList<String>(ladder.getPath()))); 

   //For storing the shortest path from among all paths available
   if(shortestPath.getPath()==null || shortestPath.getPath().size()>ladder.getPath().size()){
    shortestPath.setPath(new LinkedList<String>(ladder.getPath()));
    shortestPath.setLength(ladder.getPath().size());
   }
   return;
  }

  Iterator<String> i = dictionary.iterator();
  while (i.hasNext()) {
   String string = i.next();

   if(differByOne(string, ladder.getLastWord()) && !ladder.getPath().contains(string)){

    List<String> path = ladder.getPath();
    path.add(string);

    //We found the new word in intermediate path, Start exploring new word from scratch again. 
    recursiveHelperShortest(startWord, endWord, dictionary, new ladder(path, ladder.getLength()+1, string), allPath, shortestPath);

    //After exploring new word, remove it from intermediate path.
    path.remove(path.size()-1);
   }
  }
 }

 public static boolean differByOne(String word1, String word2)
 {
  if (word1.length() != word2.length()) {
   return false;
  }

  int diffCount = 0;
  for (int i = 0; i < word1.length(); i++) {
   if (word1.charAt(i) != word2.charAt(i)) {
    diffCount++;
   }
  }
  return (diffCount == 1);
 }
  

   
    
    public static void main(String[] args) 
    {
        myobj = new split_words();
        //obj_lad = new ladder();
        words = myobj.readingTXT();//getting the words
        //System.out.print(words);
        dictionary = myobj.sep_dict();
        
        
        System.out.println(dictionary.get(4));
        Set myset = new HashSet(dictionary.get(mynum));
      
            
      String startWord = "TEXT";    String endWord = "FILE";

          ladder result = getShortestTransformationIterative(startWord, endWord, myset);
          //ladder result = getShortestTransformationRecursive(startWord, endWord, dictionary);

          if(result!=null)
          {
           System.out.println(result.getLength() +  result.getPath());
          }
          else
          {
           System.out.println("No Path Found");
          }
 
        

    }
    
}
