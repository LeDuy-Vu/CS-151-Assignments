import java.util.* ;

/**
   A class to play Tic Tac Toe
 */
public class TicTacToeBoard
{
	private static final int BOARD_SIDE = 3 ;					// size of the Tic Tac Toe Board
	
	private char[][] board = new char[BOARD_SIDE][BOARD_SIDE] ;	// the board has 3x3 size
	private char user ;											// icon the user uses to mark their moves
	private char computer ;										// icon the computer uses to mark it moves
	
	private int[] moves = new int[BOARD_SIDE * BOARD_SIDE] ;	// contains list of cells that have been played
	private int turn ;											// 0 means turn computer turn, 1 means user turn
	private int cell ;											// can be from 1 to 9, used to mark the cell
	private int movesPlayed ;									// keeps track of how many moves have been made
	
	private boolean computerRepeat ;							// does the computer need to replay its turn
	private boolean userRepeat ;								// do the user need to replay their turn
	
	private static Random random = new Random() ;
	private static Scanner input = new Scanner(System.in) ;
	
	/**
	   Print welcome and instructions of the game.
	 */
	public void showInstruction()
	{
		System.out.println("\t\t\tWelcome to Tic Tac Toe!\n") ;
		System.out.println("At each turn, choose a cell labelled from 1 to 9 as shown in the board below.\n") ;
		System.out.println("\t\t\t\t 1 | 2 | 3 ") ;
		System.out.println("\t\t\t\t-----------") ;
		System.out.println("\t\t\t\t 4 | 5 | 6 ") ;
		System.out.println("\t\t\t\t-----------") ;
		System.out.println("\t\t\t\t 7 | 8 | 9 ") ;
		System.out.println("\n-----------------------------------------------------------------------------\n") ;
	}
	
	/**
	   Show the board updated with past moves.
	 */
	public void showBoard()
	{
		System.out.println() ;
		System.out.printf("\t\t\t\t %c | %c | %c \n", board[0][0], board[0][1], board[0][2]) ;
		System.out.println("\t\t\t\t-----------") ;
		System.out.printf("\t\t\t\t %c | %c | %c \n", board[1][0], board[1][1], board[1][2]) ;
		System.out.println("\t\t\t\t-----------") ;
		System.out.printf("\t\t\t\t %c | %c | %c \n\n", board[2][0], board[2][1], board[2][2]) ;
	}
	
	/**
	   Control the algorithm of the game.
	 */
	public void play() throws InputMismatchException
	{
		showInstruction() ;
		setUp() ;
		
		do
		{
			if (turn == 0)
			{
				do
				{
					computerRepeat = false ;
					cell = 1 + random.nextInt(9) ;
					
					for (int i = 0; i < movesPlayed; i++)
						if (moves[i] == cell)
						{
							computerRepeat = true ;
							break ;
						}
				} while (computerRepeat) ;
				
				board[(cell - 1) / BOARD_SIDE][(cell - 1) % BOARD_SIDE] = computer ;
				moves[movesPlayed] = cell ;
				movesPlayed++ ;
				turn = 1 ;
				
				System.out.printf("Computer has put a %c in cell %d\n\n", computer, cell) ;
				showBoard() ;
			}
			else
			{
				do
				{
					try
					{
						System.out.print("Your turn! Choose the cell you want to play: ") ;
						cell = input.nextInt() ;
						
						if (cell < 1 || cell > 9)
						{
							System.out.println("You must enter a cell number from 1 to 9. Please choose again.\n") ;
							userRepeat = true ;
							continue ;
						}
						userRepeat = false ;
					
						for (int i = 0; i < movesPlayed; i++)
							if (moves[i] == cell)
							{
								userRepeat = true ;
								if (userRepeat)
									System.out.println("That cell has been played before. Please choose again.\n") ;
								break ;
							}
					}
					catch (InputMismatchException ex)
					{
						System.out.println("You must enter a cell number from 1 to 9. Please choose again.\n") ;
						input.nextLine() ;
						userRepeat = true ;
					}
				} while (userRepeat) ;
				
				board[(cell - 1) / BOARD_SIDE][(cell - 1) % BOARD_SIDE] = user ;
				moves[movesPlayed] = cell ;
				movesPlayed++ ;
				turn = 0 ;
				showBoard() ;
			}
		} while (!gameOver() && movesPlayed != BOARD_SIDE * BOARD_SIDE) ;
		
		if (!gameOver())
			System.out.print("Too bad no one wins! It's a draw.") ;
		else
			if (turn == 0)
				System.out.print("Congratulations! You won.") ;
			else
				System.out.print("Computer won!") ;
	}
	
	/**
	   Prepare the game before the game starts: decide who starts first and which icon to play
	 */
	private void setUp()
	{
		boolean askAgain ;
		movesPlayed = 0 ;
		
		for (int i = 0; i < BOARD_SIDE; i++)
			for (int j = 0; j < BOARD_SIDE; j++)
				board[i][j] = ' ' ;
		
		do
		{
			askAgain = false ;
			System.out.print("Please choose to play as x or 0: ") ;
			String in = input.nextLine() ;
			user = in.charAt(0) ;
			if (user == 'x')
				computer = '0' ;
			else if (user == '0')
				computer = 'x' ;
			else
			{
				askAgain = true ;
				System.out.println("Please enter x or 0.") ;
			}
		} while (askAgain) ;
		
		if (random.nextInt(2) == 0)
		{
			turn = 0 ;
			System.out.println("Computer go first!\n") ;
		}
		else
		{
			turn = 1 ;
			System.out.println("User go first!\n") ;
		}
	}
	
	/**
	   Check if the game has been won by row.
	   @return true if game is over and vice versa.
	 */
	private boolean winRow()
	{
		for (int i = 0; i < BOARD_SIDE; i++)
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
			{
				System.out.println("Win row") ;
				return true;
			}
		return false;
	}
	
	/**
	   Check if the game has been won by column.
	   @return true if game is over and vice versa.
	 */
	private boolean winColumn()
	{
		for (int i = 0; i < BOARD_SIDE; i++)
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
			{
				System.out.println("Win column") ;
				return true;
			}
		return false;
	}
	
	/**
	   Check if the game has been won by diagonal.
	   @return true if game is over and vice versa.
	 */
	private boolean winDiagonal()
	{
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
		{
			System.out.println("Win diagonal") ;
			return true;
		}
		else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')
		{
			System.out.println("Win diagonal") ;
			return true;
		}
		else
			return false;
	}
	
	/**
	   Check if the game has been won by any case.
	   @return true if game is over and vice versa
	 */
	private boolean gameOver()
	{
		return (winRow() || winColumn() || winDiagonal());
	}
}
