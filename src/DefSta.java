   public class DefSta {
   
      public Stat a;
      public DefSta(Stat s) {
         a=s;
      }
      public String toString(){
         String regreso="default: ";
         if (a!=null) {regreso=regreso.concat(a.toString());}
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
