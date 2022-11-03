
   public class Prog extends AST{
      //public Identation iscope;
       
      public ModInt a;
      public ModImp b;
      public Prog(ModInt n, ModImp m) {
         a=n; b=m;
      }
   
      public String toString() {
         //iscope=new Identation();
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
