import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Analyzer
{
    public static void main(String[] args) throws FileNotFoundException {
        // This program reads the file word by word.
        File file = new File("mytext");
        Scanner scan = new Scanner(file);
        
        Map<String,Integer> map = new HashMap<String, Integer>(); 
        while (scan.hasNext())
        {
            String val = scan.next(); // ensuring word by word, the text is read
            if(map.containsKey(val) == false) // Sets freq as 1 if string isn't in map
                map.put(val,1);
            else //
            {
                int count = (int)(map.get(val)); 
                map.remove(val);  
                map.put(val,count+1); 
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet(); 
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set); // make an array list 
        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() 
        {
            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) 
            {
                return (b.getValue()).compareTo( a.getValue() ); 
//                return (a.getValue()).compareTo( b.getValue() ); 
            }
        } );
        // Setting and printing the list
        for(Map.Entry<String, Integer> i:sortedList){
            System.out.println(i.getKey()+" -> "+i.getValue());
        }
    }
}