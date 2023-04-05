package comyz.service;

import comyz.dao.GsDao;
import comyz.dao.GsRepsotoryImpl;
import comyz.dao.UserDao;
import comyz.dao.UserRepsotoryImpl;
import comyz.entities.Gs;
import comyz.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class Userservice {

    @Autowired
    private UserDao userdao;
    //
    @Autowired
    private GsDao gsdao;

//	@Autowired
//	private UserRepsotoryImpl userRepsotory;
//
//	@Autowired
//	private GsRepsotoryImpl gsRepsotory;

    //	public Gs quidgs(int sid) {
//		return gsRepsotory.quidgs(sid);
//	}


    public List<Gs> qugs() {
        return gsdao.qugs();
    }
//
//	public List<Gs> qugsfeng(int pageno, int pagesize) {
//		return gsdao.qugsfenye(pageno, pagesize);
//	}


//	public Gs quidgs(int sid) {
//		return gsdao.quidgs(sid);
//	}

    //	@Transactional
    public void delete(int id) {
        userdao.userdelete(id);
    }

    //
//
    public void update(User user) {

        userdao.userupdate(user);

    }

    //
    public User queryid(int id) {
        User user = userdao.queryid(id);

        return user;
    }

    //
    public List<User> queryUser() {
        List<User> user = userdao.queryUser();
        return user;
    }

    //
//	public void af() {
//		userdao.af();
//	}
//
// public User querygs_ids(int gs_id) {
//
//	 return userdao.querygs_id(gs_id);
//}
//
//
    public List<User> queryUser(int pageno, int pagesize) {

        return userdao.userquery(pageno, pagesize);

    }

    public void addlist(List<User> user) {

        userdao.addlist(user);
    }


    public void add(User user) {
        userdao.userinsert(user);
    }

    public int counts(int pagesize) {

        return userdao.counts(pagesize);
    }


//	public int coun(int pagesize, int pageno) {
//
//		return userdao.count(pagesize,pageno);
//	}

//	public int countsgs(int pagesize) {
//		int a=gsdao.countsgs(pagesize);
////      int c  = Integer.parseInt(a.toString());
//		return a;
//	}


//	public int coungs(int pagesize, int pageno) {
//
//		return gsdao.coungs(pagesize,pageno);
//	}

//	public void addgss(Gs gs) {
//		gsdao.addgs(gs);
//	}
//
//	public void updateGss(Gs gs) {
//		gsdao.updateGs(gs);
//	}


//	public void deletegs(int sid) {
//		gsdao.delete(sid);
//	}

//	public List<User> qusid() {
//		return userdao.querygs_id();
//	}

//	public List<Integer> pdd() {
//		return gsdao.pdd();
//	}


}
