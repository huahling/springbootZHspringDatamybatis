package comyz.dao;

import comyz.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserRepsotoryImpl implements UserRepsotory {

    @Autowired
    private UserImpl userimpl;


    public List<User> userquery(int pageno, int pagesize) {

        int start = (pageno) * pagesize;

        List<User> userqu = userimpl.userquery(start, pagesize);

//		for (User user : userqu) {
//			System.out.println(user.toString());
//		}
        return userqu;

    }


    public int counts(int pagesize) {

        Object a = userimpl.counts();
        System.out.println(a);
//		Object a= session.createQuery(sql).uniqueResult();
        int c = Integer.parseInt(a.toString());
//
//		int cc=0;
//		if( c % pagesize ==0) {
//
//			 cc=(int) (c/pagesize);
//		}else {
//
//			 cc=(int) (c/pagesize);
////			 System.out.println(cc);
//			cc++;
//		}
//
//		int a1=(int) Math.ceil(cc);

        return c;
    }


    public int count(int pagesize, int pageno) {

        Object a = userimpl.count(pagesize, pageno);
//
//		session=getSession();
//		String sql="select count(*) from User";
//
//
//		Object a= session.createQuery(sql).uniqueResult();
        int c = Integer.parseInt(a.toString());
//
        if (c % pagesize == 0) {
            pageno--;
        }

        return pageno;
    }


    public void userdelete(int id) {
        userimpl.userdelete(id);
    }

    public void userupdate(User user) {

        userimpl.userupdate(user);

    }

    public void addlist(List<User> user) {

        for (User user1 : user) {
            userimpl.userinsert(user1);
        }

//	 	 String sql="insert into us(name,addr,sex,password,gs_id,birth,hand) value(?,?,?,?,?,?,?)";
    }


    public void userinsert(User user) {

        userimpl.userinsert(user);

    }


    public User queryid(int id) {

        User user = userimpl.queryid(id);

        return user;


    }

    public List<User> queryUser() {

        List<User> user = userimpl.queryUser();

//		System.out.println(user.toString());
        return user;


    }

    //
//
//
//
    public List<User> querygs_id() {
//		session=getSession();
//		String jpql = "select gs_id from User";
//		Query query= session.createQuery(jpql);
//
//		return query.list();
//
        return null;
    }

    public List<User> ss(int pageno, int pagesize) {
//
//			session=getSession();
//			String jpql = "from User";
//
//			int start= (pageno)*pagesize;
//			Query query= session.createQuery(jpql).setFirstResult(start).setMaxResults(pagesize);
//
//			return query.list();
//
        return null;
    }


    //    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<User> userquery(int pageno, int pagesize) {
//
//        String jpql = " select u from User u";
//
//        int start= (pageno)*pagesize;
//        List<User> list1 = entityManager.createQuery(jpql).setFirstResult(start).setMaxResults(pagesize).getResultList();
//
//        return list1;
//
//    }
//
//	public List<User> queryUser() {
//        String jpql = " select u,g from User u,Gs g where u.gs_id=g.sid";
//        List<User> user = entityManager.createQuery(jpql).getResultList();
//
//        return user;
//    }
//
////    public int counts(int pagesize){
////
////        String jpql = "select count(u) from User u";
////        String a= entityManager.createQuery(jpql).toString();
////
////        int c = Integer.parseInt(a);
////
////        return c;
////    }
//
//
//    public  User queryid(int id){
//
//       User user = entityManager.find(User.class,id);
//
//        return user;
//    }
//
//    public void userinsert(User user) {
//        User user1 =new User();
//        user1.setName(user.getName());
//        user1.setAddr(user.getAddr());
//        user1.setSex(user.getSex());
//        user1.setPassword(user.getPassword());
//        user1.setGs_id(user.getGs().getSid());
//        user1.setBirth(user.getBirth());
//        user1.setHand(user.getHand());
//
//        entityManager.persist(user1);
//	}
//
//    	public void userdelete(int id){
//
//            User user=entityManager.find(User.class,id);
//            entityManager.remove(user);
//	}
//
//	public void userupdate(User user) {
//
//        User updateuser =entityManager.find(User.class,user.getId());
//        updateuser.setName(user.getName());
//        updateuser.setAddr(user.getAddr());
//        updateuser.setSex(user.getSex());
//        updateuser.setPassword(user.getPassword());
//        updateuser.setGs_id(user.getGs_id());
//        updateuser.setBirth(user.getBirth());
//        updateuser.setHand(user.getHand());
//
//	}
//
//    	public void addlist(List<User> user) {
//
//		for (User user1 : user) {
//            entityManager.persist(user);
//		}
//
//	}
//
    public void af() {

        System.out.println(11111111);
    }


}
