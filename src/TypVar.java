   public class TypVar {
   
      public Iden a;
      public TypVar(Iden i) {
         a=i;
      }
   
      public String toString(){
      
         String regreso="";
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
