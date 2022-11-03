   public class RetSta extends Stat{
   
      public Expr a;
      public RetSta(Expr e) {
         a=e;
      }
   
      public String toString(){
         String regreso="return ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
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
