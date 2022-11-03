   import java.util.*;
   public class TL {
   
      private Vector list;
      public TL() {
         list = new Vector();
      }
      public void addElement (Type n) {
         list.addElement(n);
      }
      public Type elementAt(int i) {
         return (Type)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
            regreso=regreso.concat(list.elementAt(i).toString());}
      
         return regreso;}
      

   
   }
