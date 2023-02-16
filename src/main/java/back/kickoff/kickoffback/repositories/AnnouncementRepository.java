package back.kickoff.kickoffback.repositories;

import back.kickoff.kickoffback.model.Announcement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface AnnouncementRepository extends CrudRepository<Announcement, Long> {
}
