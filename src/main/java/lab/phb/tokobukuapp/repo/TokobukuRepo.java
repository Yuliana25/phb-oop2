package lab.phb.tokobukuapp.repo;

import lab.phb.tokobukuapp.entity.Tokobuku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokobukuRepo 
        extends JpaRepository<Tokobuku,String>{
}
