package com.practice.walmartTest;
final class ImmutableClass {
   private final int var1;
   private final int var2;
   
   public ImmutableClass(int var1, int var2) {
       this.var1 = var1;
       this.var2 = var2;
   }
   public int getVar1(){
       return this.var1;
   }

   public int getVar2(){
       return this.var2;
   }
}