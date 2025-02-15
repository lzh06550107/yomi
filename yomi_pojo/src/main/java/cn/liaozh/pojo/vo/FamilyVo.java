package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmArticleFamily;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FamilyVo {

    private String familyId;
    private String familyName;

    public FamilyVo(YmArticleFamily ymArticleFamily) {
        this.familyId = ymArticleFamily.getFamilyId();
        this.familyName = ymArticleFamily.getFamilyName();
    }
}
