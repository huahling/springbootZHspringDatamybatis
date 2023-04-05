package comyz.entities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


//@Cacheable(true)
@Table(name = "us")
@Entity
public class User {

    private int id;

    //	@Length(max = 6)
    @NotEmpty
    private String name;
    @NotEmpty

    private String addr;
    private String sex;
    private int gs_id;
    //��ʽ��
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//HH:mm:ss
//	@Past
//	@Future
    private Date birth;


    private String hand;
    //����У�����ע��

    //	@NumberFormat(pattern = "###,###.##")Ǯ���ָ�ʽ��
    @NotEmpty
    private String password;

    private Gs gs;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGs_id() {
        return gs_id;
    }

    public void setGs_id(int gs_id) {
        this.gs_id = gs_id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//	private String yuangong;
//
//	public String getYuangong() {
//		return yuangong;
//	}
//
//	public void setYuangong(String yuangong) {
//		this.yuangong = yuangong;
//	}

    @JoinColumn(name = "gs_id", insertable = false, updatable = false)
    @ManyToOne()
    public Gs getGs() {
        return gs;
    }

    public void setGs(Gs gs) {
        this.gs = gs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", sex='" + sex + '\'' +
                ", gs_id=" + gs_id +
                ", birth=" + birth +
                ", hand='" + hand + '\'' +
                ", password='" + password + '\'' +
                ", gs=" + gs +
                '}';
    }
}
