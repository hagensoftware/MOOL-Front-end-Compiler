   import java.util.*;
   public class FMDL {
   
      private Vector list;
      public FMDL() {
         list = new Vector();
      }
      public void addElement (FMD n) {
         list.addElement(n);
      }
      public FMD elementAt(int i) {
         return (FMD)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat("\r\n        ");
            regreso=regreso.concat(list.elementAt(i).toString());
            regreso=regreso.concat(";");
         }
         return regreso;}
      
      //public String accept(Visitor v){
      //    return v.visit(this);
      //}
   
   
   }