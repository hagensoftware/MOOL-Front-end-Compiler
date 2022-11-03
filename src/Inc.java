public class Inc {
      public String a;
      public Inc(String i) {
         a=i; 
      }
   
      public String toString(){
         String regreso="++";
         if (a=="false") {regreso="--";}
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
