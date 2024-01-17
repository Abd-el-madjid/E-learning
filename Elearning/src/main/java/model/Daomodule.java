package model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DaoUser;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Daomodule {
    private final String url = "jdbc:mysql://localhost:3306/elearning3";
    private final String root = "root";
    private final String password = "04122002";
    //
    DaoUser DaoUser = new DaoUser();
    private Connection connection;
    private PreparedStatement preparedStatement;

    //
    public Daomodule() {
        //
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, root, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //
    public boolean testConnection() {
        //
        try {
            DriverManager.getConnection(url, root, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<module> getEtudiandt_modules2(String studentEmail) {
        //
        studentEmail = studentEmail.trim();
        List<module> modules = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select  email, modules.name,modules.specialte from etudiant_modules , modules where modules.id_module=etudiant_modules.modules and etudiant_modules.email = ?");

            preparedStatement.setString(1, studentEmail);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                module module = new module(resultSet.getString(2), resultSet.getString(3));
                System.out.println(resultSet.getString(1)+"      "+ resultSet.getString(2)+" "+ resultSet.getString(3));
                
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }
    
    public Map<String, List<String>> getModulesForSpecialities(List<String> specialityNames) {
    	  Map<String, List<String>> result = new HashMap<>();
    	  try  {
    	   
    	    for (String specialityName : specialityNames) {
    	    	int id = getspecialite_id(specialityName);
    	      List<String> modules = new ArrayList<>();
              
    	      ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM modules WHERE specialte = '" + id + "' ");
    	      while (resultSet.next()) {
    	        modules.add(resultSet.getString("name"));
    	      }
    	      result.put(specialityName, modules);
    	    }
    	  } catch (SQLException e) {
    	    e.printStackTrace();
    	  }
    	  return result;
    	}
    



    public List<String > getspecialitesname() {
        //
        List<String> specialites = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select name from specialte");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                String module = resultSet.getString("name");

                specialites.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return specialites;
    }
 
    public List<String > getspecialites() {
        //
        List<String> specialites = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select id_specialte from specialte");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                String module = resultSet.getString("id_specialte");

                specialites.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return specialites;
    }
    
    public List<module> getmodules() {
        //
        List<module> modules = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from modules,specialte where specialte=id_specialte ");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                module module = new module(resultSet.getString(2), resultSet.getString("specialte.name"));

                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }
    public List<module> getmodules(int speciality) {
        //
        List<module> modules = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from modules,specialte where specialte=id_specialte and id_specialte=? ");
           
            preparedStatement.setInt(1, speciality);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                module module = new module(resultSet.getString(2), resultSet.getString(3));
System.out.println(resultSet.getString(2)+"    "+resultSet.getString(3));
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }

    //
    public List<module> getteacher_modules(String teacherEmail) {
        //
      
        List<module> modules = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select users.user_email, modules.name,specialte.name from teacher_modules , modules ,specialte,users where modules.specialte = specialte.id_specialte and modules.id_module=teacher_modules.modules and teacher_modules.user_id = users.user_id and users.user_email=?");

            preparedStatement.setString(1, teacherEmail);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                module module = new module(resultSet.getString(2), resultSet.getString(3));
System.out.println(resultSet.getString(1)+"      "+ resultSet.getString(2)+" "+ resultSet.getString(3));
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }

    //
    public List<module> getEtudiandt_modules(String studentEmail) {
        //
        studentEmail = studentEmail.trim();
        List<module> modules = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select  user_email, modules.name,specialte.name from etudiant_specialtes , modules,specialte,users where specialte.id_specialte=modules.specialte  and specialte.id_specialte=etudiant_specialtes.specialte and etudiant_specialtes.user_id = users.user_id and users.user_email=?");

            preparedStatement.setString(1, studentEmail);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                module module = new module(resultSet.getString(2), resultSet.getString(3));
                System.out.println(resultSet.getString(1)+"      "+ resultSet.getString(2)+" "+ resultSet.getString(3));
                
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }

    //
    public HashMap<Integer, String> getsemains(String moduleName) {
        //
        moduleName = moduleName.trim();
        HashMap<Integer, String> planing_semain = new HashMap<>();

        try {
            preparedStatement = connection.prepareStatement(" select id_semain,semain_debut,semain_fin,modules from teaching_semain,modules where modules = id_module and modules.name=? order by semain_debut");

            preparedStatement.setString(1, moduleName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                int id_semain = resultSet.getInt(1);
                LocalDate semain_debut = resultSet.getDate(2).toLocalDate();
                LocalDate semain_fin = resultSet.getDate(3).toLocalDate();
        String module = resultSet.getString(4);
                //
                String jour_debut = String.valueOf(semain_debut.getDayOfMonth());
                String mois_debut = semain_debut.getMonth().toString();
                String jour_fin = String.valueOf(semain_fin.getDayOfMonth());
                String mois_fin = semain_fin.getMonth().toString();

                //
                String semain =jour_debut + " " +  mois_debut + " // " + jour_fin + " " +mois_fin ;

                planing_semain.put(id_semain, semain);
                System.out.println(id_semain+ "  "+module+"  "+ semain);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planing_semain;
    }
    //////////////
    public boolean update_semain(String moduleName, int id_semain ,String semain_debut,String semain_fin) {
    	int id = getmodule_id(moduleName);
        try {
            //
            preparedStatement = connection.prepareStatement("  Update teaching_semain Set semain_debut=? , semain_fin=? Where modules=? and id_semain =?");

            preparedStatement.setString(1, semain_debut);
            preparedStatement.setString(2, semain_fin);
            preparedStatement.setInt(	3, id);
            preparedStatement.setInt(4, id_semain);
     

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
/////
    public HashMap<LocalDate, LocalDate>  getsemain(String moduleName, int id_semain) {
        //
        moduleName = moduleName.trim();
        HashMap<LocalDate, LocalDate> planing_semain = new HashMap<>();
        int id = getmodule_id(moduleName);

        int semain_id = 0;

        try {
            preparedStatement = connection.prepareStatement(" select semain_debut,semain_fin from teaching_semain,modules where modules =modules.id_module and modules.name=?  AND  id_semain =? ");

            preparedStatement.setString(1, moduleName);
            preparedStatement.setInt(2, id_semain);
            ResultSet resultSet = preparedStatement.executeQuery();
          while(  resultSet.next()){
            LocalDate semain_debut = resultSet.getDate(1).toLocalDate();
            LocalDate semain_fin = resultSet.getDate(2).toLocalDate();
            //
            planing_semain.put(semain_debut, semain_fin);
System.out.println(planing_semain);}

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planing_semain;
    }
    //
    public int getsemain_id(String moduleName, String debut_semain, String fin_semain) {
        //
        moduleName = moduleName.trim();
        debut_semain = debut_semain.trim();
        fin_semain = fin_semain.trim();
        int id = getmodule_id(moduleName);
        int semain_id = 0;

        try {
            preparedStatement = connection.prepareStatement(" select id_semain from teaching_semain,modules where modules=modules.id_module and modules.name=? and  AND semain_debut =? AND semain_fin=? LIMIT 1");

            preparedStatement.setString(1, moduleName);
            preparedStatement.setString(2, debut_semain);
            preparedStatement.setString(3, fin_semain);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            //
            semain_id = resultSet.getInt(1);
System.out.println(semain_id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return semain_id;
    }

    
    //
    public List<Integer> getsemains_id(String moduleName) {
        //
        moduleName = moduleName.trim();
        int id = getmodule_id(moduleName);
        List<Integer> semains_id = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(" select id_semain from teaching_semain,modules where modules = modules.id_module and modules.name=? order by id_semain");

            preparedStatement.setString(1, moduleName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                int semain_id = resultSet.getInt(1);

                semains_id.add(semain_id);
System.out.println(semain_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return semains_id;
    }

    public boolean verifie_semain(String moduleName, String debut_semain, String fin_semain) {
        //
        moduleName = moduleName.trim();
        debut_semain = debut_semain.trim();
        fin_semain = fin_semain.trim();
        int id = getmodule_id(moduleName);

        try {
            //
            preparedStatement = connection.prepareStatement(" Select * from teaching_semain where modules = ? AND semain_debut=? AND semain_fin=?");

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, debut_semain);
            preparedStatement.setString(3, fin_semain);

            ResultSet resultSet = preparedStatement.executeQuery(); 
           boolean k = resultSet.next();
           System.out.println(k);
            return k;
         
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean  verifie_semain_info(int semain_id) {
        //
        try {
            //
            preparedStatement = connection.prepareStatement(" Select * from module_info where teaching_semain = ? LIMIT 1");

            preparedStatement.setInt(1, semain_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean k = resultSet.next();
            System.out.println(k);
             return k;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean verifie_cour(String lien) {
        //
        try {
            //
            preparedStatement = connection.prepareStatement("Select * from module_cour where cour_lien = ? LIMIT 1");

            preparedStatement.setString(1, lien);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean k = resultSet.next();
            System.out.println(k);
             return k;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean verifie_TD(String lien) {
        //
        try {
            //
            preparedStatement = connection.prepareStatement("Select * from module_td where td_lien = ?LIMIT 1");

            preparedStatement.setString(1, lien);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean k = resultSet.next();
            System.out.println(k);
             return k;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean verifie_TP(String lien) {
        //
        try {
            //
            preparedStatement = connection.prepareStatement(" Select * from module_tp where tp_lien = ? LIMIT 1");

            preparedStatement.setString(1, lien);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean k = resultSet.next();
            System.out.println(k);
             return k;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //
    public boolean add_semain(String moduleName, String debut_semain, String fin_semain) {
        //
        moduleName = moduleName.trim();
        debut_semain = debut_semain.trim();
        fin_semain = fin_semain.trim();
        int id = getmodule_id(moduleName);
        //
        boolean k = true;

        try {
            //
            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`teaching_semain` ( `modules`, `semain_debut`, `semain_fin`) VALUES ( ?, ?, ?)");

            
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, debut_semain);
            preparedStatement.setString(3, fin_semain);

            preparedStatement.executeUpdate();
           
            System.out.println(k);
             return k;

        } catch (SQLException e) {
            e.printStackTrace();
            return k=false;
        }

    }

    //
    public boolean delete_semain(int id_semain) {
        //
    	  boolean k ;
        if (id_semain == 0) {
            return k=false;
        }

        //
      

        try {
            //
            preparedStatement = connection.prepareStatement(" Delete from teaching_semain where id_semain=?");

            preparedStatement.setInt(1, id_semain);

            preparedStatement.executeUpdate();
            k = true;
            System.out.println(k +"      semain deleted");
            return k;

        } catch (SQLException e) {
            e.printStackTrace();
            return k=false;
        }

    }

    //
    public boolean deleteCours(int id_semain,String module) {
        //
    	  boolean k ;
          if (id_semain == 0) {
              return k=false;
          }
          int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement("Delete from module_cour where teaching_semain = ? and  modules=?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(	2, id);
            preparedStatement.executeUpdate();
            k = true;
            System.out.println(k +"      cour deleted");
            return k;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    public boolean deleteTDs(int id_semain,String module) {
        //
    	 boolean k ;
        if (id_semain == 0) {
            return k=false;
        }
        int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement(" Delete from module_td  where teaching_semain = ?  and modules=? ");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(	2, id);
            preparedStatement.executeUpdate();
            k = true;
            System.out.println(k +"      td deleted");
            return k;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    public boolean deleteTPs(int id_semain,String module) {
        //
    	 boolean k ;
        if (id_semain == 0) {
            return false;
        }
        int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement("Delete from module_tp  where teaching_semain = ?and  modules=?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(	2, id);
            preparedStatement.executeUpdate();
            k = true;
            System.out.println(k +"   tp deleted");
            return k;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    public boolean delete_module_info(int id_semain,String module) {
        //
    	 boolean k ;
        if (id_semain == 0) {
            return false;
        }
        int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement("Delete from module_info where  teaching_semain =? and modules=?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(	2, id);
            preparedStatement.executeUpdate();
            k = true;
            System.out.println(k +"      semain deleted");
            return k;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    //
    public boolean update_module_info(int id_semain,String module, String info) {
        //
    	info = info.trim();

        if (info.isBlank()) {
            return false;
        }
        int id = getmodule_id(module);
        //
        if (!verifie_semain_info(id_semain)) {

            try {
                //
                preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`module_info` (`teaching_semain`, `modules`,`descriptionInfo`)Values (?,?,?)");

                preparedStatement.setInt(1, id_semain);
                preparedStatement.setInt(	2, id);
                preparedStatement.setString(3, info);
                preparedStatement.executeUpdate();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            try {
                //
                preparedStatement = connection.prepareStatement("  Update module_info Set descriptionInfo=?Where modules=? and teaching_semain =?");

                preparedStatement.setString(1, info);
                preparedStatement.setInt(	2, id);
                preparedStatement.setInt(3, id_semain);
         

                preparedStatement.executeUpdate();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    }
    
    
    
    public boolean addshit(int id_semain,String module, String lien, String name, InputStream pdf) {
        //
        lien = lien.trim();
        name = name.trim();
        module=module.trim();
        //
        if (verifie_TP(lien)) {
            return false;
        }
        int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`module_tp` (`tp_lien`, `tp_name`,`tp_pdf`,`modules`, `teaching_semain`) Values (?,?,?,?,?)");

            preparedStatement.setString(1, lien);
            preparedStatement.setString(2, name);
            if (pdf != null) {
                // fetches input stream of the upload file for the blob column
                preparedStatement.setBlob(3, pdf);
            }
            preparedStatement.setInt(4, id);
            preparedStatement.setInt(5, id_semain);

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    public boolean addCour(int id_semain,String module, String lien, String name , InputStream pdf) {
        //
        lien = lien.trim();
        name = name.trim();
        module=module.trim();
        //
        if (verifie_cour(lien)) {
            return false;
        }
        int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`module_cour` (`cour_lien`, `cour_name`,`cour_pdf`, `modules`, `teaching_semain`)Values (?,?,?,?,?)");

            preparedStatement.setString(1, lien);
            preparedStatement.setString(2, name);
            if (pdf != null) {
                // fetches input stream of the upload file for the blob column
                preparedStatement.setBlob(3, pdf);
            }
            preparedStatement.setInt(4, id);
            preparedStatement.setInt(5, id_semain);

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    public boolean addTD(int id_semain, String module,String lien, String name , InputStream pdf,String type) {
        //
        lien = lien.trim();
        name = name.trim();
        module=module.trim();
        //
        if (verifie_TD(lien)) {
            return false;
        }
        int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`module_TD` (`td_lien`, `td_name`,`td_pdf`, `td_type`, `modules`,`teaching_semain`) Values (?,?,?,?,?,?)");

            preparedStatement.setString(1, lien);
            preparedStatement.setString(2, name);
            if (pdf != null) {
                // fetches input stream of the upload file for the blob column
                preparedStatement.setBlob(3, pdf);
            }
            preparedStatement.setString(4, type);
            preparedStatement.setInt(5, id);
            preparedStatement.setInt(6, id_semain);

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    public boolean addTP(int id_semain,String module, String lien, String name , InputStream pdf,String type) {
        //
    
        //
        if (verifie_TP(lien)) {
            return false;
        }
        int id = getmodule_id(module);
        try {
            //
            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`module_TP` (`tp_lien`, `tp_name`,`tp_pdf`,`tp_type`,`modules`, `teaching_semain`) Values (?,?,?,?,?,?)");
            preparedStatement.setString(1, lien);
            preparedStatement.setString(2, name);
            if (pdf != null) {
                // fetches input stream of the upload file for the blob column
                preparedStatement.setBlob(3, pdf);
            }
            preparedStatement.setString(4, type);
            preparedStatement.setInt(5, id);
            preparedStatement.setInt(6, id_semain);

            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //
    public String get_semain_info(int id_semain,String module) {
        //
        String description = "";
        int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement("select descriptionInfo from module_info  where teaching_semain = ? and modules =?");

            preparedStatement.setInt(1, id_semain);

            preparedStatement.setInt(2, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            //
            description = resultSet.getString(1);
System.out.println(description);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return description;
    }

    //
    public HashMap<Integer, String> get_semains_info(List<Integer> id_semains,String module) {
        //
        HashMap<Integer, String> information = new HashMap<>();

        //
        for (Integer id_semain : id_semains) {
            //
            String info = this.get_semain_info(id_semain,module);
            information.put(id_semain, info);
            System.out.println(information);
        }

        return information;
    }


    //
    public HashMap<String, String> getCour_module(int id_semain , String module) {
        //
        HashMap<String, String> cours = new HashMap<>();
        int id = getmodule_id(module);

        try {
            preparedStatement = connection.prepareStatement(" select cour_lien,cour_name from module_cour where teaching_semain = ? and modules =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                String courlien = resultSet.getString(1);
                String courName = resultSet.getString(2);

                cours.put(courlien, courName);
System.out.println(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cours;
    }
    ///
    public int getCour_id(int id_semain , String module,String lien) {
        //
      int id_cour =0;
      int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select id_cour from module_cour where teaching_semain = ? and modules =? and cour_lien =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, lien);
            ResultSet resultSet = preparedStatement.executeQuery();

           
                resultSet.next();
            	id_cour = resultSet.getInt("id_cour");
              
               
System.out.println(id_cour);
return id_cour;
        } catch (SQLException e) {
            e.printStackTrace();
            return id_cour=0;
        }

      
    }
    ///
   
    ///
    public int getCour_pdf(int uploadId ) {
        //
      int id_cour =0;

        try {
            preparedStatement = connection.prepareStatement(" SELECT cour_pdf FROM module_cour WHERE id_cour = ?");

            preparedStatement.setInt(1, uploadId);
            ResultSet resultSet = preparedStatement.executeQuery();

           
                resultSet.next();
                Blob blob = resultSet.getBlob("cour_pdf");

               
System.out.println(id_cour);
return id_cour;
        } catch (SQLException e) {
            e.printStackTrace();
            return id_cour=0;
        }

      
    }
    ///
    //
    public HashMap<Integer, HashMap<String, String>> getCours(List<Integer> id_semains,String module) {
        //
        HashMap<Integer, HashMap<String, String>> cours = new HashMap<>();
        HashMap<String, String> cour;

        //
        for (Integer id_semain : id_semains) {
            //
            cour = this.getCour_module(id_semain,module);
            cours.put(id_semain, cour);

        }

        return cours;
    }

    //
    
    
    
    public HashMap<String, String> getCour2(int id_semain , String module) {
        //
        HashMap<String, String> cours = new HashMap<>();
        int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select id_cour,cour_lien from module_cour where teaching_semain = ? and modules =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                String id_cour = resultSet.getString(1);
                String cour_lien = resultSet.getString(2);

                cours.put(id_cour, cour_lien);
System.out.println(cours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cours;
    }
    
    public HashMap<Integer, HashMap<String, String>> getCours_2(List<Integer> id_semains,String module) {
        //
        HashMap<Integer, HashMap<String, String>> cours = new HashMap<>();
        HashMap<String, String> cour;

        //
        for (Integer id_semain : id_semains) {
            //
            cour = this.getCour2(id_semain,module);
            cours.put(id_semain, cour);

        }

        return cours;
    }
    //
    public int gettd_id(int id_semain , String module,String lien) {
        //
      int id_td=0;
      int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select id_td from module_td where teaching_semain = ? and modules =? and td_lien =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, lien);
            ResultSet resultSet = preparedStatement.executeQuery();

           
                resultSet.next();
            	id_td = resultSet.getInt("id_td");
              
               
System.out.println(id_td);
return id_td;
        } catch (SQLException e) {
            e.printStackTrace();
            return id_td=0;
        }

      
    }
    //////////
    public String gettd_type(int id_semain , String module,String lien) {
        //
      String id_td;
      int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select td_type from module_td where teaching_semain = ? and modules =? and td_lien =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, lien);
            ResultSet resultSet = preparedStatement.executeQuery();

           
                resultSet.next();
            	id_td = resultSet.getString("td_type");
              
               
System.out.println(id_td);

        } catch (SQLException e) {
            e.printStackTrace();
            return id_td=null;
        }

        return id_td;
    }
    ///////////
    
    
    public HashMap<String, String> getTD(int id_semain, String module) {
        //
        HashMap<String, String> tds = new HashMap<>();
        int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select td_lien,td_name from module_td where teaching_semain = ? and modules =?");

            preparedStatement.setInt(1, id_semain);

            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                String tdlien = resultSet.getString(1);
                String tdName = resultSet.getString(2);

                tds.put(tdlien, tdName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tds;
    }

    //
    public HashMap<Integer, HashMap<String, String>> getTDs(List<Integer> id_semains,String module) {
        //
        HashMap<Integer, HashMap<String, String>> tds = new HashMap<>();
        HashMap<String, String> td;

        //
        for (Integer id_semain : id_semains) {
            //
            td = this.getTD(id_semain,module);
            tds.put(id_semain, td);

        }

        return tds;
    }
///////////////
    
    public HashMap<String, String> getTD2(int id_semain , String module) {
        //
        HashMap<String, String> tds = new HashMap<>();
        int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select id_td,td_lien from module_td where teaching_semain = ? and modules =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                String id_td = resultSet.getString(1);
                String td_lien = resultSet.getString(2);

                tds.put(id_td, td_lien);
System.out.println(tds);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tds;
    }
    
    public HashMap<Integer, HashMap<String, String>> getTDs_2(List<Integer> id_semains,String module) {
        //
        HashMap<Integer, HashMap<String, String>> tds = new HashMap<>();
        HashMap<String, String> td;

        //
        for (Integer id_semain : id_semains) {
            //
            td = this.getTD2(id_semain,module);
          tds.put(id_semain, td);

        }

        return tds;
    }
    //
    //////////////////////
    
    
    
    
    public int gettp_id(int id_semain , String module,String lien) {
        //
      int id_tp=0;
      int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select id_tp from module_tp where teaching_semain = ? and modules =? and tp_lien =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, lien);
            ResultSet resultSet = preparedStatement.executeQuery();

           
                resultSet.next();
            	id_tp = resultSet.getInt("id_tp");
              
               
System.out.println(id_tp);
return id_tp;
        } catch (SQLException e) {
            e.printStackTrace();
            return id_tp=0;
        }

      
    }
    //
    
    public String gettp_type(int id_semain , String module,String lien) {
        //
      String id_tp;
      int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement(" select tp_type from module_tp where teaching_semain = ? and modules =? and tp_lien =?");

            preparedStatement.setInt(1, id_semain);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, lien);
            ResultSet resultSet = preparedStatement.executeQuery();

           
                resultSet.next();
            	id_tp = resultSet.getString("tp_type");
              
               
System.out.println(id_tp);

        } catch (SQLException e) {
            e.printStackTrace();
            return id_tp=null;
        }

        return id_tp;
    }
    
    
    //
    public HashMap<String, String> getTP(int id_semain,String module) {
        //
        HashMap<String, String> tps = new HashMap<>();
        int id = getmodule_id(module);
        try {
            preparedStatement = connection.prepareStatement("select tp_lien,tp_name from module_tp where teaching_semain = ? and modules =?");

            preparedStatement.setInt(1, id_semain);

            preparedStatement.setInt(2, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
                String tplien = resultSet.getString(1);
                String tpName = resultSet.getString(2);

                tps.put(tplien, tpName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tps;
    }

    //
    public HashMap<Integer, HashMap<String, String>> getTPs(List<Integer> id_semains,String module) {
        //
        HashMap<Integer, HashMap<String, String>> tps = new HashMap<>();
        HashMap<String, String> tp;

        //
        for (Integer id_semain : id_semains) {
            //
            tp = this.getTP(id_semain,module);
            tps.put(id_semain, tp);

        }

        return tps;
    }


///////////////
    
public HashMap<String, String> getTP2(int id_semain , String module) {
//
HashMap<String, String> tps = new HashMap<>();
int id = getmodule_id(module);
try {
  preparedStatement = connection.prepareStatement(" select id_tp,tp_lien from module_tp where teaching_semain = ? and modules =?");

  preparedStatement.setInt(1, id_semain);
  preparedStatement.setInt(2, id);
  ResultSet resultSet = preparedStatement.executeQuery();

  while (resultSet.next()) {
      //
      String id_tp = resultSet.getString(1);
      String tp_lien = resultSet.getString(2);

      tps.put(id_tp, tp_lien);
System.out.println(tps);
  }
} catch (SQLException e) {
  e.printStackTrace();
}

return tps;
}

public HashMap<Integer, HashMap<String, String>> getTPs_2(List<Integer> id_semains,String module) {
//
HashMap<Integer, HashMap<String, String>> tps = new HashMap<>();
HashMap<String, String> tp;

//
for (Integer id_semain : id_semains) {
  //
  tp = this.getTP2(id_semain,module);
tps.put(id_semain, tp);

}

return tps;
}
//
//////////////////////
//
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //
public boolean updateCour_pdf( int id_cour, InputStream pdf) {
    //

boolean k = false ;

    //
    
        
            //
            try {
                preparedStatement = connection.prepareStatement("update module_cour set cour_pdf=? where id_cour=?");

      preparedStatement.setBlob(1, pdf);
                preparedStatement.setInt(2, id_cour);
               
                preparedStatement.executeUpdate();
                k=true;
            } catch (SQLException e) {
                e.printStackTrace();
                k = false ;
            }
        return k ;
    }


    public boolean updateCour( int id, String new_lien, String new_Name, InputStream pdf) {
        //

    boolean k = false ;

        //
       

                //
                try {
                    preparedStatement = connection.prepareStatement("update module_cour set cour_name=? ,cour_lien=? ,cour_pdf=? where id_cour=?");

                    preparedStatement.setString(1, new_Name);
                    preparedStatement.setString(2, new_lien);
                    preparedStatement.setBlob(3, pdf);
                    preparedStatement.setInt(4, id);
                    preparedStatement.executeUpdate();
                 return   k=true;
                } catch (SQLException e) {
                    e.printStackTrace();
                 return   k = false ;
                }
    

    }
    //

    public boolean updateTD( int id, String new_lien, String new_Name, InputStream pdf) {
        //

    boolean k = false ;

        //
       

                //
                try {
                	  preparedStatement = connection.prepareStatement("update module_td set td_name=? ,td_lien=? , td_pdf=? where id_td=?");

                    preparedStatement.setString(1, new_Name);
                    preparedStatement.setString(2, new_lien);
                    preparedStatement.setBlob(3, pdf);
                    preparedStatement.setInt(4, id);
                    preparedStatement.executeUpdate();
                 return   k=true;
                } catch (SQLException e) {
                    e.printStackTrace();
                 return   k = false ;
                }
    

    }
    //
    //

    public boolean updateTP( int id, String new_lien, String new_Name, InputStream pdf) {
        //

    boolean k = false ;

        //
       

                //
                try {
                	  preparedStatement = connection.prepareStatement("update module_tp set tp_name=? ,tp_lien=? , tp_pdf=? where id_tp=?");

                    preparedStatement.setString(1, new_Name);
                    preparedStatement.setString(2, new_lien);
                    preparedStatement.setBlob(3, pdf);
                    preparedStatement.setInt(4, id);
                    preparedStatement.executeUpdate();
                 return   k=true;
                } catch (SQLException e) {
                    e.printStackTrace();
                 return   k = false ;
                }
    

    }
    //
    public boolean updateCour2( int id, String new_lien, String new_Name) {
        //

    boolean k = false ;

        //
     
                //
                try {
                    preparedStatement = connection.prepareStatement("update module_cour set cour_name=? ,cour_lien=? where id_cour=?");

                    preparedStatement.setString(1, new_Name);
                    preparedStatement.setString(2, new_lien);
                 
                    preparedStatement.setInt(3, id);
                    preparedStatement.executeUpdate();
                    k=true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    k = false ;
                }
      

        return k ;

    }

    //
    public boolean updateTD2( int id  , String new_lien, String new_Name) {
        //

    
boolean k = false ; 

        //
      
        	
            //
           
                //
                try {
                    preparedStatement = connection.prepareStatement("update module_td set td_name=? ,td_lien=? where id_td=?");

                    preparedStatement.setString(1, new_Name);
                    preparedStatement.setString(2, new_lien);
                    preparedStatement.setInt(3, id);
                    preparedStatement.executeUpdate();
                    k=true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    k = false ;
                }
            


        return k;

    }

    //
    public boolean updateTP2( int id, String new_lien, String new_Name) {
        //

    
boolean k = false ; 
 
        //

                //
                try {
                    preparedStatement = connection.prepareStatement("update module_tp set tp_name=? ,tp_lien=? where id_tp=?");

                    preparedStatement.setString(1, new_Name);
                    preparedStatement.setString(2, new_lien);
                    preparedStatement.setInt(3, id);
                    preparedStatement.executeUpdate();
                    k=true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    k = false ;
                }
            


        return k;

    }

    //
    public boolean deleteCour(int id_semain, String lien) {
        //
        if (id_semain == 0) {
            return false;
        }

        //
        if (verifie_cour(lien)) {
            //
            try {
                preparedStatement = connection.prepareStatement("delete from module_cour where cour_lien=?");

                preparedStatement.setString(1, lien);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            return false;
        }
        //
        return true;
    }

    //
    public boolean deleteTD(int id_semain, String lien) {
        //
        if (id_semain == 0) {
            return false;
        }

        //
        if (verifie_TD(lien)) {
            //
            try {
                preparedStatement = connection.prepareStatement("delete from module_td where td_lien=?");

                preparedStatement.setString(1, lien);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            return false;
        }
        //
        return true;
    }

    //
    public boolean deleteTP(int id_semain, String lien) {
        //
        if (id_semain == 0) {
            return false;
        }

        //
        if (verifie_TP(lien)) {
            //
            try {
                preparedStatement = connection.prepareStatement("delete from module_tp where tp_lien=?");

                preparedStatement.setString(1, lien);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            return false;
        }
        //
        return true;
    }

    //
    public String editFNameProfile(String email, String newFirstName) {
        //
        newFirstName = newFirstName.trim();

        //
        if (!newFirstName.isBlank()) {
            //
            try {
                preparedStatement = connection.prepareStatement(" update users set user_firstname=? where user_email=?");

                preparedStatement.setString(1, newFirstName);
                preparedStatement.setString(2, email);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return this.getFName(email);

    }
        public String editLNameProfile(String email, String newLastName) {
            //
            newLastName = newLastName.trim();

            //
            if (!newLastName.isBlank()) {
                //
                try {
                    preparedStatement = connection.prepareStatement(" update users set user_lastname=? where user_email=?");

                    preparedStatement.setString(1, newLastName);
                    preparedStatement.setString(2, email);

                    preparedStatement.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            return this.getLName(email);

            }
            
 //////
            public String editPasswordProfile(String email, String newPassword) {
                //
            	newPassword = newPassword.trim();

                //
                if (!newPassword.isBlank()) {
                    //
                    try {
                        preparedStatement = connection.prepareStatement(" update users set user_password=? where user_email=?");

                        preparedStatement.setString(1, newPassword);
                        preparedStatement.setString(2, email);

                        preparedStatement.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }

        //
        return this.getPassword(email);


    }


    //
    public String getFName(String email) {
        //
        String fname = "";
        try {
            preparedStatement = connection.prepareStatement("select user_firstname from users where user_email=?");

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //
            fname = resultSet.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fname;
    }
    public String getLName(String email) {
        //
        String lname = "";
        try {
            preparedStatement = connection.prepareStatement("select user_lastname from users where user_email=?");

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //
            lname = resultSet.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lname;
    }
    public String getPassword(String email) {
        //
        String password = "";
        try {
            preparedStatement = connection.prepareStatement("select user_password from users where user_email=?");

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //
            password = resultSet.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password;
    }


    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////:::::
    
    
    

    
    
    
    
    
    
    
    
    //
    public ArrayList<Integer> getmodule_specialite(String specialte ) {
        //
    	ArrayList<Integer> moduleCodes = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select modules.name,modules.id_module from specialte,modules  where id_specialte=specialte and specialte.name =?");
            
            preparedStatement.setString(1, specialte);
ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //
            	String 	name = resultSet.getString(1);
            	int module =resultSet.getInt(2);
            
            System.out.println(name +"  "+ module);
            	moduleCodes.add(module);
            }
            //
           


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return moduleCodes;
    }
//
    public int getspecialite_id(String specialite) {
        //
        int id = 0;
        String specialite1 = specialite.toUpperCase();
        try {
            preparedStatement = connection.prepareStatement("select id_specialte from specialte where name=?");

            preparedStatement.setString(1, specialite1);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //
            id = resultSet.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    //
    public String etudiant_specialite(String email  ) {
        //
     String specialite="" ; 
    int id = DaoUser.getid(email);
        //
        try {

            preparedStatement = connection.prepareStatement("select specialte.name from etudiant_specialtes , specialte where specialte.id_specialte=etudiant_specialtes.specialte and user_id =? ");
            preparedStatement.setInt(1, id);
          
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //
            specialite = resultSet.getString(1);
System.out.println(specialite);
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return specialite ;
    }
    public boolean insert_etu_spec(String email , String specialite ) {
        //
      int id_specialte = getspecialite_id(specialite);
      int id = DaoUser.getid(email);
     if(id_specialte>0) {
        //
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`etudiant_specialtes` (`user_id`, `specialte`) VALUES (?, ?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id_specialte);
          
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}else {
        	return false;
        }
    }

    //
    //
    public int getonrmodule_specialite(String module,String specialite) {
        //
        int id = 0;
        
        String module1 = module.toUpperCase();
        int id_specialite = getspecialite_id(specialite);
        try {
            preparedStatement = connection.prepareStatement("select id_module from modules  where  name=? and specialte=? ");

            preparedStatement.setString(1, module1);
            preparedStatement.setInt(2, id_specialite);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //
            id = resultSet.getInt("id_module");
            System.out.println(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    //
    public int getmodule_id(String module) {
        //
        int id = 0;
        
        String module1 = module.toUpperCase();
        try {
            preparedStatement = connection.prepareStatement("select id_module from modules where name=?");

            preparedStatement.setString(1, module1);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //
            id = resultSet.getInt(1);
            System.out.println(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
    //
    
    public boolean insert_tech_mod(int email , int module  ) {
        //
     
     

        //
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`teacher_modules` (`user_id`, `modules`) VALUES (?, ?)");
            preparedStatement.setInt(1, email);
            preparedStatement.setInt(2, module);
          
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean insertmodule(String module , String specialite ) {
        //
    	 int id_specialte = getspecialite_id(specialite);
    	   int id = getmodule_id(module);
    	   String module1 = module.toUpperCase();
        //
    	   if(id==0) {
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO `elearning3`.`modules` (`name`, `specialte`) VALUES (?, ?)");
            preparedStatement.setString(1, module1);
            preparedStatement.setInt(2, id_specialte);
          
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }}else {
        	 try {
                 //
                 preparedStatement = connection.prepareStatement("  Update `elearning3`.`modules` Set modules.name=?Where id_module=? and specialte =?");

                 preparedStatement.setString(1, module1);
                 preparedStatement.setInt(	2, id);
                 preparedStatement.setInt(3, id_specialte);
          

                 preparedStatement.executeUpdate();
                 return true;

             } catch (SQLException e) {
                 e.printStackTrace();
                 return false;
             }
        }
    }
    
    

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    