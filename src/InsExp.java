   public class InsExp extends Expr{
   
      public Expr a;
      public Type b;
      public InsExp(Expr e, Type t) {
         a=e; b=t;
      }
      public String toString(){
         String regreso="\r\n InsExp ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(" instanceof ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
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
