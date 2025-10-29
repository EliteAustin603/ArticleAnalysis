


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class wordanalysis {
    //initialize variables
    private article stopWords;
    private article article1;
    private List<String> sentwords;
    private List<Float> sentscores;
    private int numwords;
    private int numnonstopwords;
    private int stopwordsremoved;
    //Constructor for wordanalysis class
    public wordanalysis(File article) {
        
        this.article1 = new article(article);
        sentwords=new ArrayList<>();
        sentscores=new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(new File("articles\\lexicon_scores.txt").toPath());
            for(String line:lines){
                String[] parts=line.split("\t");
                if (parts.length<2){
                    System.out.println(parts[0]+" skipped");
                    continue;
                }
                sentwords.add(parts[0]);
                sentscores.add(Float.parseFloat(parts[1]));
            }
        } catch (Exception e) {
            System.out.println("lexicon file not found");
            System.out.println(e);
        }
        numwords=article1.getWordList().size();
    }
    public int getNumPositiveWords(){
        int count=0;
        for(word w:article1.getWordList()){
            if (sentwords.contains(w.getText())){ 
                if (sentscores.get(sentwords.indexOf(w.getText()))>0){
                    count=count+(1*w.getCount());
                }
                
            }   
        }
        return count;
    }

    public int getNumNegativeWords() {
        int count=0;
        for(word w:article1.getWordList()){
            if (sentwords.contains(w.getText())){ 
                if (sentscores.get(sentwords.indexOf(w.getText()))<0){
                    count=count+(1*w.getCount());
                }
                
            }   
        }
        return count;
    }
    public float getSentimentScore(){
        float score=0;
        for(word w:article1.getWordList()){
            if (sentwords.contains(w.getText())){ 
                score=score+(sentscores.get(sentwords.indexOf(w.getText()))*w.getCount());
            }   
        }
        return score/(numwords-stopwordsremoved);
    }
    //change article class to use word in stead of string
    public article getArticle() {
        
        return article1;
        
        
    }
    public double averageWordLength() {
        int totalLength = 0;
        for (word w : article1.getWordList()) {
            totalLength += w.getText().length();
        }
        return (double) totalLength / article1.getWordList().size();
    }

    //returns the number of words in the article
    public int numberOfWords() {
        return numwords;
    }


    public String mostCommonWord(){
        return article1.getWordList().get(0).getText();
    }

    //returns a list of words and their frequency in the article
    public void wordFrequency() {
        List<word> article2 = new ArrayList<>();
        article2.add(new word(article1.getWordList().get(0).getText(), 0));
        for (word word : article1.getWordList()) {
            for (int i = 0; i < article2.size(); i++) {
                if (word.getText().equals(article2.get(i).getText())) {
                    article2.set(i, new word(word.getText(), article2.get(i).getCount() + 1));
                    break;
                } else if (i == article2.size() - 1) {
                    article2.add(new word(word.getText(), 1));
                    break;
                }
            }
        }
        //order the list by frequency with selection sort
        for (int i = 0; i < article2.size(); i++) {
            for (int j = i + 1; j < article2.size(); j++) {
                if (article2.get(i).getCount() < article2.get(j).getCount()) {
                    word temp = article2.get(i);
                    article2.set(i, article2.get(j));
                    article2.set(j, temp);
                }
            }
        }
        
        article1.setWordlist(article2);
       
        
    }


    //returns the article with stop words removed
    public int removeStopWords() {
        List<word> filtered = new ArrayList<>();
        List<String> lines=new ArrayList<>();
        int count=0;
        try {
            lines = Files.readAllLines(Paths.get("articles/english.txt"));
        } catch (Exception e) {
            System.out.println("stopwords not found");
        }
        
        for (word w : article1.getWordList()) {
            if (!lines.stream().anyMatch(line -> line.contains(w.getText()))) {
                filtered.add(w);   
            }else{
                count++;
            }
        }
        article1.setWordlist(filtered);
        stopwordsremoved=count;
        return count;
    }

    //returns the frequency list as a string
    public String listToString(){
        List <word> words=article1.getWordList();
        String output="";
        for(word w:words){
            output+=w.getText()+" "+w.getCount()+"\n";
        }
        return output;
    }

    public static void main(String[] args) {
        File stopwords=new File("articles/english.txt");
        File articlefile=new File("articles/test.txt");
        wordanalysis analysis=new wordanalysis(articlefile);
        System.out.println("number of stop words removed: "+analysis.removeStopWords());
        analysis.wordFrequency();
        System.out.println(analysis.listToString());
        System.out.print(analysis.numberOfWords());
        
    }


   
}

