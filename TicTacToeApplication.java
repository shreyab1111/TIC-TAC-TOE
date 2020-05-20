import java.util.*;
public class TicTacToeApplication
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        boolean doYouWantToPlay=true;
        while(doYouWantToPlay == true)
        {
            System.out.println("Welcome to the tic-tac-toe game. Are you ready?");
            System.out.println();
            System.out.println("Please enter which character you want to be.");
            char playerToken = sc.next().charAt(0);
            System.out.println("Please enter which character you want your opponent to be.");
            char opponentToken = sc.next().charAt(0);
            System.out.println();
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();

            //set up the game
            System.out.println("Now we can start the game. "
            +"To play enter a number and your token shall be put"
            +"The numbers go from 1-9, left to right. We shall see who wins.");
            TicTacToe.printIndexBoard();
            System.out.println();
            System.out.println();
            while(game.gameOver().equals("Not over"))
            {
                if(game.currentMarker==game.userMarker)
                {
                    //user turn
                    System.out.println("It's your turn. Enter a spot for your token.");
                    System.out.println();
                    int spot = sc.nextInt();
                    while(!(game.playTurn(spot)))
                    {
                        System.out.println();
                        System.out.println("Try again. "+ spot+" is not available");
                        System.out.println();
                        spot= sc.nextInt();
                    }
                    System.out.println("You picked "+ spot+ "!");
                    System.out.println();
                }
                else
                {
                    //ai turn
                    System.out.println();
                    System.out.println("It's my turn");
                    System.out.println();
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+ aiSpot+ "!");
                    System.out.println();
                }
                //printing the board
                System.out.println("");
                game.printBoard();
            }

            System.out.println(game.gameOver());
            System.out.println();
            //ask for a new game
            System.out.println();
            System.out.println("Want to play another game? Enter Y if you do else any other character");
            System.out.println();
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response=='Y');
            System.out.println();
            sc.close();
        }
    }
}
