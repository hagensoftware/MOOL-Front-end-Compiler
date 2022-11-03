
   public class TypeDim extends Type{
      public Type a;
      public int b;
      public TypeDim(Type td, int i) {
         a=td; b=i;
      }
   
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         for (int j=0;j<b;j++){
            regreso=regreso+"[]";
         }
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
