   public class CBD {
   
      public CVL a;
      public FL b;
      public CtrL c;
      public ML d;
      public CBD(CVL cvl, FL fl, CtrL ctrl, ML ml) {
         a=cvl; b=fl; c=ctrl; d=ml;
      }
   
      public String toString(){
         String regreso=" {";
         if (a!=null) {regreso=regreso.concat(a.toString());}
         if (b!=null) {regreso=regreso.concat(b.toString());}
         if (c!=null) {regreso=regreso.concat(c.toString());}
         if (d!=null) {regreso=regreso.concat(d.toString());}
         regreso=regreso.concat("\r\n    }");
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
