package com.example.retrofitdemo.MyFragment.recyclerview.bean;

import java.io.Serializable;
import java.util.List;

public class ArticleBean implements Serializable{


    /**
     * curPage : 2
     * datas : [{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":530,"chapterName":"11（R）","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14953,"link":"https://blog.csdn.net/shensky711/article/details/102677056","niceDate":"2020-08-24 23:46","niceShareDate":"2020-08-24 17:26","origin":"","prefix":"","projectLink":"","publishTime":1598283992000,"realSuperChapterId":452,"selfVisible":0,"shareDate":1598261187000,"shareUser":"残页","superChapterId":453,"superChapterName":"版本适配","tags":[],"title":"Android Q 深色模式（Dark Mode）源码解析","type":0,"userId":12467,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14944,"link":"https://juejin.im/post/6859718064632496135","niceDate":"2020-08-24 09:00","niceShareDate":"2020-08-24 09:00","origin":"","prefix":"","projectLink":"","publishTime":1598230846000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1598230846000,"shareUser":"秉心说","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 复习笔记 &mdash;&mdash; 任务栈和返回栈","type":0,"userId":40186,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14959,"link":"https://mp.weixin.qq.com/s/1j1lsciZFnmh5y_1_CUD8g","niceDate":"2020-08-24 00:00","niceShareDate":"2020-08-24 21:16","origin":"","prefix":"","projectLink":"","publishTime":1598198400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598274980000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"直面底层：探索 Android 中的 Window","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Android群英传","canEdit":false,"chapterId":413,"chapterName":"Android群英传","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14960,"link":"https://mp.weixin.qq.com/s/HVjPXgoJFXOqBSYlbbZk7w","niceDate":"2020-08-24 00:00","niceShareDate":"2020-08-24 21:16","origin":"","prefix":"","projectLink":"","publishTime":1598198400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598275000000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/413/1"}],"title":"FlutterDojo设计之道&mdash;状态管理之路（一）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":134,"chapterName":"SurfaceView","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14930,"link":"https://www.jianshu.com/p/5e5ae2f524ce","niceDate":"2020-08-23 23:46","niceShareDate":"2020-08-22 22:10","origin":"","prefix":"","projectLink":"","publishTime":1598197580000,"realSuperChapterId":37,"selfVisible":0,"shareDate":1598105426000,"shareUser":"深红骑士","superChapterId":93,"superChapterName":"自定义控件","tags":[],"title":"SurfaceView原理分析","type":0,"userId":29303,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":229,"chapterName":"AOP","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14938,"link":"https://www.jianshu.com/p/61cd84e28844","niceDate":"2020-08-23 23:45","niceShareDate":"2020-08-23 23:44","origin":"","prefix":"","projectLink":"","publishTime":1598197531000,"realSuperChapterId":225,"selfVisible":0,"shareDate":1598197447000,"shareUser":"鸿洋","superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"基于gradle transform的asm实践库AutoRegister源码分析","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":124,"chapterName":"Fragment","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14940,"link":"https://juejin.im/post/6863334752162676749","niceDate":"2020-08-23 23:45","niceShareDate":"2020-08-23 23:44","origin":"","prefix":"","projectLink":"","publishTime":1598197513000,"realSuperChapterId":25,"selfVisible":0,"shareDate":1598197475000,"shareUser":"鸿洋","superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"【译】Fragment 的重大重构 &mdash;&mdash; 介绍 Fragment 新的状态管理器","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14939,"link":"https://juejin.im/post/6862992866131017735","niceDate":"2020-08-23 23:45","niceShareDate":"2020-08-23 23:44","origin":"","prefix":"","projectLink":"","publishTime":1598197505000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1598197464000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle 构建学习（一）---------详解 Project","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14956,"link":"https://mp.weixin.qq.com/s/LwrR-CHXDNLyOJBUbdCB6w","niceDate":"2020-08-23 00:00","niceShareDate":"2020-08-24 21:15","origin":"","prefix":"","projectLink":"","publishTime":1598112000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598274925000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"在 Android 和 Hilt 中限定作用域","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14957,"link":"https://mp.weixin.qq.com/s/-x-uOAV6b1aS80Dbg_c8gQ","niceDate":"2020-08-23 00:00","niceShareDate":"2020-08-24 21:15","origin":"","prefix":"","projectLink":"","publishTime":1598112000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598274942000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"Android 11 开发者常见问题: 存储 | FAQ・第二期","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14958,"link":"https://mp.weixin.qq.com/s/XtV_V0DE8LjyB-7AwMyjBA","niceDate":"2020-08-23 00:00","niceShareDate":"2020-08-24 21:15","origin":"","prefix":"","projectLink":"","publishTime":1598112000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598274959000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"这个技能也很重要！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14929,"link":"https://juejin.im/post/6863756420380196877","niceDate":"2020-08-22 20:36","niceShareDate":"2020-08-22 20:36","origin":"","prefix":"","projectLink":"","publishTime":1598099804000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1598099804000,"shareUser":"飞洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"&ldquo;终于懂了&rdquo; 系列：Android屏幕刷新机制&mdash;VSync、Choreographer 全面理解！","type":0,"userId":31360,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14919,"link":"https://juejin.im/post/6863674785361035271","niceDate":"2020-08-22 13:57","niceShareDate":"2020-08-22 13:57","origin":"","prefix":"","projectLink":"","publishTime":1598075854000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1598075854000,"shareUser":"roger11","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"kotlin和java的匿名内部类的区别","type":0,"userId":65727,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14954,"link":"https://mp.weixin.qq.com/s/kZGM2vgSmxdyTKPqm1J3XA","niceDate":"2020-08-22 00:00","niceShareDate":"2020-08-24 21:14","origin":"","prefix":"","projectLink":"","publishTime":1598025600000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598274889000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"小技巧 | 在 Android Studio 调试应用 (上)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14955,"link":"https://mp.weixin.qq.com/s/veh_tImnEBVpMtjCrEvLoQ","niceDate":"2020-08-22 00:00","niceShareDate":"2020-08-24 21:15","origin":"","prefix":"","projectLink":"","publishTime":1598025600000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598274905000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"或许是迄今为止第一篇讲解 fps 计算原理的文章吧 | 开发者说&middot;DTalk","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14895,"link":"https://juejin.im/post/6863276629029126158","niceDate":"2020-08-21 15:24","niceShareDate":"2020-08-21 15:24","origin":"","prefix":"","projectLink":"","publishTime":1597994678000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1597994678000,"shareUser":"ClericYi","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"一起用Gradle Transform API + ASM完成代码织入呀～","type":0,"userId":43964,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14911,"link":"https://mp.weixin.qq.com/s/XJ83Yf5Q4S9sZ6MUzW8ohw","niceDate":"2020-08-21 00:00","niceShareDate":"2020-08-21 23:07","origin":"","prefix":"","projectLink":"","publishTime":1597939200000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598022436000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"更快！更高效！异步启动框架Alpha完全解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Android群英传","canEdit":false,"chapterId":413,"chapterName":"Android群英传","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14912,"link":"https://mp.weixin.qq.com/s/M4raxSm_8j0SqPdPwyAbGw","niceDate":"2020-08-21 00:00","niceShareDate":"2020-08-21 23:07","origin":"","prefix":"","projectLink":"","publishTime":1597939200000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598022459000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/413/1"}],"title":"抽丝剥茧Kotlin - 协程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14913,"link":"https://mp.weixin.qq.com/s/B2pHw9xuMRqH2c-eewQKWg","niceDate":"2020-08-21 00:00","niceShareDate":"2020-08-21 23:08","origin":"","prefix":"","projectLink":"","publishTime":1597939200000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1598022481000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"分析Retrofit与OkHttp的三个实战案例！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":182,"chapterName":"JNI编程","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":14879,"link":"https://juejin.im/post/6862732328406351879","niceDate":"2020-08-20 22:32","niceShareDate":"2020-08-20 22:27","origin":"","prefix":"","projectLink":"","publishTime":1597933979000,"realSuperChapterId":128,"selfVisible":0,"shareDate":1597933672000,"shareUser":"鸿洋","superChapterId":149,"superChapterName":"JNI","tags":[],"title":"Android敏感数据泄露引发的思考","type":0,"userId":2,"visible":1,"zan":0}]
     * offset : 20
     * over : false
     * pageCount : 456
     * size : 20
     * total : 9106
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean implements Serializable {
        /**
         * apkLink :
         * audit : 1
         * author :
         * canEdit : false
         * chapterId : 530
         * chapterName : 11（R）
         * collect : false
         * courseId : 13
         * desc :
         * descMd :
         * envelopePic :
         * fresh : false
         * id : 14953
         * link : https://blog.csdn.net/shensky711/article/details/102677056
         * niceDate : 2020-08-24 23:46
         * niceShareDate : 2020-08-24 17:26
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1598283992000
         * realSuperChapterId : 452
         * selfVisible : 0
         * shareDate : 1598261187000
         * shareUser : 残页
         * superChapterId : 453
         * superChapterName : 版本适配
         * tags : []
         * title : Android Q 深色模式（Dark Mode）源码解析
         * type : 0
         * userId : 12467
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private int audit;
        private String author;
        private boolean canEdit;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String descMd;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String niceShareDate;
        private String origin;
        private String prefix;
        private String projectLink;
        private long publishTime;
        private int realSuperChapterId;
        private int selfVisible;
        private long shareDate;
        private String shareUser;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<?> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public int getAudit() {
            return audit;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isCanEdit() {
            return canEdit;
        }

        public void setCanEdit(boolean canEdit) {
            this.canEdit = canEdit;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDescMd() {
            return descMd;
        }

        public void setDescMd(String descMd) {
            this.descMd = descMd;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getNiceShareDate() {
            return niceShareDate;
        }

        public void setNiceShareDate(String niceShareDate) {
            this.niceShareDate = niceShareDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getRealSuperChapterId() {
            return realSuperChapterId;
        }

        public void setRealSuperChapterId(int realSuperChapterId) {
            this.realSuperChapterId = realSuperChapterId;
        }

        public int getSelfVisible() {
            return selfVisible;
        }

        public void setSelfVisible(int selfVisible) {
            this.selfVisible = selfVisible;
        }

        public long getShareDate() {
            return shareDate;
        }

        public void setShareDate(long shareDate) {
            this.shareDate = shareDate;
        }

        public String getShareUser() {
            return shareUser;
        }

        public void setShareUser(String shareUser) {
            this.shareUser = shareUser;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }
    }
}
