   public class ArrAcc extends Sele{
   
      public EL a;
      public ArrAcc(EL el) {
         a=el;
      }
      public String toString(){
         String regreso="[";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         regreso=regreso.concat("]");
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
