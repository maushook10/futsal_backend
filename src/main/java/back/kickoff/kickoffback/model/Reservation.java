package back.kickoff.kickoffback.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Setter
@Getter
@Table
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

/*
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "reservation_player",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    Set<LitePlayer> playersID = new HashSet<>();
*/

    @ManyToOne(fetch = FetchType.EAGER)
    Player mainPlayer;
    Long courtID;
    Long courtOwnerID;
    Date startDate;
    Date endDate;
    Time timeFrom;
    Time timeTo;

    Date dateReserved;
    Time timeReserved ;

    ReservationState state;
    String receiptUrl;
    int moneyPayed ;
    int totalCost ;
    //@ManyToMany(mappedBy = "reservations")
    //Set<Player> players;
    //Long messageID ;



    public Reservation(Player mainPlayer, Long courtID, Long courtOwnerID, Date startDate, Date endDate, Time timeFrom,
                       Time timeTo, ReservationState state, int moneyPayed, int totalCost) {
        this.mainPlayer = mainPlayer ;
        this.courtID = courtID;
        this.courtOwnerID = courtOwnerID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.state = state;
        this.moneyPayed = moneyPayed;
        this.totalCost = totalCost;
        LocalDate date = LocalDate.now() ;
        this.dateReserved = Date.valueOf(date);
        LocalTime lt = LocalTime.now() ;
        this.timeReserved = Time.valueOf(lt);


    }
}

















