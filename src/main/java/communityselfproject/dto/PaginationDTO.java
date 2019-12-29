package communityselfproject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qwj
 * @version 1.0
 * @date 2019/12/25 15:09
 */
@Data
public class PaginationDTO {
    private List<ArticleDTO> articleDTOS;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private Integer totalPage;
    private Integer count;
    private List<Integer> pages = new ArrayList<>();


    public void setPagination(Integer count,Integer totalPage, Integer page) {
        this.count = count;
        this.totalPage = totalPage;
        page = page<1 ? 1: page;
        page = page>totalPage ? totalPage: page;
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        showPrevious = page != 1;

        showNext = !page.equals(totalPage);

        showFirstPage = !pages.contains(1);

        showEndPage = !pages.contains(totalPage);

    }
}
