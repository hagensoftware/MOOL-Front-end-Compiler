
public class TypVoi extends Type{
   
      //private Expr a;
      public boolean a;
      public TypVoi(boolean t) {
         a=t;
      }
   
      public String toString(){
         String regreso="";
         if (a==true) {regreso=regreso.concat("void ");}
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
