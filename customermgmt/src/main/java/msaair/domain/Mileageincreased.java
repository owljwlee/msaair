package msaair.domain;

import msaair.domain.*;
import msaair.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Mileageincreased extends AbstractEvent {

    private Long id;
    private Integer mileage;
    private Long customerId;

    public Mileageincreased(Mileage aggregate){
        super(aggregate);
    }
    public Mileageincreased(){
        super();
    }
}
