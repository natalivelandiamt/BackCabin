package co.edu.usergioarboleda.alquiler.cabin.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "score")
public class Score implements Serializable{
    
    private static final long serialVersionUID = 8L;
  
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String  messageText;
    private Integer stars;

    @OneToOne
    @JoinColumn(name = "ID_RESERVATION", referencedColumnName ="idReservation")
    @JsonIgnoreProperties({ "score" })
    private Reservation reservation;
}
