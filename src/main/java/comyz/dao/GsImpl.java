package comyz.dao;

import comyz.entities.Gs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GsImpl {

    public List<Gs> gsquery(@Param("pageno") int pageno, @Param("pagesize") int pagesize);

    public List<Gs> qugs();

    public int countsgs();

    public List<Integer> pdd();

    public void gsinsert(Gs gs);

    public void gsupdate(Gs gs);

    public void gsdelete(int sid);

    public Gs quidgs(int sid);


}
