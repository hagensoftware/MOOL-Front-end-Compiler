public class InterpreterVisitor implements StringVisitor{  
    
    /*
    System.out.print("class ");
    n.i1.accept(this);
    System.out.println(" {");
    System.out.print("  public static void main (String [] ");
    n.i2.accept(this);
    System.out.println(") {");
    System.out.print("    ");
    n.s.accept(this);
    System.out.println("  }");
    System.out.println("}");

     */
    
    //Basic Productions
    public String visit(AccMod n){
        return null;
    }
    
    public String visit(BooLit n){
        return null;
    } 
    
    public String visit(NulLit n){
        return null;
    }
    
    //public String visit(Numb n); **abstract
    
    public String visit(Inte n){
        return null;
    }
    
    public String visit(Doub n){
        return null;
    }
    
    public String visit(Iden n){
        return null;
    }
    
    //public String visit(Lite n); **abstract 
    
    public String visit(QuaIde n){
        return null;
    } 
    
    public String visit(ParIde n){
        return null;
    }
    
    //public String visit(TypNam n); abstract
    
    public String visit(Obje n){
        return null;
    }
    
    public String visit(BasTyp n){
        return null;
    }
    
    //public String visit(Type n); **abstract
    
    public String visit(TypeDim n){
        return null;
    }
    
    public String visit(TypVoi n){
        return null;
    }
    
    
    //Conpilation unit productions
    
    //public String visit(AST n); //**abstract raiz del árbol
    
    public String visit(Prog n){
        return null;
    }
    
    public String visit(ModInt n){
        return null;
    }
    
    public String visit(ModImp n){
        return null;
    }
    
    public String visit(ModBlo n){
        return null;
    }
    
    //public String visit(ModDec n); **abstract
    
    public String visit(ModInts n){
        return null;
    }
    
    public String visit(ImpDec n){
        return null;
    }
    
    public String visit(ModIni n){
        return null;
    }
    
    public String visit(ConDec n){
        return null;
    }
    
    public String visit(GFD n){
        return null;
    }
    
    //public String visit(TypDec n); **abstract    
    
    //public String visit(TD n); **abstract
    
    public String visit(TDCD n){
        return null;
    }
    
    public String visit(TDFT n){
        return null;
    }
    
    public String visit(TDID n){
        return null;
    }  
    
    public String visit(VarDec n){
        return null;
    }
    
    public String visit(ForPar n){
        return null;
    }
    
    public String visit(Para n){
        return null;
    }
    
    
    
    //Type Productions
    
    public String visit(ClaDec n){
        return null;
    }
    
    public String visit(IntDec n){
        return null;
    }
    
    public String visit(FunTyp n){
        return null;
    }
    
    public String visit(SupCla n){
        return null;
    }
    
    public String visit(Ints n){
        return null;
    }
    
    public String visit(ExtInt n){
        return null;
    }
    
    public String visit(CBD n){
        return null;
    }
    
    public String visit(IBD n){
        return null;
    }
    
    public String visit(ITP n){
        return null;
    }
    
    public String visit(TypPars n){
        return null;
    }
    
    public String visit(TypPar n){
        return null;
    }
    
    public String visit(TypVar n){
        return null;
    }
    
    public String visit(Boun n){
        return null;
    }
    
    public String visit(ClaVar n){
        return null;
    }
    
    public String visit(FieDec n){
        return null;
    }
    
    public String visit(CtrDec n){
        return null;
    }
    
    public String visit(MetDec n){
        return null;
    }
    
    public String visit(FMD n){
        return null;
    }
    
    public String visit(Bloc n){
        return null;
    }
    
    public String visit(LVD n){
        return null;
    }
    
    
    
    //Statement productions
    
    //public String visit(Stat n); **abstract
    
    public String visit(AsiSta n){
        return null;
    }
    
    public String visit(BreSta n){
        return null;
    }
    
    public String visit(ConSta n){
        return null;
    }
    
    public String visit(Else n){
        return null;
    }
    
    public String visit(ExpSta n){
        return null;
    }
    
    public String visit(ForSta n){
        return null;
    }
    
    public String visit(CalSta n){
        return null;
    }
    
    public String visit(IfSta n){
        return null;
    }
    
    public String visit(RetSta n){
        return null;
    }
    
    public String visit(SwiSta n){
        return null;
    }
    
    public String visit(WhiSta n){
        return null;
    }
    
    public String visit(Case n){
        return null;
    }
    
    public String visit(DefSta n){
        return null;
    }
    
    public String visit(Desi n){
        return null;
    }
    
    public String visit(ForIni n){
        return null;
    }
    
    public String visit(ForUpd n){
        return null;
    }
    
    public String visit(SwiBlo n){
        return null;
    }
    
    
    
    //Expression productions
    
    //public String visit(Expr n); **abstract    
    
    public String visit(ConExp n){
        return null;
    }
    
    public String visit(OrExp n){
        return null;
    }
    
    public String visit(AndExp n){
        return null;
    }
    
    public String visit(NegExp n){
        return null;
    }
    
    public String visit(RelExp n){
        return null;
    }
    
    public String visit(AddExp n){
        return null;
    }
    
    public String visit(MulExp n){
        return null;
    }
    
    public String visit(UnaExp n){
        return null;
    }
    
    public String visit(InsExp n){
        return null;
    }
    
    public String visit(OUExp n){
        return null;
    }
    
    public String visit(Inc n){
        return null;
    } 
    
    //public String visit(PriExp n); **abstract
    
    public String visit(Pare n){
        return null;
    }
    
    public String visit(PriExpSel n){
        return null;
    }
    
    public String visit(This n){
        return null;
    }
    
    public String visit(Supe n){
        return null;
    }   
    
    public String visit(New n){
        return null;
    }
    
    //public String visit(Sele n); **abstract
    
    public String visit(SeleAP n){
        return null;
    }
    
    public String visit(SeleDot n){
        return null;
    }
    
    public String visit(ArrAcc n){
        return null;
    }
    
    public String visit(CasExp n){
        return null;
    }   
    
    //public String visit(SupSuf n); **abstract
    
    public String visit(SupIden n){
        return null;
    }
    
    public String visit(SupPar n){
        return null;
    }
    
    public String visit(RelOp n){
        return null;
    }
    
}
