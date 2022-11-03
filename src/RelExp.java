   public class RelExp extends Expr{
   
      public AddExp a,c;
      public RelOp b;
      public RelExp(AddExp e1, RelOp o, AddExp e2) {
         a=e1; b=o; c=e2;
      }
   
      public String toString(){
         String regreso=""; //String regreso="\r\n RelExp ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(" ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (c!=null) {regreso=regreso.concat(" ");}
         if (c!=null) {regreso=regreso.concat(c.toString());}
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
