package model;

public class module {
	
	
	  private String name;
	  private String specialte;
	  
	  
	public module( String name, String specialte) {
		// TODO Auto-generated constructor stub
		   this.name = name;
	        this.specialte = specialte;
	}
	
	
	 public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSpecialte() {
			return specialte;
		}
		public void setSpecialte(String specialte) {
			this.specialte = specialte;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (o == null || getClass() != o.getClass()) return false;

		        module subject = (module) o;

		        if (!name.equals(subject.name)) return false;
		        return specialte.equals(subject.specialte);
		    }

		    @Override
		    public int hashCode() {
		        int result = name.hashCode();
		        result = 31 * result + specialte.hashCode();
		        return result;
		    }

}
