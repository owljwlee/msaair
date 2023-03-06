package msaair.external;

import lombok.Data;
import java.util.Date;
@Data
public class Schedule {

    private Long scheduleId;
    private String departure;
    private String arrival;
    private Date departtureTime;
    private Date arrivalTime;
}


