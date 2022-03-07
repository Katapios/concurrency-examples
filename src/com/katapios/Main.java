package com.katapios;

import java.util.concurrent.Exchanger;

class Main {
    public static void main(String[] args) {
//    char ch = 'A';
        Exchanger<String> exgr = new Exchanger<>();
        new UseString(exgr);
        new MakeString(exgr);

//      for (int j = 0; j < 26; j++) {
//        System.out.println(ch ++);
//      }

    }
}