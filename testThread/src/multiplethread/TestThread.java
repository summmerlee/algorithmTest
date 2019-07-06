package multiplethread;

import charactor.Hero;

public class TestThread {
    public static void main(String[] args){
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

//        KillThread kill1 = new KillThread(gareen,teemo);
//        kill1.start();
//        KillThread kill2 = new KillThread(bh,leesin);
//        kill2.start();

//        Battle battle1 = new Battle(gareen,teemo);
//        new Thread(battle1).start();
//        Battle battle2 = new Battle(bh,leesin);
//        new Thread(battle1).start();

        Thread thread1 = new Thread(){
            public void run(){
                while(!teemo.isDead())
                    gareen.attackHero(teemo);
            }
        };
//
//        Thread thread2 = new Thread(){
//            public void run(){
//                while(!leesin.isDead()) {
//                    Thread.yield();
//                    bh.attackHero(leesin);
//                }
//            }
//        };

        thread1.setDaemon(true);
        thread1.start();

    }
}
