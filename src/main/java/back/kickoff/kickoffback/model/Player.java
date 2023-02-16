package back.kickoff.kickoffback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String email;
    private String phoneNumber;
    private PlayerType  playerType = PlayerType.Registered ;
    private String password;
    private String location;
    private String image;
    private Double xAxis;
    private Double yAxis;

    //penalty
    private boolean restricted= false;
    private int warnings = 0;
    private Date lastWarning;
    private int penaltyDays = 0 ;

    //@ManyToMany
    //@JoinTable(name="player_reservation", joinColumns = @JoinColumn(name="player_id"),inverseJoinColumns = @JoinColumn(name="reservation_id"))
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER , mappedBy = "mainPlayer")
    private List<Reservation> reservations;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerCreated")
    private List<Party> partiesCreated;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "playerJoined")
    private List<Party> partiesJoined;

    public Player(String name, String email, String phoneNumber, String password, String location, Double xAxis, Double yAxis) {
        Name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.location = location;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
}
