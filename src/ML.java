   import java.util.*;
   public class ML {
   
      private Vector list;
      public ML() {
         list = new Vector();
      }
      public void addElement (MetDec n) {
         list.addElement(n);
      }
      public MetDec elementAt(int i) {
         return (MetDec)list.elementAt(i);
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