   import java.util.*;
   public class CtrL {
   
      private Vector list;
      public CtrL() {
         list = new Vector();
      }
      public void addElement (CtrDec n) {
         list.addElement(n);
      }
      public CtrDec elementAt(int i) {
         return (CtrDec)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
             regreso=regreso.concat("\r\n        ");
            regreso=regreso.concat(list.elementAt(i).toString());
            //regreso=regreso.concat(";");
         }
         return regreso;}
      

   
   }