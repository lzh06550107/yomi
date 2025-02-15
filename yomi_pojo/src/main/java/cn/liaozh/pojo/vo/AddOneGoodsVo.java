package cn.liaozh.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AddOneGoodsVo {
    @NotEmpty(
            message = "标题不能为空"
    )
    private String title;

    @NotEmpty(
            message = "内容描述不能为空"
    )
    @Length(
            max = 500,
            message = "内容不能大于500字"
    )
    private String content;

    @NotEmpty(
            message = "类型不能为空"
    )
    private String familyId;

    private String[] imageLink;

    @NotNull(
            message = "价格不能为空"
    )
    private Double price;

    private String contact;
}

