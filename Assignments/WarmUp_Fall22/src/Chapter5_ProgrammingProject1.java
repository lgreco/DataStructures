/*

Delivers Programming Project 1, Chapter 5, from BJP/5e.

Objective: convert a phrase into Pig Latin.

The pseudocode for this project is straight-forward:

  input: a string with a phrase to convert to Pig Latin
  output: a string with the Pig Latin translation of the input string

  for every word in the input string:
    if word begins with consonant sound:
      add a dash at the end of the word
      move the consonant sound to the end of the word
      add the extension ay
    else:
      add a dash at the end of the word
      add the extension ay

Everything in this pseudocode happens inside a loop that processes every word in
the input string.  Our first concern,  therefore, is how to parse  (i.e,  how to
scan) a string, word by word. There are two ways to accomplish this parsing. One
way is tedious and the other is a breeze.

The tedious way may be tempting,  at the beginning,  because it can be done with
simple programming techniques. Consider, for example, the following string:

  s = "tedious seems easy at the beginning"

We could write a loop over the length of string s, looking for spaces.  Anything
we find between these spaces is a word.  To make things simple for now,  WE  CAN
ASSUME that the input string contains words separated by a single space (except,
of course,  the first and last words).  Here's the starter code,  that parses  a
string and prints its individual words:

    String s = "tedious seems easy at the beginning";
    int word_beginning = 0, index = 0;
    while (index < s.length()) {
        if (s.charAt(index) == ' ' || index == s.length()-1) {
            index = (index == s.length()-1) ? index+1 : index;
            String word = s.substring(word_beginning, index);
            System.out.printf("\n.%s.",word);
            word_beginning = index+1;
        }
        index++;
    }

The code above has a problem. If we want to use it in a method, how do we return
the individual words? Most likely we need a string array, to save them in. This,
in turn,  requires that  we know how many words are in the string,  in the first
place. Which means that we have to traverse the string twice:  once to count how
many spaces  it has and  a second time  to pull out  the words.  A simple string
like the one  we assume to have here (all words, single spaces, no punctuation),
has n+1 words, where n is the number of spaces in it.

There is a simpler approach in pulling the words out of a phrase in a string. We
can use the familiar Scanner class:

    Scanner sc = new Scanner(s); // s is the string to parse
    while (sc.hasNext() {
        String word = sc.next();
        ...
    }

 */

public class Chapter5_ProgrammingProject1 {

}
