package msaair.infra;

import msaair.domain.*;
import msaair.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ResevationHistViewHandler {

    @Autowired
    private ResevationHistRepository resevationHistRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCreated_then_CREATE_1 (@Payload ReservationCreated reservationCreated) {
        try {

            if (!reservationCreated.validate()) return;

            // view 객체 생성
            ResevationHist resevationHist = new ResevationHist();
            // view 객체에 이벤트의 Value 를 set 함
            resevationHist.setCustomerId(reservationCreated.getCustomerId());
            resevationHist.setScheduleId(reservationCreated.getScheduleId());
            resevationHist.setEventType('예약등록');
            resevationHist.setId(reservationCreated.getId());
            // view 레파지 토리에 save
            resevationHistRepository.save(resevationHist);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_CREATE_2 (@Payload ReservationCancelled reservationCancelled) {
        try {

            if (!reservationCancelled.validate()) return;

            // view 객체 생성
            ResevationHist resevationHist = new ResevationHist();
            // view 객체에 이벤트의 Value 를 set 함
            resevationHist.setCustomerId(reservationCancelled.getCustomerId());
            resevationHist.setScheduleId(reservationCancelled.getScheduleId());
            resevationHist.setEventType('예약취소');
            // view 레파지 토리에 save
            resevationHistRepository.save(resevationHist);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMileageincreased_then_CREATE_3 (@Payload Mileageincreased mileageincreased) {
        try {

            if (!mileageincreased.validate()) return;

            // view 객체 생성
            ResevationHist resevationHist = new ResevationHist();
            // view 객체에 이벤트의 Value 를 set 함
            resevationHist.setCustomerId(mileageincreased.getCustomerId());
            resevationHist.setMileage(mileageincreased.getMileage());
            resevationHist.setEventType('마일리지적립');
            // view 레파지 토리에 save
            resevationHistRepository.save(resevationHist);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenMileageDecreased_then_CREATE_4 (@Payload MileageDecreased mileageDecreased) {
        try {

            if (!mileageDecreased.validate()) return;

            // view 객체 생성
            ResevationHist resevationHist = new ResevationHist();
            // view 객체에 이벤트의 Value 를 set 함
            resevationHist.setCustomerId(mileageDecreased.getCustomerId());
            resevationHist.setMileage(mileageDecreased.getMileage());
            resevationHist.setEventType('마일리지적립취소');
            // view 레파지 토리에 save
            resevationHistRepository.save(resevationHist);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_UPDATE_(@Payload  ) {
        try {
            if (!.validate()) return;
                // view 객체 조회

                List<ResevationHist> resevationHistList = resevationHistRepository.findBy();
                for(ResevationHist resevationHist : resevationHistList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    resevationHist.set();
                // view 레파지 토리에 save
                resevationHistRepository.save(resevationHist);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCancelled_then_UPDATE_2(@Payload ReservationCancelled reservationCancelled) {
        try {
            if (!reservationCancelled.validate()) return;
                // view 객체 조회

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_DELETE_(@Payload  ) {
        try {
            if (!.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            resevationHistRepository.deleteBy();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

