
public class RelOp {
    public String a;
    public RelOp(String o) {
        a=o;
    }
    public String toString(){
   	return a;}	
    
      public String accept(StringVisitor v){
          return v.visit(this);
      }

      public Type accept(TypeVisitor v){
          return v.visit(this);
      }      
   
      public void accept(Visitor v){
          v.visit(this);
      }      
   
}
