package cn.liaozh.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
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
}

