
public class Identation {
    
    public int iscope;
    public Identation() {
        iscope=0;
    }
    
    public void beginScope(){
        iscope++;
        //return i;
    }
    
    public void endScope(){
        iscope--;
        //return i;
    }
    
    String getScope(){
          //String s=iscope;
          String totIde="";
          for(int i=0;i>iscope;i++){
             String Ide="    ";
             totIde=totIde + Ide;
          }
          return totIde;
     }
}
