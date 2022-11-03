   import java.util.*;
   public class PL {
   
      private Vector list;
      public PL() {
         list = new Vector();
      }
      public void addElement (Para n) {
         list.addElement(n);
      }
      public Para elementAt(int i) {
         return (Para)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso=" (";
         for(int i=0;i<list.size();i++){
             if (i>0) regreso=regreso.concat(",");
            regreso=regreso.concat(list.elementAt(i).toString());
         }
         regreso=regreso.concat(")");
         return regreso;}
      

   
   }