//Michal Kornacki
//ID:22361979
public class DictionaryDriver {
    public static void main(String[] args){
        //Dictionary instance for testing
        //Dictionary myDictionary = new Dictionary("textDocument.CSV", 1, 100);
        if(args.length !=3){
            System.out.println("arguments passed incorrectly");
        }
        
        String filePath = args[0];
        int shortest = Integer.parseInt(args[1]);
        int longest = Integer.parseInt(args[2]);
        Dictionary myDictionary = new Dictionary(filePath, shortest, longest);


        //testing add method by adding a word in lower case
        myDictionary.add("Bone");
        //testing add method by adding a word that is already present in the list(the programme wont add it because the set cant contain duplicate elements )
        myDictionary.add("after");
        //testing add method with mix of lower and upper case characterts
        myDictionary.add("ZeBRa");

        //prints out a random word from the list
        System.out.println("Random word: "+ myDictionary.nextWord());

        //checks if the word happy is in the dictionary
        System.out.println("Check for word \"happy\" in the dictionary: "+ myDictionary.inDictionary("Happy"));
        //check if the previously added word is in the dictionary
        System.out.println("Check for word \"zebra\" in the dictionary: "+ myDictionary.inDictionary("zebra"));

        myDictionary.display();
        
    }
}
