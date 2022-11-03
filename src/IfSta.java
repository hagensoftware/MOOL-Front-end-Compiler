   public class IfSta extends Stat{
   
      public Expr a;
      public Stat b;
      public Else c;
      public IfSta(Expr e, Stat s, Else ec) {
         a=e; b=s; c=ec;
      }
   
      public String toString(){
         String regreso="if (";
         regreso=regreso.concat(a.toString());
         regreso=regreso.concat("){");
         regreso=regreso.concat(b.toString());
         regreso=regreso.concat("}");
         if (c!=null) {regreso=regreso.concat(c.toString());}
         //else regreso=regreso.concat(";");
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
