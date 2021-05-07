/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Fabian Jujescu */

import java.util.Stack;

// Do you know the chess piece that looks like a horse? It's called a "Knight",
// and the "Knight's Tour" is a famous problem where you want the Knight to move
// around a chess board such that it visits every position on the board exactly once.
// Recall that the Knight can move in the shape of the letter "L" in any direction
// IMPORTANT: See our A2 handout for examples and more detailed instructions/hints!

public class KnightTour {
    // TODO: Implement and print a Knight's Tour solution, using
    // the chess board defined in class KnightBoard. Your solution must
    // use a Stack to keep track of different possible sequences of moves
    // for the Knight, in order to discover and return a valid tour.

    // NOTE: There can be several distinct valid tours; your job is to find
    // and print only one valid tour (the first valid one you discover).
    // Please do NOT attempt to discover all possible valid tours! To get
    // a sense of how many valid board configurations exist for different
    // board sizes, see "The Knight's Paths" table here:
    // http://www.behnel.de/knight.html

    /** tour method is where you add your code for implementing
    * a Knight Tour's solution for an n*n chess board
    * @param n size of the board
    * @return KnightBoard object with a valid Knight Tour
    */
    public static KnightBoard tour(int n){
      // Your solution must utilize the stack "candidates" below,
      // to keep track of different possible sequences of Knight moves
      Stack<KnightBoard> candidates = new Stack<KnightBoard>();
      KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
      candidates.push(kb); // push the initial board onto the stack

      // possible moves that the knight can make
      int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
      int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

      // while the stack isn't empty
      while (!candidates.isEmpty()) {
        // get the board at the top of the stack
        KnightBoard board = candidates.pop();
        // if all possible squares have been traveled to
        if (board.getMoveCount() == n*n) {
          return board;
        } else {
          // push each possible board with the next valid move onto the stack
          for (int i = 0; i < 8; i++) {
            // make a new copy of the board
            KnightBoard copy = board.copyBoard();
            // check if each move is valid
            boolean validMove = copy.move(copy.getCurrentX() + xMove[i], copy.getCurrentY() + yMove[i]);
            // if move is valid, push the new board onto the stack
            if (validMove) {
              candidates.push(copy);
              kb = copy;
            }
          }
        }
      }

      // return the most recent board
      return kb;
    }


    // Do NOT modify this main method. If you need to add code for
    // testing your solution, just make sure to comment it out before submission
    public static void main(String[] args) {
      int n = 3; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
        n = Integer.parseInt(args[0].trim());
        if (n < 3) {
          System.out.println("Incorrect parameter (n must be >= 3)");
          System.exit(-1);
        }
      }
      long startTime = System.nanoTime();
      KnightBoard winner = KnightTour.tour(n);
      long endTime = System.nanoTime();
      double delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
    }
}
