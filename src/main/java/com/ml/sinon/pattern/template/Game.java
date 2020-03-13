package com.ml.sinon.pattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liangzhong.tan
 * date 2020/3/12 18:08
 */
@Slf4j
public class Game {

    void initialize() {
        log.info("{} 启动", getGameName());
    }

    void startPlay() {
        log.info("开始游戏");
    }

    void endPlay() {
        log.info("{} 结束", getGameName());
    }

    String getGameName() {
        return "游戏";
    }

    //模板
    public final void play() {

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();

        log.info("-------------------");
    }
}
