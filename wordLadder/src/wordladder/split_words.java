
package wordladder;
import java.io.*;
import java.util.*;
import static wordladder.WordLadder.word_list;


public class split_words 
{
    
    public List<String> readingTXT()
    {
        String txtFile = "src\\d.txt";
        BufferedReader br = null;
        String line = "";
        String txtSplitBy = "\",\"";
        String furtherSplit = "\":";
        List<String> wordList = new ArrayList<String>();
        
        try {
            int i=0;

            br = new BufferedReader(new FileReader(txtFile));
            
            while ((line = br.readLine()) != null) 
            {
                String[] sentence = line.split(txtSplitBy);
                
                //Scanner reader = new Scanner(System.in);  // Reading from System.in i.e; user
                for (int a=0; a < (sentence.length) ;a++)
                { 
                    String[] word = sentence[a].split(furtherSplit);
                    //System.out.println(word[0]);
                    wordList.add(word[0]);
                }
                
                
            }//end while

        }//end try block
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        
        return wordList;
    }// end readingTXT()
    
    public List<List<String>> sep_dict()
    {
        List<List<String>> temp_dict = new ArrayList<>();
        for(String s: word_list) 
        {
            int len = s.length();
            while(temp_dict.size() <= len) 
            {
                temp_dict.add(new ArrayList<String>());
            }
            // add the string to the right list.
            temp_dict.get(len).add(s);
            
        }
        return temp_dict;
       
    }
   
}
