   public class Iden extends PriExp{
      public String s;
      public Iden(String i) {
         s=i;}
   		
   	public String toString(){
            String jstr="string";
            if (s.equals(jstr)) 
                s="String";
            return s;}
        
      public String accept(StringVisitor v){
          return v.visit(this);
      }

      public Type accept(TypeVisitor v){
          return v.visit(this);
      }      
   
      public void accept(Visitor v){
          v.visit(this);
      }  
   
   }
