   public class SwiBlo {
   
      public Case a;
      public DefSta b;
      public SwiBlo(Case c, DefSta d) {
         c=a; d=b;
      }
   
      public String toString(){
      
         String regreso="\r\n SwiBlo ";
         if (a!=null) {regreso=regreso.concat("case ");}
         if (a!=null) {regreso=regreso.concat(a.toString());}
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
