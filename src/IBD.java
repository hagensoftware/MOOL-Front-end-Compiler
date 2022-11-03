   public class IBD {
   
      public FMDL a;
      public IBD(FMDL fmdl) {
         a=fmdl;
      }
   
      public String toString(){
         String regreso=" {";
         if (a!=null) {
             regreso=regreso.concat(a.toString());
             regreso=regreso.concat("\r\n    }");}
         else regreso=regreso.concat(";");
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
