   import java.util.*;
   public class MDL {
   
      private Vector list;
      public MDL() {
         list = new Vector();
      }
      public void addElement (ModDec n) {
         list.addElement(n);
      }
      public ModDec elementAt(int i) {
         return (ModDec)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());
            //regreso=regreso.concat("\r\n");
         }
         return regreso;}
      

   
   }
