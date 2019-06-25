public class Singleton {
    // fixme 懒汉模式
    private Singleton instance;
    private Singleton(){};
    public Singleton getSingleton() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    // fixme 饿汉模式
    private static final Singleton instance = new Singleton();
    private Singleton(){};

    public static Singleton getInstance() {
        return instance;
    }

    // fixme 双重检验锁
    public static Singleton instance;
    private static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    // fixme 静态内部类
    //  这种写法仍然使用JVM本身机制保证了线程安全问题；
    //  由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，因此它是懒汉式的；
    //  同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK 版本
    private static class SingletonHolder{
          private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){};
    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    // fixme 枚举
    public enum EasySingleton{
        INSTANCE;
    }

}
