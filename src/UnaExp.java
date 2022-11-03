   public class UnaExp extends Expr{
      public OUExp a;
      public UnaExp(OUExp e) {
         a=e;
      }
   
      public String toString(){
         String regreso=""; //String regreso="\r\n UnaExp ";
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
