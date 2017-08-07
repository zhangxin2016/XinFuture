package com.ratpack.xin.renders;

import com.ratpack.xin.tools.JsonTool;
import com.ratpack.xin.vo.ResultVo;
import ratpack.handling.Context;
import ratpack.render.RendererSupport;

/**
 * Created by zhangx on 2017/8/7.
 */
public class ResultRender extends RendererSupport<ResultVo<?>>{

    @Override
    public void render(Context ctx, ResultVo<?> resultVo) throws Exception {
        ctx.render(JsonTool.objectToStr(resultVo));
    }
}
