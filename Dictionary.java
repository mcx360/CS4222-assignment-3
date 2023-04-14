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
        ArrayList<String> wordArrayList = new ArrayList<String>();
        HashSet<String> wordHashList = new HashSet<String>();
        while(wordScanner.hasNext()){
                String word = wordScanner.next().toUpperCase().trim();
                if(word.length()<=longest && word.length()>=shortest){ 
                    wordHashList.add(word);
                }
        }
        wordScanner.close();
        wordArrayList.addAll(wordHashList);
        Collections.sort(wordArrayList);
        this.words = wordArrayList;
       }catch(IOException e){
        //the code does not execute anything if the file is not found
    } 
}

    //Adds a String parameter to the list and returns true,unless the String is already in the set in which case false will be returned
    public boolean add(String word){
        HashSet<String> hashList = new HashSet<String>();
        final int hashListSizebeforeAddition = hashList.size();
        boolean added=false;
        hashList.add(word.toUpperCase());
        if(hashList.size() != hashListSizebeforeAddition){
            added = true;
        }
        words.addAll(hashList);
        Collections.sort(words);
        
        return added;
}
    //generate a random word from the list
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

    //returns true or false depending on if the word is found in the Dictionary
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

    public void display(){
        System.out.println(words);   
}

}