   public class VarDec extends ModDec{
   
      public Type a;
      public Iden b;
      public Expr c;
      public VarDec(Type t, Iden i, Expr e) {
         a=t; b=i; c=e;
      }
   
      public String toString(){
         String regreso="\r\n VarDec ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso.concat(" ");}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (c!=null) {regreso.concat(" = ");}
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
