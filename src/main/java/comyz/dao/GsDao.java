package comyz.dao;

import comyz.entities.Gs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GsDao extends JpaRepository<Gs, Integer>, JpaSpecificationExecutor<Gs>, GsRepsotory {

//  private GsImpl gsimpl;//mybatis SpringData
//
//  public Gs quidgs1(int sid) {
//
//    return gsimpl.quidgs(sid);
//  }
//  public void delete1(int sid) {
//    gsimpl.gsdelete(sid);
//
//  }
//  public void addgs1(Gs gs) {
//
//    gsimpl.gsinsert(gs);
//
//  }


}

