public class TicTacToe
{
    protected char[] board;
    protected char userMarker;
    protected char aiMarker;
    protected char winner;
    protected char currentMarker;

    public TicTacToe( char playerToken,char aiToken)
    {
        this.userMarker=playerToken;
        this.aiMarker=aiToken;
        this.winner='-';
        this.board=setBoard();
        this.currentMarker = userMarker;
    }

    public static char[] setBoard()
    {
        char board[]= new char[9];
        for(int i=0;i<board.length;i++)
        {
            board[i]='-';
        }
        return board;
    }

    public boolean playTurn(int spot)
    {
        boolean isValid = (withinRange(spot) && isSpotAvailable(spot));
        if(isValid == true)
        {
            board[spot-1] = currentMarker;
            //flipping
            currentMarker= (currentMarker==userMarker)? aiMarker : userMarker;
        }
        return isValid;
    }

    public boolean withinRange(int number)
    {
        if(number>=1 && number<=board.length+1)
        {
            return true;
        }
        return false;
    }

    public boolean isSpotAvailable(int number)
    {
        if(board[number-1]=='-')
        {
            return true;
        }
        return false;
    }

    public void printBoard()
    {
        System.out.println();
        for(int i=0;i<9;i++)
        {
            if(i%3==0 && i!=0)
            {
                System.out.println();
                System.out.println("------------");
            }
            System.out.print(" | "+ board[i]);
        }
        System.out.println();
    }

    public static void printIndexBoard()
    {
        System.out.println();
        for(int i=0;i<9;i++)
        {
            if(i%3==0 && i!=0)
            {
                System.out.println();
                System.out.println("------------");
            }
            System.out.print(" | "+ (i+1));
        }
        System.out.println();
    }

    public boolean isThereAWinner()
    {
        boolean diagAndMid = (rightD() || leftD() || middle() || secondCol()) && board[4]!='-';
        boolean topAndFirst = (topRow() || firstCol()) && board[0]!='-';
        boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8]!='-';
        if(diagAndMid==true)
        {
            this.winner=board[4];
        }
        else if(topAndFirst==true)
        {
            this.winner=board[0];
        }
        else if(bottomAndThird==true)
        {
            this.winner=board[8];
        }
        return (diagAndMid || topAndFirst || bottomAndThird);
    }

    public boolean topRow()
    {
        if(board[0]==board[1] && board[1]==board[2])
            return true;
        return false;    
    }

    public boolean firstCol()
    {
        if(board[0]==board[3] && board[3]==board[6])
            return true;
        return false; 
    }

    public boolean bottomRow()
    {
        if(board[6]==board[7] && board[7]==board[8])
            return true;
        return false; 
    }

    public boolean thirdCol()
    {
        if(board[2]==board[5] && board[5]==board[8])
            return true;
        return false; 
    }

    public boolean leftD()
    {
        if(board[0]==board[4] && board[4]==board[8])
            return true;
        return false; 
    }

    public boolean rightD()
    {
        if(board[6]==board[4] && board[4]==board[2])
            return true;
        return false; 
    }

    public boolean middle()
    {
        if(board[3]==board[4] && board[4]==board[5])
            return true;
        return false; 
    }

    public boolean secondCol()
    {
        if(board[1]==board[4] && board[4]==board[7])
            return true;
        return false; 
    }

    public boolean isBoardFilled()
    {
        for(int i=0;i<9;i++)
        {
            if(board[i]=='-')
            {
                return false;
            }
        }
        return true;
    }

    public String gameOver()
    {
        boolean didSomeoneWin = isThereAWinner();
        if(didSomeoneWin==true)
        {
            return("We have a winner. The winner is "+ this.winner);
        }
        else if(isBoardFilled()==true)
        {
            return("Draw");
        }   
        else
        {
            return("Not over");
        }
    }
}
