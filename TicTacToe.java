import java.util.Scanner;

class TicTacToe{
	public static final Scanner scan = new Scanner(System.in);
	public static char [][] board = new char [3][3];
	public static int row,col;
	public static char turn = 'X';
	public static int count = 0;
	public static void main(String [] args)
	{
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = '_';
			}
		}
		printBoard();
		play();
	}
	public static void play()
	{
		boolean playing = true;
		while(playing)
		{
			count++;
			System.out.print("Player "+turn+" Enter your row and column:");
			row = scan.nextInt()-1;
			col = scan.nextInt()-1;
			board[row][col] = turn;
			if(gameOver(row,col))
			{
				System.out.println("Game over! Player "+turn+" wins!!\nCode By Bhaveshgoyal182");
				playing = false;
			}
			if(count==9)
				{System.out.println("Match Drawn!!\nCode By Bhaveshgoyal182");System.exit(0);}
			if(turn=='X')
				turn = 'O';
			else
				turn = 'X';
			
			printBoard();
		}
	}
	
	public static void printBoard()
	{
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(j==0)System.out.print("| ");
				System.out.print(board[i][j]+" | ");
			}System.out.println();
			}
	}
	public static boolean gameOver(int rmove,int cmove)
	{
		if((board[rmove][0]==board[rmove][1])&&(board[rmove][1]==board[rmove][2]))
			return true;
		if((board[0][cmove]==board[1][cmove])&&(board[1][cmove]==board[2][cmove]))
			return true;
		if((board[0][0]==board[1][1])&&(board[1][1]==board[2][2]) && board[1][1]!='_')
			return true;
		if(board[0][2]==board[1][1] && board[1][1]==board[2][0] && board[1][1]!='_')
			return true;
		return false;
	}
}
