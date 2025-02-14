package cn.liaozh.pojo.vo;

import java.util.List;

public class PaginationVO {
    private int pageSize;
    private int currentPage;
    private int totalPage;
    private int totalCount;
    private List<?> list;

    public PaginationVO(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public static PaginationVO pageBuild(int currentPage, int pageSize) {
        return new PaginationVO((currentPage - 1) * pageSize, pageSize);
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<?> getList() {
        return this.list;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(final int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(final int totalPage) {
        this.totalPage = totalPage;
    }

    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
    }

    public void setList(final List<?> list) {
        this.list = list;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PaginationVO)) {
            return false;
        } else {
            PaginationVO other = (PaginationVO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else if (this.getCurrentPage() != other.getCurrentPage()) {
                return false;
            } else if (this.getTotalPage() != other.getTotalPage()) {
                return false;
            } else if (this.getTotalCount() != other.getTotalCount()) {
                return false;
            } else {
                Object this$list = this.getList();
                Object other$list = other.getList();
                if (this$list == null) {
                    if (other$list != null) {
                        return false;
                    }
                } else if (!this$list.equals(other$list)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PaginationVO;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getPageSize();
        result = result * 59 + this.getCurrentPage();
        result = result * 59 + this.getTotalPage();
        result = result * 59 + this.getTotalCount();
        Object $list = this.getList();
        result = result * 59 + ($list == null ? 43 : $list.hashCode());
        return result;
    }

    public String toString() {
        return "PaginationVO(pageSize=" + this.getPageSize() + ", currentPage=" + this.getCurrentPage() + ", totalPage=" + this.getTotalPage() + ", totalCount=" + this.getTotalCount() + ", list=" + this.getList() + ")";
    }

    public PaginationVO() {
    }
}

