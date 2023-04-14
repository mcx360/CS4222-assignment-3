//Michal Kornacki
//ID:22361979
public class DictionaryDriver {
    public static void main(String[] args){
        Dictionary myDictionary = new Dictionary("textDocument.CSV", 1, 100);
        myDictionary.display();
        myDictionary.add("abcDE");
        myDictionary.add("ZZZZZ");
        myDictionary.add("bare");
        myDictionary.display();
        System.out.println(myDictionary.nextWord());
        System.out.println(myDictionary.inDictionary("k"));
    }
}
