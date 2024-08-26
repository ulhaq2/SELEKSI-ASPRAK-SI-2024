import java.util.Scanner;

public class User {
    private String name;
    private String phoneNumber;

    public void register() throws InvalidPhoneNumberException {
        System.out.print("Selamat Datang di Aplikasi EAD Cinema!\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Anda: ");
        this.name = scanner.nextLine();

        System.out.print("Masukkan Nomor Handphone Anda: ");
        String phoneInput = scanner.nextLine();

        if (!phoneInput.matches("\\d+")) {
            throw new InvalidPhoneNumberException("Nomor Handphone Harus Berupa Angka!");
        }
        this.phoneNumber = phoneInput;

        System.out.println("Registrasi berhasil!\nSelamat datang, " + name + "!");
    }

    public Movie chooseMovie(Database db) throws MovieNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul film yang ingin Anda pilih: ");
        String movieTitle = scanner.nextLine();
        for (Movie movie : db.getMovieList()) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                return movie;
            }
        }
        throw new MovieNotFoundException("Film tidak ditemukan. Mohon pastikan film yang dicari terdapat di list!");
    }

    public void purchaseTicket(Movie movie, int quantity) throws NotEnoughTicketsException {
        if (movie.getAvailableTickets() >= quantity) {
            double totalPrice = movie.getTicketPrice() * quantity;
            movie.setAvailableTickets(movie.getAvailableTickets() - quantity);
            System.out.println("Tiket berhasil dibeli!\nTotal harga: Rp " + totalPrice);
        } else {
            throw new NotEnoughTicketsException("Jumlah tiket tersedia tidak cukup. Mohon pastikan kembali jumlah tiket yang tersedia mencukupi!");
        }
    }
}

