   public class ConDec extends ModDec{
      public Type a;
      public Iden b;
      public ConExp c;
      public ConDec(Type t, Iden i, ConExp e) {
         a=t; b=i; c=e;
      }
   
      public String toString(){
         String regreso="\r\n    final ";
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
