
   public class ParIde extends TypNam{
      public Iden f0;
      public TL f1;
      public ParIde(Iden i, TL tl) {
         f0=i; f1=tl;
      }    
   
      public String toString(){
         String regreso="";
         if (f0!=null) {regreso=regreso.concat(f0.toString());}
         if (f1!=null) {regreso=regreso.concat("<");}
         if (f1!=null) {regreso=regreso.concat(f1.toString());}
         if (f1!=null) {regreso=regreso.concat(">");}
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
