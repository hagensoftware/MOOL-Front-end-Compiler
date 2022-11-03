   public class Pare extends PriExp{
   
      public Expr a;
      public Pare(Expr e) {
         a=e;
      }
   
      public String toString(){
         String regreso="(";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (a!=null) {regreso=regreso.concat(")");}
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
