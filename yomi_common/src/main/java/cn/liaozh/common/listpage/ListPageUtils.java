package cn.liaozh.common.listpage;

import cn.liaozh.common.constant.Constants;
import cn.liaozh.pojo.vo.IntactArticleVos;
import cn.liaozh.pojo.vo.PaginationVO;

import java.util.ArrayList;
import java.util.List;

public class ListPageUtils {
    public ListPageUtils() {
    }

    public static PaginationVO listPage(List<IntactArticleVos> list, Integer page) {
        page = page <= 0 ? 1 : page;
        PaginationVO paginationVO = new PaginationVO();
        List<IntactArticleVos> articleVos = new ArrayList();
        if (list.size() <= 0) {
            return null;
        } else {
            page = pageSum(list.size(), Constants.pageSize) > page ? page : pageSum(list.size(), Constants.pageSize);
            int num = Constants.pageSize * page;

            for(int i = num - Constants.pageSize; i < num && i < list.size(); ++i) {
                articleVos.add(list.get(i));
            }

            paginationVO.setList(articleVos);
            paginationVO.setTotalCount(list.size());
            paginationVO.setTotalPage(pageSum(list.size(), Constants.pageSize));
            paginationVO.setPageSize(Constants.pageSize);
            paginationVO.setCurrentPage(page);
            return paginationVO;
        }
    }

    public static int pageSum(int sumDatas, int perPageDatas) {
        int totalPage = sumDatas / perPageDatas;
        if (sumDatas % perPageDatas != 0) {
            ++totalPage;
        }

        return totalPage;
    }
}
