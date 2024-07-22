import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int games = 0;
        int row;
        int col;
        int moves;
        String currentPlayer;
        String player1 = "Player X";
        String player2 = "Player O";
        String markX = " X ";
        String markO = " O ";
        String currentMark;

        do {
            games++;
            moves = 0;
            clearBoard();
            display();

            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                    currentMark = markX;
                    currentPlayer = player1;
                } else {
                    currentMark = markO;
                    currentPlayer = player2;
                }
                System.out.printf("\n%s, Your turn. Please go ahead\n", currentPlayer);
                do {
                    row = SafeInput.getRangedInt(in, "Enter your row coordinate (1-3): ", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in, "Enter your column coordinate (1-3): ", 1, 3) - 1;
                } while (!isValidMove(row, col));

                moves += 1;
                board[row][col] = currentMark;
                display();

                if (moves >= 5) {
                    if (isWin(currentMark)) {
                        System.out.printf("CONGRATULATIONS, %s wins this round!\n", currentPlayer);
                        break;
                    } else if (moves == 9) {
                        System.out.println("Oops, it's a TIE!");
                        break;
                    }
                }
            }

            if (markX.equals(" X ")) {
                markX = " O ";
                markO = " X ";
            } else {
                markX = " X ";
                markO = " O ";
            }
        } while (SafeInput.getYNConfirm(in, "Wanna play again? (yes/no): "));
        System.out.printf("You played %d game(s).\n", games);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " "; // make this cell a space
            }
        }
    }

    private static void display() {
        StringBuilder boardDisplay = new StringBuilder();
        for (int a = 0; a < ROW; a++) {
            for (int b = 0; b < COL; b++) {
                if (b == COL - 1) { // draw rows
                    boardDisplay.append(board[a][b]);
                } else {
                    boardDisplay.append(board[a][b]).append("|");
                }
            }
            if (a != ROW - 1) {
                boardDisplay.append("\n--+--+--\n");
            }
        }
        System.out.println(boardDisplay);
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");  // is it a space?
    }

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false; // no row win
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
}