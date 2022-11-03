   public class Else {
   
      public SL a;
      public Else(SL sl) {
         a=sl;
      }
      public String toString(){
      
         String regreso="\r\n            else ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
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
