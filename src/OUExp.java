   public class OUExp extends Expr{
      public PriExpSel a;
      public OUExp(PriExpSel e) {
         a=e;
      }
   
      public String toString(){
         String regreso=""; //\r\n OUExp ";
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
