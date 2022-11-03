   public class NegExp extends Expr{
   
      public RelExp a;
      public NegExp(RelExp n) {
         a=n;
      }
   
      public String toString(){
         String regreso=""; //String regreso="\r\n NegExp -";
         if (a!=null) {
             //regreso="-";
             regreso=regreso.concat(a.toString());
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
