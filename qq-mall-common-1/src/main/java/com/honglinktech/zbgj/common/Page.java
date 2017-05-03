/**
 * Copyright &copy; Honglink All rights reserved.
 */
package com.honglinktech.zbgj.common;

import java.util.List;

/**
 * 分页类
 *
 * @param <T>
 * @author Dayong
 * @version 2016-1-3
 */
public class Page<T> {
    /**
     * 默认分页页数的范围 10页
     */
    int pageRate = 9;
    /**
     * 分页大小
     */
    private int size;
    /**
     * 当前页数
     */
    private int index;
    /**
     * 开始行数
     */
    private long start;
    /**
     * 结束行数
     */
    private long end;
    /**
     * 总记录行数
     */
    private long total;
    /**
     * 是否有下一页
     */
    private boolean hasNext;
    /**
     * 是否有上一页
     */
    private boolean hasPrev;
    /**
     * 返回的数据
     */
    private List<T> list;
    /**
     * 分页的路径
     */
    private String url;

    public Page() {
    }

    public Page(int total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    /**
     * Page<User> page = new Page<User>(3, 20, 2000, "product/list.html", list);
     *
     * @param start 开始的记录数
     * @param size  分页的大小
     * @param total 总数据的大小
     * @param list  返回的数据
     */
    public Page(long start, int size, long total, String pageUrl, List<T> list) {
        start++;
        //用总记录数除以分页大小得到全部的页数
        float totalPage = (float) total / (float) size;
        //如果开始记录小于总记录
        if (start < total) {
            this.start = start;
        } else {
            //开始记录大于总记录的情况
            this.start = (long) totalPage * size + 1;
        }
        //总页数小于1页的情况
        if (totalPage <= 1f) {
            //当前页只能是第一页
            this.index = 1;
        } else {
            //根据开始记录和分页大小来计算当前页
            this.index = (int) this.start / size + 1;
        }
        //this.start = (this.index - 1) * size + 1;
        this.end = this.start + size - 1;
        if (total == 0) {
            start = 0;
        }
        if (total < end) {
            this.end = total;
        }
        if (this.index > 1) {
            this.hasPrev = true;
        }
        if (totalPage - this.index > 0) {
            this.hasNext = true;
        }
        this.size = size;
        this.total = total;
        this.url = pageUrl;
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * 默认输出当前分页标签 <div>${page}</div>
     */
    @Override
    public String toString() {
        // 总页数
        long totalPage = total / size;
        if (total % size > 0) {
            totalPage++;
        }
        //开始页数
        int startPage = 1;
        //结束页数
        long endPage = startPage + pageRate;

        if (index > endPage) {
            int temp = index - pageRate / 2;
            if (temp > 0) {
                startPage = temp;
            }
            endPage = startPage + pageRate;
        }
        if (totalPage < endPage) {
            // 设置结束页数等于总页数
            endPage = totalPage;
        }

        //上一页页数
        int prevPage = index - 1;
        //下一页页数
        int nextPage = index + 1;

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("<div class=\"col-sm-4 pagination \" style=\"padding-left: 15px;\">总共%d条,显示第%d到%d条</div>\n", total, start, end));
        sb.append("<div class=\"col-sm-6\">\n");
        sb.append("<ul class=\"pagination\">\n");
        if (hasPrev) {
            sb.append("<li class=\"paginate_button previous\"><a href=\"").append(url).append("index=").append(prevPage).append("&size=").append(size).append("\">上一页</a></li>\n");
        } else {
            sb.append("<li class=\"paginate_button previous disabled\"><a href=\"#\">上一页</a></li>\n");
        }
        for (int i = startPage; i <= endPage; i++) {
            if (i == index) {
                sb.append(String.format("<li class=\"paginate_button active\"><a href=\"#\">%d</a></li>\n", i));
            } else {
                sb.append("<li class=\"paginate_button").append("\"><a href=\"").append(url).append("index=").append(i).append("&size=").append(size).append("\">").append(i).append("</a></li>\n");
                //sb.append("<li class=\"paginate_button").append("\"><a href=\"").append(String.format(url, i)).append("\">").append(i).append("</a></li>\n");
            }
        }
        if (hasNext) {
            sb.append("<li class=\"paginate_button next\"><a href=\"").append(url).append("index=").append(nextPage).append("&size=").append(size).append("\">下一页</a></li>\n");
        } else {
            sb.append("<li class=\"paginate_button next disabled\"><a href=\"#\">下一页</a></li>\n");
        }
        sb.append("</ul>\n");
        sb.append("</div>\n");
        return sb.toString();
    }
}