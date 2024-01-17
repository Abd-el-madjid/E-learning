package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.DaoAdmin;
import model.DaoUser;
import model.Daomodule;
import model.User;
import model.login;
import model.module;

public class k {

	public k() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
		// TODO Auto-generated method stub
		login login= new login();
        DaoAdmin DaoAdmin = new DaoAdmin();
        DaoUser DaoUser = new DaoUser();
        Daomodule module = new Daomodule();
           
//
//	
        module.getmodule_id("TL");
		
		 List<module> modules = new ArrayList<>(); //
		module.getteacher_modules("bounak@gmail.com");
		 module.etudiant_specialite("hanankabi@gmail.com");
		 System.out.println("/////////////////////");
		  modules=module.getmodules(); for (int iterator=0; iterator< modules.size()-1;
		  iterator++) {
		  System.out.println(modules.get(iterator).getName()+"        "+modules.get(
		  iterator).getSpecialte());
		  
		  }
		  /* * 
		 * System.out.println("               "); // modules=
		 * 
		 *  List<Integer> semainsId =
		 * module.getsemains_id("TL"); module.get_semains_info(semainsId,"TL");
		 * module.verifie_TP("a"); module.updateTP("a", "k", "l");
		 */
		int id= module.getspecialite_id("l3 si");
           module.getmodules(id);
           System.out.println(id);
           
 

List<String> listOfspecialite = new ArrayList<>();
listOfspecialite	= module.getspecialitesname();
Map<String, List<String>> result = module.getModulesForSpecialities(listOfspecialite);
for (Map.Entry<String, List<String>> entry : result.entrySet()) {
	entry.getKey();
	System.out.println(entry.getKey()+""+entry.getValue());
}
//           Map<String, List<String>> result =module.getModulesForSpecialities(listOfspecialite);
//           for (Map.Entry<String, List<String>> entry : result.entrySet()) {
//             System.out.println("Speciality: " + entry.getKey());
//             System.out.println("Modules: " + entry.getValue());
//           }
         //  module.getsemain("DAAW",1);
         //  module.update_semain("TL", 10, "2022-10-13", "2022-12-13");
         //  module.updateCour2(8, "kjk", "kk");
 //
//		  System.out.println("               ");
//		  
//		  
//		  module.getsemains("DAC"); ////// System.out.println("               ");
//		  
//		  module.getsemain_id("DAC", "2022-10-04", "2022-10-12");
//		  
//		  ////////// System.out.println("               ");
//		  module.getsemains_id("DAC");
//		  
//		  //////////////////////////////// System.out.println("               ");
//		  
//		  module.verifie_semain("DAC", "2022-10-04", "2022-10-12");
//		  //////////////////////////// System.out.println("    ");
//		  module.verifie_semain_info(1); //////////////////////////////////
//		  System.out.println("     "); module.verifie_cour(
//		  "https://drive.google.com/file/d/1bycy9QP7BMR6dKOsdIDLjbQf9FhnOuoh/view?usp=sharing"
//		  ); ///////////////////////////////// System.out.println("     ");
//		  module.verifie_TD(
//		  "https://drive.google.com/file/d/17KejmFhS2Ch1UUCZ9vfFyWDuI9R8jbOP/view");
//		  ///////////////////////////////// System.out.println("     ");
//		  module.verifie_TP(
//		  "https://drive.google.com/file/d/1s_eOmctOYhmbALxJpcgJ2WazNI8/view");
//		  
//		  //////////////////////////// System.out.println("            ");
//		 

  //      module.add_semain("TABD", "2022-10-05", "2022-10-13");
       
        
        
        
        
   //     module.delete_semain(module.getsemain_id("TABD", "2022-10-05", "2022-10-13"));
  
  /*    
        		  boolean user = DaoUser.checkClogin("madjidkah@gmail.com", "mad_k");

		     

        if (user ) {
      String account =DaoUser.getType("madjidkah@gmail.com");


            switch (account) {
                case "admin" -> {
                    // Admin Account
                  System.out.println("Admin Account");
                }
                case "teacher" -> {
                    // Teacher Account
                	 System.out.println("Teacher Account");
                }
                case "etudiant" -> {
                    // Student Account
                	 System.out.println("Student Account");
                }

            }
}*/
 }}
