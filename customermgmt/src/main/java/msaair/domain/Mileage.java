package msaair.domain;

import msaair.domain.Mileageincreased;
import msaair.domain.MileageDecreased;
import msaair.CustomermgmtApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Mileage_table")
@Data
public class Mileage  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private Long mileage;

    @PostPersist
    public void onPostPersist(){
        // Mileageincreased mileageincreased = new Mileageincreased(this);
        // mileageincreased.publishAfterCommit();

        // MileageDecreased mileageDecreased = new MileageDecreased(this);
        // mileageDecreased.publishAfterCommit();
    }

    public static MileageRepository repository(){
        MileageRepository mileageRepository = CustomermgmtApplication.applicationContext.getBean(MileageRepository.class);
        return mileageRepository;
    }

    public static void accumulateMileage(ReservationCreated reservationCreated){
        /** Example 1:  new item 
        Mileage mileage = new Mileage();
        repository().save(mileage);
        */
        /** Example 2:  finding and process */
        repository().findById(reservationCreated.getCustomerId()).ifPresent(mileage->{
            mileage.setMileage(mileage.getMileage() + reservationCreated.getMileageToIncrease() );
            repository().save(mileage);
            Mileage aMileage = new Mileage();
            aMileage.setCustomerId(mileage.getCustomerId());
            aMileage.setMileage(mileage.getMileage());
            Mileageincreased mileageincreased = new Mileageincreased(aMileage);
            mileageincreased.publishAfterCommit();
            }
         );
    }
    public static void cancelMileage(ReservationCancelled reservationCancelled){

        /** Example 1:  new item 
        Mileage mileage = new Mileage();
        repository().save(mileage);
        */

        /** Example 2:  finding and process*/
        repository().findById(reservationCancelled.getCustomerId()).ifPresent(mileage->{    
            mileage.setMileage(mileage.getMileage() - reservationCancelled.getMileageToIncrease() );
            repository().save(mileage);
            Mileage aMileage = new Mileage();
            aMileage.setCustomerId(mileage.getCustomerId());
            aMileage.setMileage(mileage.getMileage());
            MileageDecreased mileageDecreased = new MileageDecreased(aMileage);
            mileageDecreased.publishAfterCommit();
         });
    }
}
