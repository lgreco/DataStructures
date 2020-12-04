# The crossword puzzle as a data structure

For this **final assignment** we'll be looking at the [classic crossword puzzle](https://en.wikipedia.org/wiki/Crossword). The assignment can be simply stated as follows:

*Write a class to produce crossword puzzles.*

Functionally, your **class Crossword** should produce crosswords with N rows and M columns.

Here's what you should include in your **class Crossword.**

 * **importWords:** a method to read a dictionary file either from local storage or from a website. 
   
   * This is a text file with english words listed alphabetically.
   * One obvious choice is to use an array or an ArrayList for the words imported from the dictionary.
   * A *better* choice would be to use a hash map from the Java Collections Framework to store the imported words according to their length.
   * A sample text file with about 450,000 words is available here (`words.txt`).
   * If your code reads the text file as a URL, use a link to this repository (remember to look for the link to the raw file). If your code reads the file from local storage, it should be read from the same folder as your .java file.


* **buildCrossword:** a method to build a puzzle, by selecting an imported word at random and placing it in the middle row of the puzzle, so that its middle letter is at the center column of the puzzle. The most critical requirements here are:
 
  * The number of blocked cells in the puzzle cannot exceed 50% of its total cells.
  * Words cannot be repeated in a puzzle.
  * Every word in the puzzle must be a *legal* word, i.e., a word imported from the provided file.
  * No word with less than 2 letters is allowed.
  

* **showCrossword:** a method to display the puzzle, followed by its clues: first the *across* clues and then the *down* clues. The method should also provide a summary for the puzzle: its size (e.g., 10 lines by 15 columns), the number of words it contains, and the percentage of squares that are blocked.  For now, you can use the word itself as its clue, as shown below. Notice that the letters in the puzzle grid are shown as upper case only, while in the cues they appear in mixed case. Also notice that blocked cells are marked with `#`'s
```
+------+------+------+
| 1    | 2    |      |
|   L  |   E  |   O  |
+------+------+------+
| #### |      | #### |
| #### |   D  | #### |
+------+------+------+
|  ... |  ### | ...  |
          ###
Across:
 1. Leo
 ...

Down:
 2. Ed
``` 

## A driver method
In addition to the methods `importWords`, `buildCrossword`, and `showCrossword`, write a driver method to demonstrate your system. The driver method should be named **driver**, be void, and return no values. It should provide interactivity with the user, as follows:
```java
public void driver() {
    boolean keepRunning = true;
    while (keepRunning) {
        /* 
        Show user a menu of options, e.g., enter two numbers greater than zero
        to create a puzzle with as many rows and columns, or enter zero to exit
        the program.
        
        If N==0 and M==0:
          keepRunning <-- false
        else:
          If user enters N>0 and M>0, build a NxM puzzle as specified in the project.
        
          Show the puzzle.
        
           If implementing the bonus part: 
              ask user if they want to enter cues:
                if yes:
                  go through puzzle words, check to see if they are in the 
                  crosswords_dictionary.txt file and if they are not, 
                  ask user to type a clue, then save it in the file.
           else:
             ask user if they want to produce another puzzle
               if no, keepRunning <-- false
         */
        }
}
```

##BONUS

**obtainCues:** a method to ask users to type cues for every word in the puzzle, then save the words and their corresponding cues in a local text file, one pair per line, with word and cue separated by a comma. This should be a cumulative file, i.e., a user should be asked for a word definition only if that word is not in the file already. Name the file `crosswords_dictionary.txt`. Be mindful that the file may not exist the first time you run the program.


## Ground rules

* It is up to you to determine the return type of the methods above, as well as any parameters that you wish to pass to them.
* Your code must be clean, neat, and well documented.
* You should not be asking how to deal with puzzles that have an even number of columns, or where is the middle of a word with an even number of letters. Make a judgement call and document your choice in comments.

## Test class

Your code will be tested using the following class
```java
public class Test270Final {
    public static void main(String[] args) {
        Crossword demo = new Crossword();
        demo.driver();
    }
}
```
If your code fails to compile or to execute with the class above, it will not be evaluated.

## Evaluation plan

* 20%: Your code must be neat, clean, and readable.

* 20%: Your code must be documented. Each method should be described sufficiently at its top (you are welcome to use Javadoc if you wish). This introductory description must narrate the tasks performed, and the reason you need them. You don't have to provide a line-by-line commentary, but you are expected to describe critical parts of your code.

* 30%: Correctness: the result is a proper crossword puzzle, properly numbered, and neatly displayed.

* 15%: Choice of underlying data structures and your reasoning for them. Obviously, a NxM grid lends itself nicely to an array structure. And yet a crossword puzzle is as much a collection of intersecting words as a collection of letters. Anchor your Crossword class with a data structure that resonates with your creativity. You may end up with an array, and that's fine, as long as you explain (in comments) what other structures your considered and why you decided to go with arrays. Other structures you may want to consider include ArrayLists, and arrays of LinkedLists. They all have their benefits and their drawbacks. Spend some time putting sketching things first. Consider that in addition to the principal data structure you need to hold your puzzle, you may need supporting structures for the words set and for the contents of the `crossword_dictionary.txt` file.

* 15%: Quality of the user interface (the interaction you code in method **driver).** Is it neat, clean, easy to use?

## Technical support

I will maintain Student Hours (office hours) during the week of 12/7. Emails with the course code (COMP 271) will be answered faster when possible. You must email me your code at least an hour prior to any appointment during the week of 12/7 (or, if you want to meet for any other reason, please email me saying so). When sending an email with a question about the final, attach your code (actual java file; no screenshots).