package com.ml.sinon.pattern.template;

/**
 * @author liangzhong.tan
 * date 2020/3/12 18:21
 */
public class TemplatePatternDemo {

    public static void run(){
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
        game = new Onmyoji();
        game.play();
    }

}
