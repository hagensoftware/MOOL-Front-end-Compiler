   public class SeleAP extends Sele{
   
      public APL a;
      public SeleAP(APL apl) {
         a=apl;
      }
      public String toString(){
         String regreso="(";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         regreso=regreso.concat(")");
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
