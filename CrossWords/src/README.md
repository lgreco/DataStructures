# The crossword puzzle as a data structure

For this **final assignment** we'll be looking at the [classic crossword puzzle](https://en.wikipedia.org/wiki/Crossword). The assignment can be simply stated as follows:

*Write a class to produce crossword puzzles.*

Functionally, your **class Crossword** should produce crosswords with N rows and M columns.

Here's what you should include in your **class Crossword.**

 * **importWords:** a method to read a dictionary file either from local storage or from a website. This is a text file with english words listed alphabetically. One obvious choice is to use an array or an ArrayList for the words imported from the dictionary. A *better* choice would be to use a hash map from the Java Collections Framework to store the imported words according to their length. A sample text file with about 450,000 words is available here (`words.txt`).

* **buildCrossword:** a method to build a puzzle, by selecting an imported word at random and placing it in the middle row of the puzzle, so that its middle letter is at the center column of the puzzle. The most critical requirements here are:
 
  * The number of blocked cells in the puzzle cannot exceed 50% of its total cells.
  * Words cannot be repeated in a puzzle.
  * Every word in the puzzle must be a *legal* word, i.e., a word imported from the provided file.
  * No word with less than 2 letters is allowed.

* **showCrossword:** a method to display the puzzle, followed by its clues: first the *across* clues and then the *down* clues. The method should also provide a summary for the puzzle: its size (e.g., 10 lines by 15 columns), the number of words it contains, and the percentage of grids that are blocked.  For now, you can use the word itself as its clue, as shown below. Notice that the letters in the puzzle grid are shown as upper case only, while in the cues they appear in mixed case. Also noticed that blocked cells are marked with `#`'s
```
+------+------+------+
| 1    | 2    |      |
|   L  |   E  |   O  |
+------+------+------+
| #### |      | #### |
| #### |   D  | #### |
+------+------+------+
|  ... |  ... | ...  |

Across:
 1. Leo
 ...

Down:
 2. Ed
``` 


* **obtainCues:** a method to ask users to type cues for every word in the puzzle, then save the words and their corresponding cues in a local text file, one pair per line, with word and cue separated by comma,

## Ground rules

* It is up to you to determine the return type of the methods above, as well as any parameters that you wish to pass to them.
* Your code must be clean, neat, and well documented.