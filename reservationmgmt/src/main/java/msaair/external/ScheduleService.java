package msaair.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "schedulemgmt", url = "${api.url.schedulemgmt}")
public interface ScheduleService {
    @RequestMapping(method= RequestMethod.GET, path="/schedules/{scheduleId}")
    public Schedule getSchedule(@PathVariable("scheduleId") Long scheduleId);
}
