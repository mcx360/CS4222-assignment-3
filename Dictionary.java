import java.util.*;
import java.io.*;
//Michal Kornacki
//ID:22361979
public class Dictionary{

    //Instance variable
    private ArrayList<String> words ;

    //Class constructor
    public Dictionary(String filepath, int shortest, int longest){
       try{ 
        File wordsFile = new File(filepath);
        Scanner wordScanner = new Scanner(wordsFile);
        wordScanner.useDelimiter(",|\\s|\n");
        ArrayList<String> list = new ArrayList<String>();
        HashSet<String> hashList = new HashSet<String>();
        while(wordScanner.hasNext()){
                String word = wordScanner.next().toUpperCase().trim();
                if(word.length()<=longest && word.length()>=shortest){ 
                    hashList.add(word);
                }
        }
        list.addAll(hashList);
        Collections.sort(list);
        this.words = list;
    } catch(IOException e){
        //the code does not execute anything if the file is not found
    } 
    }

    public void display(){
        System.out.println(words);
        System.out.println(words.size());   
    }
    public boolean add(String word){
        HashSet<String> hashList = new HashSet<String>();
        ArrayList<String> ArrayListy = new ArrayList<String>();
        final int hashListSizebeforeAddition = hashList.size();
        boolean added=false;
        hashList.add(word.toUpperCase());
        if(hashList.size() != hashListSizebeforeAddition){
            added = true;
        }
        words.addAll(hashList);
        Collections.sort(words);
        //this.words = words;
        
        return added;
    }
    public String nextWord(){
        String nextWord;
        if(words.isEmpty()){
            nextWord="";
        }
        else{
            int randomIndex = (int) (Math.random()*words.size());
            nextWord=words.get(randomIndex);    
        }
        return nextWord;
    }
    public boolean inDictionary(String word){
        boolean containsWord=false;
        Iterator<String> checkInDictionary = words.iterator();
        while(checkInDictionary.hasNext()){
            if(checkInDictionary.next().equalsIgnoreCase(word)){
                containsWord = true;
            }
        }
        return containsWord;
    }
    
}