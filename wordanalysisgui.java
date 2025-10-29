
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class wordanalysisgui {
    private File selectedFile1=new File("C:\\Users\\austi\\OneDrive\\Desktop\\codework\\articles\\test.txt");
    private File selectedFile2=new File("articles\\tigerwoods1.txt");
    private File selectedFile3=new File("C:\\Users\\austi\\OneDrive\\Desktop\\codework\\articles\\test.txt");
    private JTable table1;
    public wordanalysisgui(){
        JFrame frame = new JFrame("Word Analysis GUI");
        frame.setLayout(null);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button button1 = new Button("Browse");
        Button button2 = new Button("Browse");
        Button button3 = new Button("Browse");

        Button button4 = new Button("Analyze");

        JLabel label1 = new JLabel("Article 1");
        JLabel label2 = new JLabel("Article 2");
        JLabel label3 = new JLabel("Article 3");

        
        
        
        button1.setBounds(200, 300, 80, 30);
        button2.setBounds(300, 300, 80, 30);
        button3.setBounds(400, 300, 80, 30);
        button4.setBounds(500, 300, 80, 30);

        label1.setBounds(200, 250, 200, 30);
        label2.setBounds(300, 250, 200, 30);
        label3.setBounds(400, 250, 200, 30);
      
        
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedFile1 = openFileChooser();
                label1.setText(""+selectedFile1);
                System.out.println(selectedFile1);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedFile2 = openFileChooser();
                label2.setText(""+selectedFile2);
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedFile3 = openFileChooser();
                label3.setText(""+selectedFile3);
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                wordanalysis analysis1=new wordanalysis(selectedFile1);
                
                wordanalysis analysis2=new wordanalysis(selectedFile2);

                wordanalysis analysis3=new wordanalysis(selectedFile3);

                String numwords1=""+analysis1.numberOfWords();
                String numwords2=""+analysis2.numberOfWords();
                String numwords3=""+analysis3.numberOfWords();
                double avg1=analysis1.averageWordLength();
                double avg2=analysis2.averageWordLength();
                double avg3=analysis3.averageWordLength();

                analysis1.wordFrequency();
                analysis2.wordFrequency();
                analysis3.wordFrequency();


               
                String data[][]={{"Number of Words",numwords1,numwords2,numwords3},
                               {"Number of Unique Words",analysis1.numberOfWords()+"",analysis2.numberOfWords()+"",analysis3.numberOfWords()+""},
                               {"Most Common Word",analysis1.mostCommonWord(),analysis2.mostCommonWord(),analysis3.mostCommonWord()},
                               {"Average Word Length",""+avg1,""+avg2,""+avg3},
                               {"Number of stop words removed",""+analysis1.removeStopWords(),""+analysis2.removeStopWords(),""+analysis3.removeStopWords()},
                               {"Positive Words",""+analysis1.getNumPositiveWords(),""+analysis2.getNumPositiveWords(),""+analysis3.getNumPositiveWords()},
                               {"Negative Words",""+analysis1.getNumNegativeWords(),""+analysis2.getNumNegativeWords(),""+analysis3.getNumNegativeWords()},
                               {"Sentiment Score",""+analysis1.getSentimentScore(),""+analysis2.getSentimentScore(),""+analysis3.getSentimentScore()}               
                            };
            
                            
                String colS[]={"",selectedFile1.getName(),selectedFile2.getName(),selectedFile3.getName()};
                

      
                
                table1=new JTable(data, colS);
                JScrollPane scrollPane = new JScrollPane(table1);
                frame.setLayout(new BorderLayout());
                frame.add(scrollPane, BorderLayout.CENTER);
                
                frame.revalidate();
                frame.repaint();
                
                frame.setVisible(true);
                System.out.println(analysis1.averageWordLength());
            }
        });
    }
    public static File openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null); // Opens the dialog

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            System.out.println("File selection canceled.");
            return null;
        }
    }
    
    public static void main(String[] args) {
        new wordanalysisgui();
    }
}