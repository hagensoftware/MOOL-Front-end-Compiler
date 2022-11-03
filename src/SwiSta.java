
   public class SwiSta extends Stat{
   
      public Expr a;
      public SwiBlo b;
      public SwiSta(Expr e, SwiBlo s) {
         a=e; b=s;
      }
   
      public String toString(){
      
         String regreso="switch";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat("{");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (b!=null) {regreso=regreso.concat("}");}
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
