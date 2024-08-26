public class Movie {
    private String title;
    private String genre;
    private double ticketPrice;
    private int availableTickets;

    public Movie(String title, String genre, double ticketPrice, int availableTickets) {
        this.title = title;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
        this.availableTickets = availableTickets;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ") - Rp " + ticketPrice + " - Tiket Tersedia: " + availableTickets;
    }
}

