   public class WhiSta extends Stat{
   
      public Expr a;
      public Stat b;
      public WhiSta(Expr e, Stat s) {
         a=e; b=s;
      }
   
      public String toString(){
         String regreso="while ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(b.toString());}
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
