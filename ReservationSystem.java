import java.util.Scanner;

public class ReservationSystem {

    private static boolean[][] seats = new boolean[10][10]; // 10 rows, 10 seats per row

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter row number (1-10) or -1 to exit:");
            int row = scanner.nextInt();
            if (row == -1) {
                break;
            }
            System.out.println("Enter seat number (1-10):");
            int seat = scanner.nextInt();
            if (reserveSeat(row, seat)) {
                System.out.println("Seat " + row + "-" + seat + " reserved.");
            } else {
                System.out.println("Sorry, seat " + row + "-" + seat + " is already taken.");
            }
            printSeats();
        }
    }

    private static boolean reserveSeat(int row, int seat) {
        if (row < 1 || row > 10 || seat < 1 || seat > 10) {
            System.out.println("Invalid row or seat number.");
            return false;
        }
        if (seats[row-1][seat-1]) {
            return false; // seat already taken
        } else {
            seats[row-1][seat-1] = true; // reserve the seat
            return true;
        }
    }

    private static void printSeats() {
        System.out.println("Current seating arrangement:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(seats[i][j] ? "X " : "_ ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
