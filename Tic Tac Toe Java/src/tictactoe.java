import java.util.* ;

public class tictactoe {
    public static void main(String[] args) {

        char [][] gameBoard = {
            {' ', '|', ' ', '|', ' '}, 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '}, 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        int i = 0;
        int [] p1move ={0,0,0};
        int [] p2move ={0,0,0};
        
        int [][] wincon = {
            {1, 2 , 3},
            {4, 5 , 6},
            {7, 8 , 9},
            {1, 4 , 7},
            {2, 5 , 8},
            {3, 6 , 9},
            {1, 5 , 9},
            {7, 5, 3}};

        checkwin check = new checkwin();
        Scanner input = new Scanner (System.in);

        while(i<3){
            //input player 1
            System.out.print("Enter player 1 (1-9) : ");
            int player1Pos = input.nextInt();
            
            //check ocupied position
            for (int x=0;x<p1move.length;x++){
                while (p1move[x]==(player1Pos)||(p2move[x]==(player1Pos))){
                    System.out.println("\n!!!Position ocupied!!!\n");
                    System.out.print("Enter player 1 (1-9) : ");
                    int player1Post = input.nextInt();
                    player1Pos = player1Post;
                }
            }

            //update gameboard
            placePiece(gameBoard, player1Pos, "player1");
            p1move[i]=(player1Pos);

            //print gameboard
            printGameBoard(gameBoard);
            

            //check winner
            for (int c=0;c<wincon.length;c++){
                if (check.equalArrays(p1move,wincon[c]).equals("Player win")){
                    System.out.println("^^ Player 1 Win ^^");
                    System.out.print("\n== Game over ==\n");
                    System.exit(0);
                }
            }

            //input player 2
            System.out.print("Enter player 2 (1-9) : ");
            int player2Pos = input.nextInt();

            //check ocupied position
            for (int x=0;x<p1move.length;x++){
                while (p1move[x]==(player2Pos)||(p2move[x]==(player2Pos))){
                    System.out.println("\n!!!Position ocupied!!!\n");
                    System.out.print("Enter player 1 (1-9) : ");
                    int player2Post = input.nextInt();
                    player2Pos = player2Post;
                }
            }

            //update gameboard
            placePiece(gameBoard, player2Pos, "Player2");
            p2move[i]=(player2Pos);

            //print gameboard
            printGameBoard(gameBoard);

            //check winner
            for (int c=0;c<wincon.length;c++){
                if (check.equalArrays(p2move,wincon[c]).equals("Player win")){
                    System.out.println("^^ Player 2 Win ^^");
                }
            }

        i++;
        }
        System.out.print("\n== Game over ==\n");
        input.close();
    }

    //gameboard printer method
    public static void printGameBoard(char [][] gameBoard){
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    //place player symbol method
    public static void placePiece(char [][] gameBoard, int pos, String user){

        char symbol = ' ';
        if(user.equals("player1")){
            symbol = 'X';

        }else if (user.equals("Player2")){
            symbol = 'O'; 
        }
        
        switch(pos) {
            case 1: 
                gameBoard[0][0] = symbol;
                break;
            case 2: 
                gameBoard[0][2] = symbol;
                break;
            case 3: 
                gameBoard[0][4] = symbol;
                break;
            case 4: 
                gameBoard[2][0] = symbol;
                break;
            case 5: 
                gameBoard[2][2] = symbol;
                break;
            case 6: 
                gameBoard[2][4] = symbol;
                break;
            case 7: 
                gameBoard[4][0] = symbol;
                break;
            case 8: 
                gameBoard[4][2] = symbol;
                break;
            case 9: 
                gameBoard[4][4] = symbol;
                break;
            default: 
                break;
        }
    }
}