package msaair.infra;
import msaair.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class ScheduleHateoasProcessor implements RepresentationModelProcessor<EntityModel<Schedule>>  {

    @Override
    public EntityModel<Schedule> process(EntityModel<Schedule> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/createschedule").withRel("createschedule"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/deleteschedule").withRel("deleteschedule"));

        
        return model;
    }
    
}
