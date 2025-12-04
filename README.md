Milestone 1 Completed 10/15/2025
Group 2 Austin Roberts, Robert Janish, Grayson Kamadeu
Project is made of three code files, article.java, word.java, and wordanalysis.java
The project works by selecting txt files to be analyzed in the word analysis class. The constructor for the wordanalysis.java file makes the slected txt files into article object.
the article takes the file path of the article and turns it into a list of word objects. each word object contains the word as well as how many times the word apears in the article.

All of the methods used to find statistics of the article are inside the wordanalysis.java file.
these methods are:

numberOfWords()
takes no arguments and returns a int of the number of words in a article. Usses the .size() function to find the size. made by Grayson

numberOfUniqueWords()
the same things as number of words but needs to be called after the list of words has been sorted by frequency. Made by Grayson

wordFrequency()
takes a article and finds how many times each word appears in the article. this number is stored in the word object as the field count. next once every word has been assigned a count,
the words in the list are sorted from most common to least common word. returns the list when finished. Made by Austin

removeStopWords()
takes a article and the stopwords file and removes all occurances of the stopwords in the article. uses enhanced for loop to go through each word in the article and finds if it is in the stopwords file.
if it is not in the stopwords, then it is added to the filtered list. returns the filtered list. Made by Austin

listToString()
takes a article and formats the list into a string to be printed made by Robert



There are more methods in the article and word class:

In the Article Class:

constructor takes the filepath of the file and useses a scanner to get every word from the txt file into a list. Made by Austin

setWordList() sets the word list of the article object void return type. made by austin

getWordLIst() returns the word list of the article object. made by austin

In the Word Class:

Constructor takes the text and the count and sets the fields of text and count. made by austin

getCount() returns the count or how many times the word appears in the article. made by austin

setCount() sets the count or how many times the word appears. made by austin

setText() sets the text of the word. made by austin


Additionally both Robert and Grayson helped find the articles to be used as well as the stop words.
UML Class Diagram saved in the git as well


Milestone 2 completed:
wordanalysisgui added which allows users to select the article they want to find data on then run analysis. One of the biggest changes we made was using the lexicon file to find the scores of every word to calculate the sentiment. 

Inside the wordanalysis.java file we added many new methods:

mostCommonWord() finds the most common word in each article made by Grayson

getNumPositiveWords() find how many words after stopwords have been removed that have a positive sentiment value Made by Austin

getNumNegativeWords() find how many words after stopwords have been removed that have a negative sentiment value Made by Austin

getSentimentScore() compares the total score of sentiment vs the number of words in the article to get a overall score made by Austin

in the wordanalysisgui.java file we added functionallity to calculate the average word length of the article to find out which uses the richest vocabulary made by Grayson

We Also show the most common words of each article in the gui. Made by Grayson

Additionally we added functionallity to count how many stop words get removed. Made by Austin

UML Class Diagram Updated and screenshot of testing added.

Milestone 3 Completed:

updated wordanalysigui.java to fix uniuqe words problem. By Austin 

updated test screenshot by Robert

updated uml class diagram by Grayson

Overall, I think our code is pretty good quality. evreything works as intended and is easy to understand for users. Additionally, we stress tested the gui to make it ressiliant. To improve the code we could use lambda functions to make a more efficient program and maybe improve the GUI.

