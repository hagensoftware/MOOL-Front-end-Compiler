   import java.util.*;
   public class IL {
   
      private Vector list;
      public IL() {
         list = new Vector();
      }
      public void addElement (Iden n) {
         list.addElement(n);
      }
      public Iden elementAt(int i) {
         return (Iden)list.elementAt(i);
      }
      public int size() {
         return list.size();
      }
   
      public String toString(){
         String regreso="";
         for(int i=0;i<list.size();i++){
             if (i>0) regreso=regreso+regreso.concat(",");
             regreso=regreso.concat(list.elementAt(i).toString());
            //regreso=regreso.concat(",");
         }
         return regreso;}
      

   }
