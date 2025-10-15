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


