package cn.liaozh.pojo.vo;

import cn.liaozh.pojo.YmArticleImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ImageVo {

    private String articleImageId;
    private String imageLink;

    public ImageVo(YmArticleImage ymArticleImage) {
        if (!Objects.isNull(ymArticleImage)) {
            this.articleImageId = ymArticleImage.getArticleImageId();
            this.imageLink = ymArticleImage.getImageLink();
        }

    }
}

