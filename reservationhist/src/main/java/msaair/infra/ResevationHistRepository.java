package msaair.infra;

import msaair.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="resevationHists", path="resevationHists")
public interface ResevationHistRepository extends PagingAndSortingRepository<ResevationHist, Long> {

    

    
}
