//increment list
import java.util.*;
   
public class tableL {
   
      private Vector list;
      public tableL() {
         list = new Vector();
      }
      public void addElement (Clase i) {
         list.addElement(i);
      }
      public Clase elementAt(int i) {
         return (Clase)list.elementAt(i);
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