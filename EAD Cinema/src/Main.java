import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        db.addMovie(new Movie("Transformers", "Action/Sci-fi", 45000, 50));
        db.addMovie(new Movie("Godzilla x Kong", "Action/Sci-fi", 35000, 25));
        db.addMovie(new Movie("Blue Lock", "Action/Drama", 35000, 40));

        try {
            user.register();
            boolean running = true;

            while (running) {
                System.out.println("\nMenu:");
                System.out.println("1. Lihat Film");
                System.out.println("2. Beli Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        db.showMovies();
                        break;
                    case 2:
                        try {
                            db.showMovies();
                            System.out.print("Masukkan judul film: ");
                            String movieTitle = scanner.nextLine();
                            System.out.print("Masukkan jumlah tiket: ");
                            int ticketQuantity = scanner.nextInt();
                            db.buyTicket(movieTitle, ticketQuantity);
                        } catch (MovieNotFoundException | NotEnoughTicketsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan aplikasi EAD Cinema!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi!");
                }
            }
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }
    }
}

class MovieNotFoundException extends Exception {
    public MovieNotFoundException(String message) {
        super(message);
    }
}

class NotEnoughTicketsException extends Exception {
    public NotEnoughTicketsException(String message) {
        super(message);
    }
}

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

