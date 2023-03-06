package msaair.domain;

import msaair.NotimgmtApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Notification_table")
@Data
public class Notification  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public static NotificationRepository repository(){
        NotificationRepository notificationRepository = NotimgmtApplication.applicationContext.getBean(NotificationRepository.class);
        return notificationRepository;
    }

    public static void sendNotification(ReservationCreated reservationCreated){
        /*
         * Event 발생시 고객에게 알림 처리.
         */
        System.out.println("고객번호:" + reservationCreated.getCustomerId() + " ,항공편 예약이 등록되었습니다. 예약번호:" + reservationCreated.getReservationId());

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);
        */
        /** Example 2:  finding and process
        repository().findById(reservationCreated.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);
         });
        */
    }
    public static void sendNotification(ReservationCancelled reservationCancelled){
        /*
         * Event 발생시 고객에게 알림 처리.
         */
        System.out.println("고객번호:" + reservationCancelled.getCustomerId() + " ,항공편 예약이 취소되었습니다. 예약번호:" + reservationCancelled.getReservationId());

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);
        */

        /** Example 2:  finding and process
        repository().findById(reservationCancelled.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);
         });
        */
    }
    public static void sendNotification(MileageDecreased mileageDecreased){
        /*
         * Event 발생시 고객에게 알림 처리.
         */
        System.out.println("고객번호:" + mileageDecreased.getCustomerId() + " ,마일리지 적립이 취소되었습니다. 잔여마일리지:" + mileageDecreased.getMileage());

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(mileageDecreased.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void sendNotification(Mileageincreased mileageincreased){
        /*
         * Event 발생시 고객에게 알림 처리.
         */
        System.out.println("고객번호:" + mileageincreased.getCustomerId() + " ,마일리지가 신규 적립되었습니다. 잔여마일리지:" + mileageincreased.getMileage());
        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(mileageincreased.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }


}
