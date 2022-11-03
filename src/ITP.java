   public class ITP {
   
      public Iden a;
      public TypPars b;
      public ITP(Iden i, TypPars t) {
         a=i; b=t;
      }
   
      public String toString(){
         String regreso="";
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
