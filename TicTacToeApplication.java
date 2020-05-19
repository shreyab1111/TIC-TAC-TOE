public class TicTacToeApplication
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        boolean doYouWantToPlay=true;
        while(doYouWantToPlay)
        {
            System.out.println("Welcome to the tic-tac-toe game. Are you ready?");
            System.out.println("Please enter which character you want to be.");
            char playerToken = sc.next().charAt(0);
            System.out.println("Please enter which character you want your opponent to be.");
            char opponentToken = sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();

            //set up the game
            System.out.println("Now we can start the game. "
            +"To play enter a number and your token shall be put"
            +"The numbers go from 1-9, left to right. We shall see who wins.");
            TicTacToe.printIndexBoard()
            System.out.println();
            while(game.gameOver().equals("Not over"))
            {
                if(game.currentMarker==game.userMarker)
                {
                    System.out.println("It's your turn. Enter a spot for your token.");
                    int spot = sc.nextInt();
                    while(!(game.playTurn(spot)))
                    {
                        System.out.println("Try again. "+ spot+" is not available");
                        spot= sc.nextInt();
                    }
                    System.out.println("You picked "+ spot+ "!");
                }
                else
                {
                    System.out.println("It's my turn");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+ aiSpot+ "!");
                }
                //printing the board
                System.out.println("");
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            //ask for a new game
            System.out.println("Want to play another game? Enter Y if you do else any other character");
            char response = sc.next.charAt(0);
            doYouWantToPlay = (response=='Y');
            System.out.println();
        }
    }
}
