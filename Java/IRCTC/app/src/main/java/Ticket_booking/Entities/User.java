package Ticket_booking.Entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;

public class User {

    private String name;
    private String password;
    @JsonProperty("hashed_password")  // 🔥 fix here
    private String hashPassword;
    @JsonProperty("tickets_booked")
    private List<Ticket> ticketsBooked;
    private String userId;

    // constructor
    public User(String name, String password, String hashPassword, List<Ticket> ticketsBooked, String userId) {
        this.name = name;
        this.password = password;
        this.hashPassword = hashPassword;
        this.ticketsBooked = ticketsBooked;
        this.userId = userId;
    }

    // default constructor (needed for Jackson)
    public User() {}

    // ✅ GETTERS
    public String getName() {
        return name;
    }

    public String getPassword() {   // ⭐ ADD THIS
        return password;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public List<Ticket> getTicketsBooked() {
        return ticketsBooked;
    }

    public String getUserId() {
        return userId;
    }

    // ✅ SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {   // ⭐ ADD THIS
        this.password = password;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // print tickets
    public void printTickets() {
        if (ticketsBooked == null) return;

        for (Ticket t : ticketsBooked) {
            System.out.println(t.getTicketInfo());
        }
    }
}