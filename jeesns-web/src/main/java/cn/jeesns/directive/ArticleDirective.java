package cn.jeesns.directive;

import cn.jeesns.model.cms.Article;
import cn.jeesns.core.directive.BaseDirective;
import cn.jeesns.core.handler.DirectiveHandler;
import cn.jeesns.service.cms.ArticleService;
import freemarker.template.*;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by zchuanzhao on 2017/5/18.
 */
@Component
public class ArticleDirective extends BaseDirective {
    @Resource
    private ArticleService articleService;
    @Override
    public void execute(DirectiveHandler handler) throws TemplateException, IOException {
        int cid = handler.getInteger("cid",0);
        int num = handler.getInteger("num",0);
        String sort = handler.getString("sort","id");
        int day = handler.getInteger("day",0);
        int thumbnail = handler.getInteger("thumbnail",0);
        List<Article> list = articleService.listByCustom(cid,sort,num,day,thumbnail);
        handler.put("articleList", list).render();
    }

}
