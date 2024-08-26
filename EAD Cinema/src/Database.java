import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Movie> movieList;

    public Database() {
        movieList = new ArrayList<>();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void showMovies() {
        if (movieList.isEmpty()) {
            System.out.println("Mohon maaf, untuk saat ini belum ada film yang akan tayang.");
        } else {
            for (Movie movie : movieList) {
                System.out.println(movie);
            }
        }
    }

    public void buyTicket(String movieTitle, int ticketQuantity) throws MovieNotFoundException, NotEnoughTicketsException {
        for (Movie movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
                if (movie.getAvailableTickets() >= ticketQuantity) {
                    movie.setAvailableTickets(movie.getAvailableTickets() - ticketQuantity);
                    System.out.println("Pembelian Tiket Berhasil!\nTotal Harga: Rp " + (movie.getTicketPrice() * ticketQuantity));
                    return;
                } else {
                    throw new NotEnoughTicketsException("Jumlah tiket tersedia tidak cukup. Mohon pastikan kembali jumlah tiket yang tersedia mencukupi!");
                }
            }
        }
        throw new MovieNotFoundException("Film tidak ditemukan. Mohon pastikan film yang dicari terdapat di list!");
    }
}
