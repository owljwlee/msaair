package msaair.domain;

import msaair.domain.*;
import msaair.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Mileageincreased extends AbstractEvent {

    private Long id;
    private Integer mileage;
    private Long customerId;
}


