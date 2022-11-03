   import java.util.*;
   public class InL {
   
      private Vector list;
      public InL() {
         list = new Vector();
      }
      public void addElement (ITP n) {
         list.addElement(n);
      }
      public ITP elementAt(int i) {
         return (ITP)list.elementAt(i);
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