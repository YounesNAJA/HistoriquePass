import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Historique {
	public String toJson() {
        String dataJson = "";
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        // om.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
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
        return dataJson;
    }

    public static ZoneHistoriquePasswordParser fromJson(String json) {

        ObjectMapper mapper = new ObjectMapper();
        ZoneHistoriquePasswordParser readValue = new ZoneHistoriquePasswordParser();

        try {
            readValue = mapper
                    .readValue(json, ZoneHistoriquePasswordParser.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return readValue;
    }
}
