public abstract class Stat {
      public abstract String accept(StringVisitor v);
      public abstract Type accept(TypeVisitor v);
      public abstract void accept(Visitor v);    
}
