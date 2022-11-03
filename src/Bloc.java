   public class Bloc extends Stat{
      public LVDL a;
      public SL b;
      public Bloc(LVDL lvdl, SL sl) {
         a=lvdl;
         b=sl;
      }
   
      public String toString(){
         String regreso="{ ";
         //if (a!=null | b!=null) {regreso=regreso+"\r\n";}
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         regreso=regreso.concat("\r\n        }");
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
