package factories;

import java.util.HashMap;

public class IDandPasswords {
      HashMap<String, String> studentLoginInfo = new HashMap<String, String>();
      
      public IDandPasswords() {
		studentLoginInfo.put("123", "jowayne");
		studentLoginInfo.put("124", "justin");
	}
      
      public HashMap<String, String> getStudentLoginInfo() {
		return studentLoginInfo;
	}
}
