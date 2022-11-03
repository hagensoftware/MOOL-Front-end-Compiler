   public class Desi {
   
      public Iden a;
      public Desi(Iden i) {
         a=i;
      }
   
      public String toString(){
      
         String regreso="\r\n Desi ";
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
