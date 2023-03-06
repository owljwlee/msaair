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

    @PostPersist
    public void onPostPersist(){
        ReservationCreated reservationCreated = new ReservationCreated(this);
        reservationCreated.publishAfterCommit();
        // Get request from Schedule
        //msaair.external.Schedule schedule =
        //    Application.applicationContext.getBean(msaair.external.ScheduleService.class)
        //    .getSchedule(/** mapping value needed */);
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
