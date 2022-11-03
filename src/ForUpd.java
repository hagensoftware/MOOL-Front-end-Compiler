   public class ForUpd {
   
      public Iden a;
      public Expr b;
      public ForUpd(Iden i, Expr e) {
         a=i; b=e;
      }
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(" = ");}
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
