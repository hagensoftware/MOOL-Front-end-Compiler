   public class Case {
   
      public CoL a;
      public Stat s;
      public Case(CoL col, Stat s) {
         a=col;
      }
   
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         //if (s!=null) {regreso=regreso.concat(s.toString());}
         return regreso;}
      
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
