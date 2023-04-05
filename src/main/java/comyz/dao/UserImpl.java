package comyz.dao;

import comyz.entities.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserImpl {

    public List<User> userquery(@Param("pageno") int pageno, @Param("pagesize") int pagesize);

    public User queryid(int id);

    public List<User> queryUser();

    public int counts();

    public int count(@Param("pagesize") int pagesize, @Param("pageno") int pageno);

    public void userinsert(User user);

    public void userupdate(User user);

    public void userdelete(int id);
}
