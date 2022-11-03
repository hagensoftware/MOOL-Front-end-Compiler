   public class AddExp extends Expr {
   
      public MulExp a,b;
      public AddExp(MulExp e1, MulExp e2) {
         a=e1; b=e2;
      }
      public String toString(){
         String regreso=""; //String regreso="\r\n AddExp ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         
         if (b!=null) {
             regreso=regreso.concat(" + ");
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
