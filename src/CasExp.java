   public class CasExp extends Expr{
      //public Expr a;
    public Type a;
      public UnaExp b;
      public CasExp(Type t, UnaExp u) {
         a=t; b=u;
      }
      public String toString(){
         String regreso="\r\n CasExp (";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         regreso.concat(") ");
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
