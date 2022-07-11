package club.smileboy.app.mlnlco.model.vo;

import club.smileboy.app.mlnlco.model.params.common.DefaultMediaResource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 8:49
 * @description 默认媒体资源抽象
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class DefaultMediaResourceVo extends DefaultMediaResource implements MediaResourceVo {

}
