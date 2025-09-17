
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class wordanalysis {
    //initialize variables
    private article stopWords;
    private article article;
    

    //Constructor for wordanalysis class
    public wordanalysis(File stopwords, File article) {
        this.stopWords = new article(stopwords);
        this.article = new article(article);
        
    }
    //change article class to use word in stead of string


    //returns the number of words in the article
    public int numberOfWords() {
        return article.getWordList().size();
    }

    //returns the number of unique words in the article
    public int numberOfUniqueWords(article a) {
        return a.getWordList().size();
    }

    //returns a list of words and their frequency in the article
    public article wordFrequency(article a) {
        List<word> article1 = new ArrayList<>();
        article1.add(new word(a.getWordList().get(0).getText(), 0));
        for (word word : a.getWordList()) {
            for (int i = 0; i < article1.size(); i++) {
                if (word.getText().equals(article1.get(i).getText())) {
                    article1.set(i, new word(word.getText(), article1.get(i).getCount() + 1));
                    break;
                } else if (i == article1.size() - 1) {
                    article1.add(new word(word.getText(), 1));
                    break;
                }
            }
        }
        //order the list by frequency
        for (int i = 0; i < article1.size(); i++) {
            for (int j = i + 1; j < article1.size(); j++) {
                if (article1.get(i).getCount() < article1.get(j).getCount()) {
                    word temp = article1.get(i);
                    article1.set(i, article1.get(j));
                    article1.set(j, temp);
                }
            }
        }
        
        a.setWordlist(article1);
        return a;
        
    }


    //returns the article with stop words removed
    public article removeStopWords(article a, article stopWords) {
        
        List<word> filtered = new ArrayList<>();

        for (word w : a.getWordList()) {
            for (word stopWord : stopWords.getWordList()) {
                if (w.getText().equals(stopWord.getText())) {
                    break;
                }
                if (stopWords.getWordList().indexOf(stopWord) == stopWords.getWordList().size() - 1) {
                    filtered.add(w);
                }
                
            }
        }
        a.setWordlist(filtered);
        return a;
    }

    //returns the frequency list as a string
    public String listToString(article a){
        List <word> words=a.getWordList();
        String output="";
        for(word w:words){
            output+=w.getText()+" "+w.getCount()+"\n";
        }
        return output;
    }


    public static void main(String[] args) {
        
        wordanalysis analysis1=new wordanalysis(new File("C:\\Users\\austi\\IdeaProjects\\ArticleAnalysis\\src\\english.txt"),new File("C:\\Users\\austi\\IdeaProjects\\ArticleAnalysis\\src\\test.txt"));
        System.out.println("there are "+analysis1.numberOfWords()+" words in the article");
        System.out.println("there are "+analysis1.numberOfUniqueWords(analysis1.article)+" unique words in the article");
        analysis1.article=analysis1.wordFrequency(analysis1.article);
        System.out.println("the word frequency list is:");
        System.out.println(analysis1.listToString(analysis1.article));
        analysis1.article=analysis1.removeStopWords(analysis1.article, analysis1.stopWords);
        System.out.println("the article with stop words removed is:");
        System.out.println(analysis1.listToString(analysis1.article));

    }
}

