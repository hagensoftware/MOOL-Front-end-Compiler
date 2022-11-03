   public class MetDec {
      //final int NULL=0, OVERRIDE=1, SHADOW=2;
      public String a;
      public FMD b;
      public MetDec(String over, FMD fmd) {
         a=over; b=fmd;
      }
      public String toString(){
         String regreso="";
         if (a!=null) {regreso=regreso.concat(b.toString());}
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
