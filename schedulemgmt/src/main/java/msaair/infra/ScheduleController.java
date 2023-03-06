package msaair.infra;
import msaair.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/schedules")
@Transactional
public class ScheduleController {
    @Autowired
    ScheduleRepository scheduleRepository;



    @RequestMapping(value = "schedules/{id}/createschedule",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Schedule createSchedule(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /schedule/createSchedule  called #####");
            Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
            
            optionalSchedule.orElseThrow(()-> new Exception("No Entity Found"));
            Schedule schedule = optionalSchedule.get();
            schedule.createSchedule();
            
            scheduleRepository.save(schedule);
            return schedule;
            
    }
    



    @RequestMapping(value = "schedules/{id}/deleteschedule",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Schedule deleteSchedule(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /schedule/deleteSchedule  called #####");
            Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
            
            optionalSchedule.orElseThrow(()-> new Exception("No Entity Found"));
            Schedule schedule = optionalSchedule.get();
            schedule.deleteSchedule();
            
            scheduleRepository.save(schedule);
            return schedule;
            
    }
    



}
