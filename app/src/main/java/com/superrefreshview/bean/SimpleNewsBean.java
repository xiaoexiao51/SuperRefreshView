package com.superrefreshview.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MMM on 2017/5/10.
 */

public class SimpleNewsBean implements Serializable {

    private PageBean page;
    private List<ContentBean> content;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class PageBean implements Serializable {
        /**
         * currentPage : 1
         * totalPage : 4
         * pageLimit : 8
         */

        private int currentPage;
        private int totalPage;
        private int pageLimit;

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageLimit() {
            return pageLimit;
        }

        public void setPageLimit(int pageLimit) {
            this.pageLimit = pageLimit;
        }
    }

    public static class ContentBean implements Serializable {
        /**
         * contentId : 107
         * contentTitle : 电视新闻电视新闻电视新闻电视新闻电视新闻电视新闻电视新闻电视新闻电视新闻电视新闻
         * contentTitleSub :
         * titleImg : publish/image/c3bc07ee-615f-4a45-b120-3133945640f9.png
         * createTime : 2017-05-19 09:33:23
         * publishTime : 2017-05-19 09:34:19
         * forwardUrl : publish/118/2017-05-19/107.html
         * mediaUrl :
         * hotImg :
         */

        private int contentId;
        private String contentTitle;
        private String contentTitleSub;
        private int titleImg;
        private String createTime;
        private String publishTime;
        private String forwardUrl;
        private String mediaUrl;
        private String hotImg;

        public ContentBean(int titleImg, String contentTitle, String publishTime) {
            this.titleImg = titleImg;
            this.publishTime = publishTime;
            this.contentTitle = contentTitle;
        }

        public String getHotImg() {
            return hotImg;
        }

        public void setHotImg(String hotImg) {
            this.hotImg = hotImg;
        }

        public int getContentId() {
            return contentId;
        }

        public void setContentId(int contentId) {
            this.contentId = contentId;
        }

        public String getContentTitle() {
            return contentTitle;
        }

        public void setContentTitle(String contentTitle) {
            this.contentTitle = contentTitle;
        }

        public String getContentTitleSub() {
            return contentTitleSub;
        }

        public void setContentTitleSub(String contentTitleSub) {
            this.contentTitleSub = contentTitleSub;
        }

        public int getTitleImg() {
            return titleImg;
        }

        public void setTitleImg(int titleImg) {
            this.titleImg = titleImg;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getForwardUrl() {
            return forwardUrl;
        }

        public void setForwardUrl(String forwardUrl) {
            this.forwardUrl = forwardUrl;
        }

        public String getMediaUrl() {
            return mediaUrl;
        }

        public void setMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
        }
    }
}
