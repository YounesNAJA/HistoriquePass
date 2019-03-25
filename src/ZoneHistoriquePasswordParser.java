import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class ZoneHistoriquePasswordParser {

    private List<HistoriquePassword> historiquePasswordList;

    public List<HistoriquePassword> getHistoriquePasswordList() {
        return historiquePasswordList;
    }

    public void setHistoriquePasswordList(List<HistoriquePassword> historiquePasswordList) {
        this.historiquePasswordList = historiquePasswordList;
    }

    public void caserMdp(HistoriquePassword historiquePassword) {
        if(historiquePasswordList != null) {
            if(historiquePasswordList.size() >= 3) {
                this.historiquePasswordList.set(0, this.historiquePasswordList.get(1));
                this.historiquePasswordList.set(1, this.historiquePasswordList.get(2));
                this.historiquePasswordList.set(2, historiquePassword);
            } else {
                this.historiquePasswordList.add(historiquePassword);
            }
        } else {
            List<HistoriquePassword> historiquePasswordList1 = new ArrayList<HistoriquePassword>();
            historiquePasswordList1.add(historiquePassword);
            historiquePasswordList = historiquePasswordList1;
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ZoneHistoriquePassword)) return false;
//        ZoneHistoriquePassword that = (ZoneHistoriquePassword) o;
//        return getHistoriquePassword().equals(that.getHistoriquePassword());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getHistoriquePassword());
//    }

    public String toJson() {
        String dataJson = "";
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        
        try {
            Writer w = new StringWriter();
            
            om.writeValue(w, this);
            dataJson = w.toString();
        }
        catch (JsonMappingException jme) {
            jme.printStackTrace();
        }
        catch (JsonParseException jpe) {
            jpe.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        
        return dataJson.substring(dataJson.indexOf("["), dataJson.lastIndexOf("]") + 1);
    }

    public static List<HistoriquePassword> fromJson(String json) {

        ObjectMapper mapper = new ObjectMapper();
        
        List<HistoriquePassword> historique = new ArrayList<HistoriquePassword>();

        
        try {
        	TypeFactory typeFactory = mapper.getTypeFactory();
            historique = mapper.readValue(json, typeFactory.constructCollectionType(List.class, HistoriquePassword.class));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return historique;
    }

//    public Object clone() {
//        try {
//            ZoneHistoriquePassword zhp = (ZoneHistoriquePassword) super.clone();
//            zhp.setHistoriquePassword(historiquePassword);
//            return zhp;
//        }
//        catch (CloneNotSupportedException e) {
//            return null;
//        }
//    }


}

