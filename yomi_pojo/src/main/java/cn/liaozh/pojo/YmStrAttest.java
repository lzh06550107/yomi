package cn.liaozh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class YmStrAttest {
    @TableId(
        value = "str_attest_id",
        type = IdType.ASSIGN_ID
    )
    private String strAttestId;

    private String strName;

    private int strNumber;

    private String userId;

    private Integer authState;
}
