   public class BreSta extends Stat{
   
      public BreSta() {
      
      }
   
      public String toString(){
         String regreso="";
         regreso=regreso.concat("break;");
         //regreso=regreso.concat(";");
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
