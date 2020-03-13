package com.ml.sinon.pattern.template;

/**
 * @author liangzhong.tan
 * date 2020/3/12 18:10
 */
public class Cricket  extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}