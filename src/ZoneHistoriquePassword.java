
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ZoneHistoriquePassword implements Cloneable {

    @JsonProperty("historiquePassword")
    private String historiquePassword;

    public String getHistoriquePassword() {
        return historiquePassword;
    }

    public void setHistoriquePassword(String historiquePassword) {
        this.historiquePassword = historiquePassword;
    }

    public Object clone() {
        try {
            ZoneHistoriquePassword zhp = (ZoneHistoriquePassword) super.clone();
            if (historiquePassword != null) {
                String temp = historiquePassword;
                zhp.setHistoriquePassword(temp);
            }
            return zhp;
        } catch(CloneNotSupportedException e) {
            return null;
        }
    }

}