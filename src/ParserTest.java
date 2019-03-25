import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParserTest {

	public static void main(String[] args) {
		HistoriquePassword historique = new HistoriquePassword();
		historique.setPassword("Passord1");
		historique.setDate(new Date());
		
		List<HistoriquePassword> historiquePasswordList = new ArrayList<>();
		historiquePasswordList.add(historique);
		
		ZoneHistoriquePasswordParser zhpp = new ZoneHistoriquePasswordParser();
		zhpp.setHistoriquePasswordList(historiquePasswordList);
		
		ZoneHistoriquePassword zhp = new ZoneHistoriquePassword();
		zhp.setHistoriquePassword(zhpp.toJson());
		
		System.out.println(zhp.getHistoriquePassword());
	}

}
