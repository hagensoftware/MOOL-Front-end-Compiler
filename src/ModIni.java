   public class ModIni {
   
      public Bloc a;
      public ModIni(Bloc b) {
         a=b;
      }
   
      public String toString(){
         String regreso="\r\n ModIni ";
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
