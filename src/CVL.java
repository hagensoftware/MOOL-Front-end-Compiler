   import java.util.*;
   public class CVL {
   
      private Vector list;
      public CVL() {
         list = new Vector();
      }
      public void addElement (ClaVar n) {
         list.addElement(n);
      }
      public ClaVar elementAt(int i) {
         return (ClaVar)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat("\r\n        ");
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

   
   }