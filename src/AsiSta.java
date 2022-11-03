   public class AsiSta extends Stat{
   
      public Expr a,b;
      public AsiSta(Expr e1, Expr e2) {
         a=e1; b=e2;
      }
   
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(" = ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         regreso=regreso.concat(";");
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
