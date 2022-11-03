   public class ForSta extends Stat{
      public ForIni a;
      public Expr b;
      public ForUpd c;
      public Stat d;
      public ForSta(ForIni i, Expr e, ForUpd u, Stat s) {
          a=i; b=e; c=u; d=s;
      }
      public String toString(){
         
         String regreso="for (";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (a!=null) {regreso=regreso.concat(";");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (b!=null) {regreso=regreso.concat(";");}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         if (d!=null) {regreso=regreso.concat(") ");}
         if (d!=null) {regreso=regreso.concat(d.toString());}
         else regreso=regreso.concat(";");
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
