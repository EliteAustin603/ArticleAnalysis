public class word {
    private String text;
    private int count;
    public word(String text,int count){
        this.text=text;
        this.count=count;
    }
    public String getText(){
        return text;
    }
    public int getCount(){
        return this.count;
    }
    public void setText(String t){
        text=t;
    }

}
