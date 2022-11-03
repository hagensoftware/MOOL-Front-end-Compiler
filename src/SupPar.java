   public class SupPar extends SupSuf{
   
      public APL a;
      public SupPar(APL apl) {
         a=apl;
      }
   
      public String toString(){
         String regreso="\r\n SupPar ";
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
