   public class TypPar {
   
    /** Creates a new instance of TypPar */
      public TypVar a;
      public Boun b;
      public TypPar(TypVar tv, Boun bo) {
         a=tv; b=bo;
      }
   
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         //if (b!=null) {regreso=regreso.concat(" ");}
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
