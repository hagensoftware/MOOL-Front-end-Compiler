   public class MulExp extends Expr{
   
      public UnaExp a,b;
      public MulExp(UnaExp e1, UnaExp e2) {
         a=e1; b=e2;
      }
   
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         
         if (b!=null) {
             regreso=regreso.concat(" * ");
             regreso=regreso.concat(b.toString());}
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
