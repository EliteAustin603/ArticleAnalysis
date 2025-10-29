import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class article {
    private File file;
    private Scanner scanner;
    private List<word> wordlist;
    public article(File filepath) {
        wordlist = new ArrayList<>();
        this.file = filepath;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordlist.add(new word(word, 1));
            }
        } catch (IOException e) {
            System.out.println("error reading file: " + filepath);
            e.printStackTrace();
        }
        
    }
    public void setWordlist(List<word> wordlist) {
        this.wordlist = wordlist;
    }
    
    public List<word> getWordList(){
        return wordlist;
    }
}
