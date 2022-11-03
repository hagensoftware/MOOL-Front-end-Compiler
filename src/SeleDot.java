   public class SeleDot extends Sele{
   
      public Expr a;
      public SeleDot(Expr e) {
         a=e;
      }
   
      public String toString(){
         String regreso=".";
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
