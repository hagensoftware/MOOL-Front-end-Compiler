public interface TypeVisitor{  
    //Basic Productions
    public Type visit(AccMod n);
    public Type visit(BooLit n); 
    public Type visit(NulLit n);
    //public Type visit(Numb n); **abstract
    public Type visit(Inte n);
    public Type visit(Doub n);
    public Type visit(Iden n);
    //public Type visit(Lite n); **abstract 
    public Type visit(QuaIde n);
    public Type visit(ParIde n);
    //public Type visit(TypNam n); abstract
    public Type visit(Obje n);
    public Type visit(BasTyp n);
    //public Type visit(Type n); **abstract
    public Type visit(TypeDim n);
    public Type visit(TypVoi n);
    
    //Conpilation unit productions
    //public Type visit(AST n); //**abstract raiz del árbol

    public Type visit(Prog n);
    public Type visit(ModInt n);
    public Type visit(ModImp n);
    public Type visit(ModBlo n);
    //public Type visit(ModDec n); **abstract
    public Type visit(ModInts n);
    public Type visit(ImpDec n);
    public Type visit(ModIni n);
    public Type visit(ConDec n);
    public Type visit(GFD n);
    //public Type visit(TypDec n); **abstract    
    //public Type visit(TD n); **abstract
    public Type visit(TDCD n);
    public Type visit(TDFT n);
    public Type visit(TDID n);  
    public Type visit(VarDec n);
    public Type visit(ForPar n);
    public Type visit(Para n);
    
    //Type Productions
    public Type visit(ClaDec n);
    public Type visit(IntDec n);
    public Type visit(FunTyp n);
    public Type visit(SupCla n);
    public Type visit(Ints n);
    public Type visit(ExtInt n);
    public Type visit(CBD n);
    public Type visit(IBD n);
    public Type visit(ITP n);
    public Type visit(TypPars n);
    public Type visit(TypPar n);
    public Type visit(TypVar n);
    public Type visit(Boun n);
    public Type visit(ClaVar n);
    public Type visit(FieDec n);
    public Type visit(CtrDec n);
    public Type visit(MetDec n);
    public Type visit(FMD n);
    public Type visit(Bloc n);
    public Type visit(LVD n);
   
    //Statement productions
    //public Type visit(Stat n); **abstract
    public Type visit(AsiSta n);
    public Type visit(BreSta n);
    public Type visit(ConSta n);
    public Type visit(Else n);
    public Type visit(ExpSta n);
    public Type visit(ForSta n);
    public Type visit(CalSta n);
    public Type visit(IfSta n);
    public Type visit(RetSta n);
    public Type visit(SwiSta n);
    public Type visit(WhiSta n);
    public Type visit(Case n);
    public Type visit(DefSta n);
    public Type visit(Desi n);
    public Type visit(ForIni n);
    public Type visit(ForUpd n);
    public Type visit(SwiBlo n);
    
    
    //Expression productions
    
    //public Type visit(Expr n); **abstract    
    
    public Type visit(ConExp n);
    public Type visit(OrExp n);
    public Type visit(AndExp n);
    public Type visit(NegExp n);
    public Type visit(RelExp n);
    public Type visit(AddExp n);
    public Type visit(MulExp n);
    public Type visit(UnaExp n);
    public Type visit(InsExp n);
    public Type visit(OUExp n);
    public Type visit(Inc n); 
    //public Type visit(PriExp n); **abstract
    public Type visit(Pare n);
    public Type visit(PriExpSel n);
    public Type visit(This n);
    public Type visit(Supe n);
    //public Type visit(New n); **abstract
    public Type visit(NewExp n);
    public Type visit(NewTyp n);
    //public Type visit(Sele n); **abstract
    public Type visit(SeleAP n);
    public Type visit(SeleDot n);
    public Type visit(ArrAcc n);
    public Type visit(CasExp n);   

    //public Type visit(SupSuf n); **abstract
    public Type visit(SupIden n);
    public Type visit(SupPar n);
    public Type visit(RelOp n);
}
