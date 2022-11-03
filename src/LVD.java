   public class LVD {
   
      public Type a;
      public Iden b;
      public Expr c;
      public LVD(Type t, Iden i, Expr e) {
         a=t; b=i; c=e;
      }
   
      public String toString(){
         String regreso="            "; //\r\n LVD ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(" ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (c!=null) {regreso=regreso.concat(" = ");}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         regreso=regreso.concat(";");
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
