   public class AndExp extends Expr{
   
      public NegExp a,b;
      public AndExp(NegExp e1, NegExp e2) {
         a=e1; b=e2;
      }
      public String toString(){
      
         String regreso=""; //String regreso="\r\n AndExp ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         
         if (b!=null) {
             regreso=regreso.concat(" && ");
             regreso=regreso.concat(b.toString());
         }
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
