   public class FunTyp extends TD{
   
      public Type a;
      public Iden b;
      public ForPar c;
      public FunTyp(Type t, Iden i, ForPar f) {
         a=t; b=i; c=f;
      }
   
      public String toString(){
         String regreso="\r\n    function ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         else {regreso=regreso.concat(" VOID ");}
         regreso=regreso.concat(" ");
         if (b!=null) {regreso=regreso.concat(b.toString());}
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
