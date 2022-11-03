   public class CtrDec {
   
      public Iden a;
      public ForPar b;
      public Bloc c;
      public CtrDec(Iden i, ForPar f, Bloc bl) {
         a=i; b=f; c=bl;
      }
   
      public String toString(){
         String regreso="public ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(b.toString());}
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
