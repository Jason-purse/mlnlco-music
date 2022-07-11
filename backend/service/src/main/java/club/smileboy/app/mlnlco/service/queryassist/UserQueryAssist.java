package club.smileboy.app.mlnlco.service.queryassist;

import club.smileboy.app.mlnlco.model.entity.UserEntity;
import club.smileboy.app.mlnlco.model.params.query.user.UserQuery;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author JASONJ
 * @date 2022/7/9
 * @time 12:10
 * @description 用户查询助手,拼接查询参数 ... 利用java lambda ...
 **/
public class UserQueryAssist {

    /**
     *  根据邮箱 / 用户名 / 昵称 / 注册时间进行用户查询
     * @param query 查询参数
     * @param userType 角色类型 - 字典对应的id
     * @return query
     */
    @NotNull
    public static LambdaQueryWrapper<UserEntity> findAllUsersQueryAssist(@NotNull UserQuery query,Long userType) {
        val lambdaQueryWrapper = new LambdaQueryWrapper<>(UserEntity.class);

        lambdaQueryWrapper.eq(UserEntity::getUserType,userType);

        if(StringUtils.hasText(query.getEmail())) {
            lambdaQueryWrapper.eq(UserEntity::getEmail, query.getEmail());
            return lambdaQueryWrapper;
        }

        if(StringUtils.hasText(query.getUserName())) {
            lambdaQueryWrapper.eq(UserEntity::getUserName,query.getUserName());
            return lambdaQueryWrapper;
        }

        if(Objects.nonNull(query.getStartTime()) && Objects.nonNull(query.getEndTime())) {
            lambdaQueryWrapper.between(UserEntity::getCreateTime,query.getStartTime(),query.getEndTime());
        }
        else {
            if(Objects.nonNull(query.getStartTime())) {
                lambdaQueryWrapper.ge(UserEntity::getCreateTime,query.getStartTime());
            }

            if(Objects.nonNull(query.getEndTime())) {
                lambdaQueryWrapper.le(UserEntity::getCreateTime,query.getEndTime());
            }
        }

        // nickName
        if(StringUtils.hasText(query.getNickName())) {
            lambdaQueryWrapper.likeLeft(UserEntity::getNickName,query.getNickName());
        }

        return lambdaQueryWrapper;
    }

    /**
     * 根据Id 查询 用户信息,包括管理员的Query
     * @param id id
     * @return Query
     */
    @Nullable
    public static Wrapper<UserEntity> createIdQuery(@NotNull Long id) {
        return new LambdaQueryWrapper<>(UserEntity.class).eq(UserEntity::getId,id);
    }

    /**
     * 根据邮箱信息,创建一个Query,用于用户查询
     * @param email 邮箱信息
     * @return Query
     */
    @Nullable
    public static Wrapper<UserEntity> createEmailQuery(@NotNull  String email) {
        return new LambdaQueryWrapper<>(UserEntity.class).eq(UserEntity::getEmail,email);
    }
}
