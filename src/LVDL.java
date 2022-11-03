   import java.util.*;
   public class LVDL {
   
      private Vector list;
      public LVDL() {
         list = new Vector();
      }
      public void addElement (LVD n) {
         list.addElement(n);
      }
      public LVD elementAt(int i) {
         return (LVD)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
      public String toString(){
         String regreso="";
         //if (list.size()>0) regreso=regreso+"\r\n";
         for(int i=0;i<list.size();i++){
             regreso=regreso+"\r\n";
             regreso=regreso.concat(list.elementAt(i).toString());}
         return regreso;}
      

      
   
   }