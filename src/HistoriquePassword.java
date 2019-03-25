import java.util.Date;
import java.util.Objects;

public class HistoriquePassword implements Cloneable {
    private String password;
    private Date date;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoriquePassword)) return false;
        HistoriquePassword that = (HistoriquePassword) o;
        return getPassword().equals(that.getPassword()) &&
                getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getDate());
    }

    @Override
    public Object clone() {
        try {
            HistoriquePassword hp = (HistoriquePassword) super.clone();

            return hp;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
