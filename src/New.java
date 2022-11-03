public abstract class New extends PriExp{
      public abstract String accept(StringVisitor v);
      public abstract Type accept(TypeVisitor v);
      public abstract void accept(Visitor v);     
}

