package msaair.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="ResevationHist_table")
@Data
public class ResevationHist {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long customerId;
        private Long scheduleId;
        private Long mileage;
        private String eventType;


}
