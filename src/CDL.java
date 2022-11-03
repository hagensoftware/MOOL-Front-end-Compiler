   import java.util.*;
   public class CDL {
   
      private Vector list;
      public CDL() {
         list = new Vector();
      }
      public void addElement (ConDec n) {
         list.addElement(n);
      }
      public ConDec elementAt(int i) {
         return (ConDec)list.elementAt(i);
      }
   
   
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="*************************************";
         for(int i=0;i<list.size();i++){
             regreso=regreso.concat("\r\n    ");
            regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}      

   
   }
