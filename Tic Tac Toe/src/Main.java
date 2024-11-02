import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final char[][] board = new char[][] {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = 0;
        char piece = 'X';
        while(count < 9) {
            print();
            int num = -1;
            while(num < 0) {
                System.out.println(piece + ": ");
                num = in.nextInt() - 1;
                if(num > -1 && num < 9 && Character.isDigit(board[num / 3][num % 3])) board[num / 3][num % 3] = piece;
                else {
                    System.out.println("Illegal move");
                    num = -1;
                }
            }
            count++;
            if(count > 4) {
                char c = check();
                if(c == 'N') {
                    if(count == 9) {
                        print();
                        System.out.println("Tie");
                    }
                } else {
                    print();
                    System.out.println(c + " wins!");
                    break;
                }
            }
            piece = (piece == 'X') ? 'O' : 'X';
        }

    }

    private static void print() {
        for(char[] row : board) System.out.println(Arrays.toString(row));
    }

    private static char check() {
        for(char[] row : board)
            if(row[0] == row[1] && row[1] == row[2]) return row[0];
        for(int i = 0; i < 3; i++)
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]) return board[0][i];
        return ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) ? board[1][1] : 'N';
    }

}
