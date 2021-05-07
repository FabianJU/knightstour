# KnightTour

This is a Java program that searches for a valid knight’s tour on a chessboard of the input size parameter using a stack and a backtracking paradigm.

A knight can move two squares horizontally followed by one square vertically, or two squares vertically followed by one horizontally. The problem of the knight's 
tour is: can a knight move around the board by visiting each square once and only once? For example, the following is an example of a "tour" by a knight on a 5x5 
chess board, starting at the top left corner. The numbers indicate how many positions the knight has already visited during its tour.

```
+--+--+--+--+--+
| 1|10| 5|16|25|
+--+--+--+--+--+
| 4|17| 2|11| 6|
+--+--+--+--+--+
| 9|20|13|24|15|
+--+--+--+--+--+
|18| 3|22| 7|12|
+--+--+--+--+--+
|21| 8|19|14|23|
+--+--+--+--+--+
```

The program takes in the size of a board as a parameter and makes the knight start at the top left corner, then visit the maximum number of positions on the board
exactly once. 
