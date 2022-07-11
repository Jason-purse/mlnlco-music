package club.smileboy.app.mlnlco.service.lambda;

import club.smileboy.app.mlnlco.model.entity.UserEntity;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 12:00
 * @description mybatis plus lambda测试
 **/
public class serializableTests {
    @Test
    public void test(){
        final SFunction<UserEntity, Date> getCreateTime = UserEntity::getCreateTime;
        System.out.println(SerializedLambda.extract(getCreateTime));
    }
}
