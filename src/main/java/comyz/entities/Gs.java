package comyz.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//@Cacheable(true)
@Table(name = "gongsi")
@Entity
public class Gs {

    private int sid;
    private String yuangong;

    Set<User> users = new HashSet<User>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getYuangong() {
        return yuangong;
    }

    public void setYuangong(String yuangong) {
        this.yuangong = yuangong;
    }

    @OneToMany(mappedBy = "gs") /* ,cascade = CascadeType.REMOVE */
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Gs [sid=" + sid + ", yuangong=" + yuangong + "]";
    }


}
