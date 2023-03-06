package msaair.domain;

import msaair.domain.ReservationCreated;
import msaair.domain.ReservationCancelled;
import msaair.ReservationmgmtApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Reservation_table")
@Data

public class Reservation  {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long reservationId;
    
    private Long customerId;
    
    
    
    
    
    private Integer peopleNo;
    
    
    
    
    
    private Integer mileageToIncrease;
    
    
    
    
    
    private Long scheduleId;

    @PrePersist 
    public void onPrePersist() {
        // Check if The input schedule id exists
        try {
        msaair.external.Schedule schedule = ReservationmgmtApplication.applicationContext.getBean(msaair.external.ScheduleService.class).getSchedule(
            getScheduleId()
        );
        } catch(Exception ex) {
            throw new RuntimeException("Schedule id isn't existed");
        }

        // Check if the customer exists
        try {
        // Get request from Mileage
        msaair.external.Mileage mileage = ReservationmgmtApplication.applicationContext.getBean(msaair.external.MileageService.class).getMileage(
            getCustomerId()
        );
        } catch(Exception ex){
            throw new RuntimeException("non-existed customer");           
        }
    }

    @PostPersist
    public void onPostPersist(){
        ReservationCreated reservationCreated = new ReservationCreated(this);
        reservationCreated.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        ReservationCancelled reservationCancelled = new ReservationCancelled(this);
        reservationCancelled.publishAfterCommit();
    }

    public static ReservationRepository repository(){
        ReservationRepository reservationRepository = ReservationmgmtApplication.applicationContext.getBean(ReservationRepository.class);
        return reservationRepository;
    }
}
