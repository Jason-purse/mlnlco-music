package club.smileboy.app.mlnlco.model.params.query.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 8:40
 * @description 默认资源参数
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class DefaultResourceQuery implements ResourceQuery {
    /**
     * 资源类型
     */
    private String resourceType;

}
