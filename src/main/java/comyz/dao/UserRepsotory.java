package comyz.dao;

import comyz.entities.User;

import java.util.List;

public interface UserRepsotory {

    public List<User> userquery(int pageno, int pagesize);

    public List<User> queryUser();

    public int counts(int pagesize);

    public User queryid(int id);

    public void userinsert(User user);

    public void userdelete(int id);

    public void userupdate(User user);

    public void addlist(List<User> user);

    public void af();

}
