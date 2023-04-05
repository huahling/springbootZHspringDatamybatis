package comyz.dao;

import comyz.entities.Gs;
import comyz.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GsRepsotoryImpl implements GsRepsotory {
    //
//    //注入jpa
////    @PersistenceContext
////    private EntityManager entityManager;//JPA springData
//
////    //注入mybatis impl
    @Autowired
    private GsImpl gsimpl;//mybatis SpringData

    //
//
//
//    public List<Gs> qugsfenye(int pageno, int pagesize){
//
//        int start= (pageno)*pagesize;
//        List<Gs> list= gsimpl.gsquery(start,pagesize);
//
//        return list;
//    }
//
//
    public List<Gs> qugs() {

        return gsimpl.qugs();

    }
}
//
//
//
//    public int countsgs(int pagesize) {
//
//        Object a= gsimpl.countsgs();
////			session=getSession();
////			String sql="select count(*) from Gs";
////
////
////			Object a= session.createQuery(sql).uniqueResult();
//        int c  = Integer.parseInt(a.toString());
////
////			int cc=0;
////			if( c % pagesize ==0) {
////
////				 cc=(int) (c/pagesize);
////			}else {
////
////				 cc=(int) (c/pagesize);
//////				 System.out.println(cc);
////				cc++;
////			}
////
////
////
////			int a1=(int) Math.ceil(cc);
//
//        return c;
//    }
//
//
////		public int coungs(int pagesize,int pageno) {
////
////		   Object a= gsimpl.coungs(pagesize,pageno);
////
//////			Object a= session.createQuery(sql).uniqueResult();
////			int c  = Integer.parseInt(a.toString());
//////
////			if( c % pagesize ==0) {
////				pageno--;
////			}
////
////			return pageno;
////
////		}
//
//
//
//
//
//    public Gs quidgs(int sid) {
//
//        return gsimpl.quidgs(sid);
//    }
//
//    public void delete(int sid) {
//        gsimpl.gsdelete(sid);
//
//    }
//
//    public void addgs(Gs gs) {
//
//        gsimpl.gsinsert(gs);
//
//    }
//
//
//    public void updateGs(Gs gs) {
//        gsimpl.gsupdate(gs);
//
//    }
//
//
//    public List<Integer> pdd(){
//
//        List<Integer> list= gsimpl.pdd();
//
////		 for (Integer userfu : list) {
////			 System.out.println("---------------");
////			 	System.out.println("打印"+userfu.toString()+"打印");
////			 System.out.println("---------------");
////		 	}
//
//        return list;
//    }
//
//}
