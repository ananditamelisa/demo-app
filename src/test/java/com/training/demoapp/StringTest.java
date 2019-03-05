package com.training.demoapp;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StringTest {
    @Test
    public void testSpringContainer(){
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Foo f = container.getBean("foo",Foo.class);
        Foo f2 = container.getBean("foo",Foo.class);
        Assert.assertTrue("Foo harus sama", f==f2);

        Bar b = container.getBean(Bar.class);
        Bar b2 = container.getBean(Bar.class);
        Assert.assertTrue("Bar harus sama", b==b2);

        FooBar fb = container.getBean(FooBar.class);

        Assert.assertTrue("Foo harus sama", f==fb.getFoo());
        Assert.assertTrue("Bar harus sama2", f2 == fb.getFoo());

        Assert.assertTrue("Bar harus sama", b == fb.getBar());
        Assert.assertTrue("Bar harus sama2", b2 == fb.getBar());
        //container.close();
        

    }


    @Configuration
    public static class MyConfiguration{
        @Bean("foo")
        public Foo foo(){
            return new Foo();
        }

        @Bean("foo2")
        public Foo foo2(){
            return new Foo();
        }

        @Bean
        public Bar bar(){
            return new Bar();
        }
        @Bean
        public FooBar foobar(Foo foo, Bar bar){
            return new FooBar(foo, bar);
        }

    }

    @Configuration
    public static class MyConfigSircular{
        @Bean
        public Satu satu(Dua dua){
            return new Satu(dua);
        }
        @Bean
        public Dua dua (Tiga tiga){
            return new Dua(tiga);
        }
        @Bean
        public Tiga tiga (Satu satu){
            return new Tiga(satu);
        }
    }

    public static class Foo{

    }

    public static class Bar{

    }
    public static class FooBar{
        private Foo foo;
        private Bar bar;

        public FooBar(Foo foo, Bar bar) {
            this.foo = foo;
            this.bar = bar;
        }

        public Foo getFoo() {
            return foo;
        }

        public void setFoo(Foo foo) {
            this.foo = foo;
        }

        public Bar getBar() {
            return bar;
        }

        public void setBar(Bar bar) {
            this.bar = bar;
        }
    }
    public static class Satu {
        private Dua dua;

        public Satu(Dua dua) {
            this.dua = dua;
        }
    }
    public static class Dua {
        private Tiga tiga;

        public Dua(Tiga tiga) {
            this.tiga = tiga;
        }
    }
    public static class Tiga{
        private Satu satu;

        public Tiga(Satu satu) {
            this.satu = satu;
        }
    }
}
