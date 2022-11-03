//increment list
import java.util.*;
   
public class IncL {
   
      private Vector list;
      public IncL() {
         list = new Vector();
      }
      public void addElement (Inc i) {
         list.addElement(i);
      }
      public Inc elementAt(int i) {
         return (Inc)list.elementAt(i);
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
